// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.ai.translation.text.models;

import com.azure.core.annotation.Generated;
import com.azure.core.annotation.Immutable;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * An object describing the detected language.
 */
@Immutable
public final class DetectedLanguage implements JsonSerializable<DetectedLanguage> {
    /*
     * A string representing the code of the detected language.
     */
    @Generated
    private final String language;

    /*
     * A float value indicating the confidence in the result.
     * The score is between zero and one and a low score indicates a low confidence.
     */
    @Generated
    private final double confidence;

    /**
     * Creates an instance of DetectedLanguage class.
     * 
     * @param language the language value to set.
     * @param confidence the confidence value to set.
     */
    @Generated
    private DetectedLanguage(String language, double confidence) {
        this.language = language;
        this.confidence = confidence;
    }

    /**
     * Get the language property: A string representing the code of the detected language.
     * 
     * @return the language value.
     */
    @Generated
    public String getLanguage() {
        return this.language;
    }

    /**
     * Get the confidence property: A float value indicating the confidence in the result.
     * The score is between zero and one and a low score indicates a low confidence.
     * 
     * @return the confidence value.
     */
    @Generated
    public double getConfidence() {
        return this.confidence;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("language", this.language);
        jsonWriter.writeDoubleField("score", this.confidence);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of DetectedLanguage from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of DetectedLanguage if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the DetectedLanguage.
     */
    @Generated
    public static DetectedLanguage fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            String language = null;
            double confidence = 0.0;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("language".equals(fieldName)) {
                    language = reader.getString();
                } else if ("score".equals(fieldName)) {
                    confidence = reader.getDouble();
                } else {
                    reader.skipChildren();
                }
            }
            return new DetectedLanguage(language, confidence);
        });
    }
}