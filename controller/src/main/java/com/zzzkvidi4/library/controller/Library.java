package com.zzzkvidi4.library.controller;

import com.zzzkvidi4.library.models.Book;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Interface of library.
 */
public interface Library {
    /**
     * Method to retrieve books from library.
     *
     * @param author - part of authors name
     * @return       - list of books by author
     */
    @NotNull
    List<Book> getBooksByAuthor(@NotNull String author);
}
