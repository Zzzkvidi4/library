package com.zzzkvidi4.library.controller;

import com.google.gson.Gson;
import com.zzzkvidi4.library.models.Book;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Entry point of application.
 */
public final class LibraryLauncher {
    public static void main(@NotNull String[] args) {
        System.out.println("Input author name: ");
        String query;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            do {
                System.out.print("> ");
                query = reader.readLine();
            } while (query == null || query.isEmpty());
        } catch (IOException e) {
            throw new RuntimeException("Something went wrong...");
        }

        Library library = LibraryFactory.createLibrary();
        List<Book> books = library.getBooksByAuthor(query);

        if (books.isEmpty()) {
            System.out.println("Not found books.");
        } else {
            Gson gson = new Gson();
            System.out.println(gson.toJson(books));
        }
    }
}
