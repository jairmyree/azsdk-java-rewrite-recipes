package com.azure.recipes.core.v2;

import org.intellij.lang.annotations.Language;
import org.junit.jupiter.api.Test;
import org.openrewrite.test.RecipeSpec;
import org.openrewrite.test.RewriteTest;

import static org.openrewrite.java.Assertions.java;

/**
 * ContextTest is used to test out the recipe that converts code to use the
 * new clientcore Context class.
 * @author Ali Soltanian Fard Jahromi
 */
public class ContextTest implements RewriteTest {

    /**
     * This method sets which recipe should be used for testing
     * @param spec stores settings for testing environment; e.g. which recipes to use for testing
     */
    @Override
    public void defaults(RecipeSpec spec) {
        spec.recipeFromResource("/META-INF/rewrite/rewrite.yml",
                "com.azure.rewrite.java.core.MigrateAzureCoreSamplesToAzureCoreV2");
    }

    /**
     * This test method is used to make sure that the Context class is updated
     */
    @Test
    void testImportReplaceContext() {
        @Language("java") String before = "import com.azure.core.util.Context;";
        before += "\npublic class Testing {";
        before += "\n  public Testing(){}";
        before += "\n}";

        @Language("java") String after = "import io.clientcore.core.util.Context;";
        after += "\npublic class Testing {";
        after += "\n  public Testing(){}";
        after += "\n}";
        rewriteRun(
                java(before,after)
        );
    }
}