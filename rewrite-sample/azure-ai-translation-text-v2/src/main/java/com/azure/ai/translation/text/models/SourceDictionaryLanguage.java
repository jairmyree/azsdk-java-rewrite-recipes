// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.ai.translation.text.models;

import com.azure.core.v2.annotation.Generated;
import com.azure.core.v2.annotation.Immutable;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.List;

/**
 * Properties ot the source dictionary language.
 */
@Immutable
public final class SourceDictionaryLanguage implements JsonSerializable<SourceDictionaryLanguage> {
    /*
     * Display name of the language in the locale requested via Accept-Language header.
     */
    @Generated
    private final String name;

    /*
     * Display name of the language in the locale native for this language.
     */
    @Generated
    private final String nativeName;

    /*
     * Directionality, which is rtl for right-to-left languages or ltr for left-to-right languages.
     */
    @Generated
    private final LanguageDirectionality directionality;

    /*
     * List of languages with alterative translations and examples for the query expressed in the source language.
     */
    @Generated
    private final List<TargetDictionaryLanguage> translations;

    /**
     * Creates an instance of SourceDictionaryLanguage class.
     * 
     * @param name the name value to set.
     * @param nativeName the nativeName value to set.
     * @param directionality the directionality value to set.
     * @param translations the translations value to set.
     */
    @Generated
    private SourceDictionaryLanguage(String name, String nativeName, LanguageDirectionality directionality,
        List<TargetDictionaryLanguage> translations) {
        this.name = name;
        this.nativeName = nativeName;
        this.directionality = directionality;
        this.translations = translations;
    }

    /**
     * Get the name property: Display name of the language in the locale requested via Accept-Language header.
     * 
     * @return the name value.
     */
    @Generated
    public String getName() {
        return this.name;
    }

    /**
     * Get the nativeName property: Display name of the language in the locale native for this language.
     * 
     * @return the nativeName value.
     */
    @Generated
    public String getNativeName() {
        return this.nativeName;
    }

    /**
     * Get the directionality property: Directionality, which is rtl for right-to-left languages or ltr for
     * left-to-right languages.
     * 
     * @return the directionality value.
     */
    @Generated
    public LanguageDirectionality getDirectionality() {
        return this.directionality;
    }

    /**
     * Get the translations property: List of languages with alterative translations and examples for the query
     * expressed in the source language.
     * 
     * @return the translations value.
     */
    @Generated
    public List<TargetDictionaryLanguage> getTranslations() {
        return this.translations;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("name", this.name);
        jsonWriter.writeStringField("nativeName", this.nativeName);
        jsonWriter.writeStringField("dir", this.directionality == null ? null : this.directionality.toString());
        jsonWriter.writeArrayField("translations", this.translations, (writer, element) -> writer.writeJson(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of SourceDictionaryLanguage from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of SourceDictionaryLanguage if the JsonReader was pointing to an instance of it, or null if
     * it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the SourceDictionaryLanguage.
     */
    @Generated
    public static SourceDictionaryLanguage fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            String name = null;
            String nativeName = null;
            LanguageDirectionality directionality = null;
            List<TargetDictionaryLanguage> translations = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("name".equals(fieldName)) {
                    name = reader.getString();
                } else if ("nativeName".equals(fieldName)) {
                    nativeName = reader.getString();
                } else if ("dir".equals(fieldName)) {
                    directionality = LanguageDirectionality.fromString(reader.getString());
                } else if ("translations".equals(fieldName)) {
                    translations = reader.readArray(reader1 -> TargetDictionaryLanguage.fromJson(reader1));
                } else {
                    reader.skipChildren();
                }
            }
            return new SourceDictionaryLanguage(name, nativeName, directionality, translations);
        });
    }
}