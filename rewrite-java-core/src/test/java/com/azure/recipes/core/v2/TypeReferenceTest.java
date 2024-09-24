package com.azure.recipes.core.v2;

import org.intellij.lang.annotations.Language;
import org.junit.jupiter.api.Test;
import org.openrewrite.test.RecipeSpec;
import org.openrewrite.test.RewriteTest;
import org.openrewrite.test.TypeValidation;

import static org.openrewrite.java.Assertions.java;

/**
 * TypeReferenceTest is used to test out the recipe that changes the usage of TypeReference (azure core v1)
 * to ParameterizedType (azure core v2)
 * @author Ali Soltanian Fard Jahromi
 */
public class TypeReferenceTest implements RewriteTest {

    /**
     * This method sets which recipe should be used for testing
     * @param spec stores settings for testing environment; e.g. which recipes to use for testing
     */
    @Override
    public void defaults(RecipeSpec spec) {
        spec.recipeFromResource("/META-INF/rewrite/rewrite.yml",
                "com.azure.rewrite.java.core.MigrateAzureCoreSamplesToAzureCoreV2");
        // Added due to bug in OpenRewrite parser when parsing azure TypeReference instantiation
        spec.typeValidationOptions(TypeValidation.none());
    }

    /**
     * This test method is used to make sure that TypeReference is correctly
     * changed to ParameterizedType when using List generic type
     */
    @Test
    void testTypeReferenceVariableDeclarationChangeList() {
        @Language("java") String before = "";
        before += "\nimport java.lang.reflect.ParameterizedType;";
        before += "\nimport java.lang.reflect.Type;";
        before += "\nimport java.util.List;";
        before += "\nimport com.azure.core.util.serializer.TypeReference;";
        before += "\npublic class Testing {";
        before += "\n  private static final TypeReference<List<String>> TESTING_TYPE = new TypeReference<List<String>>() {\n  };";
        before += "\n}";


        @Language("java") String after = "import java.lang.reflect.ParameterizedType;\n" +
                "import java.lang.reflect.Type;\n" +
                "import java.util.List;\n"+
                "public class Testing {\n" +
                "  private static final Type TESTING_TYPE = new ParameterizedType() {\n" +
                "      @Override\n" +
                "      public Type getRawType() {\n" +
                "          return List.class;\n" +
                "      }\n\n" +
                "      @Override\n" +
                "      public Type[] getActualTypeArguments() {\n" +
                "          return new Type[]{String.class};\n" +
                "      }\n\n" +
                "      @Override\n" +
                "      public Type getOwnerType() {\n" +
                "          return null;\n" +
                "      }\n" +
                "  };\n" +
                "}\n";

        rewriteRun(
                spec -> spec.cycles(2)
                        .expectedCyclesThatMakeChanges(2),
                java(before,after)
        );
    }
    /**
     * This test method is used to make sure that TypeReference is correctly
     * changed to ParameterizedType when using Map generic type
     */
    @Test
    void testTypeReferenceVariableDeclarationChangeMap() {
        @Language("java") String before = "";
        before += "\nimport java.lang.reflect.ParameterizedType;";
        before += "\nimport java.lang.reflect.Type;";
        before += "\nimport java.util.Map;";
        before += "\nimport com.azure.core.util.serializer.TypeReference;";
        before += "\npublic class Testing {";
        before += "\n  private static final TypeReference<java.util.Map<String, Integer>> TESTING_TYPE = new TypeReference<java.util.Map<String, Integer>>() {\n  };";
        before += "\n}";


        @Language("java") String after = "import java.lang.reflect.ParameterizedType;\n" +
                "import java.lang.reflect.Type;\n" +
                "import java.util.Map;\n" +
                "public class Testing {\n" +
                "  private static final Type TESTING_TYPE = new ParameterizedType() {\n" +
                "      @Override\n" +
                "      public Type getRawType() {\n" +
                "          return Map.class;\n" +
                "      }\n\n" +
                "      @Override\n" +
                "      public Type[] getActualTypeArguments() {\n" +
                "          return new Type[]{String.class, Integer.class};\n" +
                "      }\n\n" +
                "      @Override\n" +
                "      public Type getOwnerType() {\n" +
                "          return null;\n" +
                "      }\n" +
                "  };\n" +
                "}\n";

        rewriteRun(
                spec -> spec.cycles(2)
                        .expectedCyclesThatMakeChanges(2),
                java(before,after)
        );
    }
    /**
     * This test method is used to make sure that TypeReference is correctly
     * changed to ParameterizedType when using non-generic type
     */
    @Test
    void testTypeReferenceVariableDeclarationChangeNonGeneric() {
        @Language("java") String before = "";
        before += "\nimport java.lang.reflect.ParameterizedType;";
        before += "\nimport java.lang.reflect.Type;";
        before += "\nimport com.azure.core.util.serializer.TypeReference;";
        before += "\npublic class Testing {";
        before += "\n  private static final TypeReference<String> TESTING_TYPE = new TypeReference<String>() {\n  };";
        before += "\n}";


        @Language("java") String after = "import java.lang.reflect.ParameterizedType;\n" +
                "import java.lang.reflect.Type;\n" +
                "public class Testing {\n" +
                "  private static final Type TESTING_TYPE = new ParameterizedType() {\n" +
                "      @Override\n" +
                "      public Type getRawType() {\n" +
                "          return String.class;\n" +
                "      }\n\n" +
                "      @Override\n" +
                "      public Type[] getActualTypeArguments() {\n" +
                "          return new Type[]{};\n" +
                "      }\n\n" +
                "      @Override\n" +
                "      public Type getOwnerType() {\n" +
                "          return null;\n" +
                "      }\n" +
                "  };\n" +
                "}\n";

        rewriteRun(
                spec -> spec.cycles(2)
                        .expectedCyclesThatMakeChanges(2),
                java(before,after)
        );
    }
}