package com.zzzkvidi4.library.controller;

import org.jetbrains.annotations.NotNull;

/**
 * Factory to create library.
 */
public final class LibraryFactory {
    private LibraryFactory() {
        //nothing to do
    }

    /**
     * Method to create library.
     *
     * @return - some library implementation
     */
    @NotNull public static Library createLibrary() {
        return new InMemoryLibrary();
    }
}
