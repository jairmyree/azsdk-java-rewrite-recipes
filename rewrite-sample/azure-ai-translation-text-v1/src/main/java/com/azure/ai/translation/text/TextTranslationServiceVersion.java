// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.ai.translation.text;

import com.azure.core.util.ServiceVersion;

/**
 * Service version of TextTranslationClient.
 */
public enum TextTranslationServiceVersion implements ServiceVersion {
    /**
     * Enum value 3.0.
     */
    V3_0("3.0");

    private final String version;

    TextTranslationServiceVersion(String version) {
        this.version = version;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getVersion() {
        return this.version;
    }

    /**
     * Gets the latest service version supported by this client library.
     * 
     * @return The latest {@link TextTranslationServiceVersion}.
     */
    public static TextTranslationServiceVersion getLatest() {
        return V3_0;
    }
}
