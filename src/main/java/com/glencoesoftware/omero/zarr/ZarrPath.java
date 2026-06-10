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

import java.util.Objects;

/**
 * This class represents a path within a specific Zarr store.
 */
public class ZarrPath {

    /** The Zarr store to which this path belongs. */
    public final ZarrStore store;

    /** The path within the Zarr store. */
    public final String path;

    /**
     * Constructs a ZarrPath from a ZarrStore and a path string.
     *
     * @param store the ZarrStore to which this path belongs
     * @param path  the path within the Zarr store
     */
    public ZarrPath(ZarrStore store, String path) {
        this.store = store;
        this.path = path;
    }

    /**
     * Compares this ZarrPath to another object for equality.
     *
     * @param obj the object to compare to
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ZarrPath)) {
            return false;
        }
        ZarrPath other = (ZarrPath) obj;
        return Objects.equals(store, other.store) && Objects.equals(path, other.path);
    }

    /**
     * Returns a hash code value for this ZarrPath.
     *
     * @return a hash code value for this ZarrPath
     */
    @Override
    public int hashCode() {
        return Objects.hash(store, path);
    }

    /**
     * Returns a string representation of this ZarrPath.
     *
     * @return a string representation of this ZarrPath
     */
    @Override
    public String toString() {
        return "ZarrPath{" + "store=" + store + ", path='" + path + '\'' + '}';
    }

}
