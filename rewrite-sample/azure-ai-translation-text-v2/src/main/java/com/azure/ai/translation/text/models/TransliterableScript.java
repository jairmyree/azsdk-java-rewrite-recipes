// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.ai.translation.text.models;

import com.azure.core.v2.annotation.Generated;
import com.azure.core.v2.annotation.Immutable;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.List;

/**
 * Script definition with list of script into which given script can be translitered.
 */
@Immutable
public final class TransliterableScript extends LanguageScript {
    /*
     * List of scripts available to convert text to.
     */
    @Generated
    private final List<LanguageScript> targetLanguageScripts;

    /**
     * Creates an instance of TransliterableScript class.
     * 
     * @param code the code value to set.
     * @param name the name value to set.
     * @param nativeName the nativeName value to set.
     * @param directionality the directionality value to set.
     * @param targetLanguageScripts the targetLanguageScripts value to set.
     */
    @Generated
    private TransliterableScript(String code, String name, String nativeName, LanguageDirectionality directionality,
        List<LanguageScript> targetLanguageScripts) {
        super(code, name, nativeName, directionality);
        this.targetLanguageScripts = targetLanguageScripts;
    }

    /**
     * Get the targetLanguageScripts property: List of scripts available to convert text to.
     * 
     * @return the targetLanguageScripts value.
     */
    @Generated
    public List<LanguageScript> getTargetLanguageScripts() {
        return this.targetLanguageScripts;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("code", getCode());
        jsonWriter.writeStringField("name", getName());
        jsonWriter.writeStringField("nativeName", getNativeName());
        jsonWriter.writeStringField("dir", getDirectionality() == null ? null : getDirectionality().toString());
        jsonWriter.writeArrayField("toScripts", this.targetLanguageScripts,
            (writer, element) -> writer.writeJson(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of TransliterableScript from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of TransliterableScript if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the TransliterableScript.
     */
    @Generated
    public static TransliterableScript fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            String code = null;
            String name = null;
            String nativeName = null;
            LanguageDirectionality directionality = null;
            List<LanguageScript> targetLanguageScripts = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("code".equals(fieldName)) {
                    code = reader.getString();
                } else if ("name".equals(fieldName)) {
                    name = reader.getString();
                } else if ("nativeName".equals(fieldName)) {
                    nativeName = reader.getString();
                } else if ("dir".equals(fieldName)) {
                    directionality = LanguageDirectionality.fromString(reader.getString());
                } else if ("toScripts".equals(fieldName)) {
                    targetLanguageScripts = reader.readArray(reader1 -> LanguageScript.fromJson(reader1));
                } else {
                    reader.skipChildren();
                }
            }
            return new TransliterableScript(code, name, nativeName, directionality, targetLanguageScripts);
        });
    }
}