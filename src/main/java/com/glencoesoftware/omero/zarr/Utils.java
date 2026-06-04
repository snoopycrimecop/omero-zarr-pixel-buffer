/*
 * Copyright (C) 2026 Glencoe Software, Inc. All rights reserved.
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */

package com.glencoesoftware.omero.zarr;

import java.util.List;
import java.util.Map;

/**
 * Utility methods for safe, centralized handling of generic casts used by
 * OMERO Zarr classes.
 */
public abstract class Utils {

    /**
     * Casts an {@link Object} to {@code Map<String, Object>} with basic runtime
     * type checks.
     *
     * @param value the value to cast
     * @return the value cast to {@code Map<String, Object>}
     * @throws IllegalArgumentException if {@code value} is {@code null} or not a
     *                                  {@link Map}
     */
    @SuppressWarnings("unchecked")
    public static Map<String, Object> castToStringObjectMap(Object value) {
        if (value == null) {
            throw new IllegalArgumentException("Expected non-null Map value");
        }
        if (!(value instanceof Map)) {
            throw new IllegalArgumentException(
                "Expected Map but was " + value.getClass().getName());
        }
        return (Map<String, Object>) value;
    }

    /**
     * Casts an {@link Object} to {@code List<Map<String, Object>>} with basic
     * runtime type checks.
     *
     * @param value the value to cast
     * @return the value cast to {@code List<Map<String, Object>>}
     * @throws IllegalArgumentException if {@code value} is {@code null}, not a
     *                                  {@link List}, or contains non-Map
     *                                  elements
     */
    @SuppressWarnings("unchecked")
    public static List<Map<String, Object>> castToListOfObjectMap(Object value) {
        if (value == null) {
            throw new IllegalArgumentException("Expected non-null List value");
        }
        if (!(value instanceof List)) {
            throw new IllegalArgumentException(
                "Expected List but was " + value.getClass().getName());
        }
        for (Object element : (List<?>) value) {
            if (!(element instanceof Map)) {
                throw new IllegalArgumentException("List must contain only Map elements");
            }
        }
        return (List<Map<String, Object>>) value;
    }

    /**
     * Casts an {@link Object} to {@code List<Map<String, String>>} with basic
     * runtime type checks.
     *
     * @param value the value to cast
     * @return the value cast to {@code List<Map<String, String>>}
     * @throws IllegalArgumentException if {@code value} is {@code null}, not a
     *                                  {@link List}, or contains non-Map
     *                                  elements
     */
    @SuppressWarnings("unchecked")
    public static List<Map<String, String>> castToListOfStringMap(Object value) {
        if (value == null) {
            throw new IllegalArgumentException("Expected non-null List value");
        }
        if (!(value instanceof List)) {
            throw new IllegalArgumentException(
                "Expected List but was " + value.getClass().getName());
        }
        for (Object element : (List<?>) value) {
            if (!(element instanceof Map)) {
                throw new IllegalArgumentException(
                    "List must contain only Map elements with String keys");
            }
        }
        return (List<Map<String, String>>) value;
    }

}
