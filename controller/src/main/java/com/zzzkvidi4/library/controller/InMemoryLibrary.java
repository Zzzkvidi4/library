package com.zzzkvidi4.library.controller;

import com.zzzkvidi4.library.models.Author;
import com.zzzkvidi4.library.models.Book;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

import static java.util.stream.Collectors.toSet;

/**
 * In-memory implementation of {@link Library}.
 */
public final class InMemoryLibrary implements Library {
    @NotNull
    private static final Map<Author, List<Book>> BOOKS = new HashMap<>();

    static {
        addAuthorWithBooks(
                "Sergei",
                "Vasilevich",
                "Lukianenko",
                "Threshold",
                "Genom",
                "Spectr"
        );
        addAuthorWithBooks(
                "Oleg",
                "Dmitrievich",
                "Divov",
                "Profession inquizitor"
        );
        addAuthorWithBooks(
                "George",
                null,
                "Orwell",
                "1984"
        );
    }

    /**
     * Method to add author with books to in-memory storage.
     *
     * @param firstName  - author's first name
     * @param middleName - author's middle name
     * @param lastName   - author's last name
     * @param books      - book names
     */
    private static void addAuthorWithBooks(@NotNull String firstName, @Nullable String middleName, @NotNull String lastName, @NotNull String... books) {
        Author author = new Author(firstName, lastName, middleName);
        List<Book> bookList = BOOKS.computeIfAbsent(author, k -> new LinkedList<>());
        for (String bookName : books) {
            bookList.add(new Book(bookName));
        }
    }

    /**
     * Method to get books by author query.
     *
     * @param authorQuery - author query
     * @return - books of specified authors
     */
    @NotNull
    @Override
    public List<Book> getBooksByAuthor(@NotNull String authorQuery) {
        Set<Author> authors = new HashSet<>();
        Set<String> terms = Arrays.stream(authorQuery.toLowerCase().split("\\s+"))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .collect(toSet());
        for (Author author : BOOKS.keySet()) {
            for (String term : terms) {
                if (author.getFirstName().toLowerCase().contains(term)
                        || author.getLastName().toLowerCase().contains(term)
                        || (author.getMiddleName() != null && author.getMiddleName().toLowerCase().contains(term))) {
                    authors.add(author);
                }
            }
        }

        List<Book> books = new LinkedList<>();
        for (Author author : authors) {
            books.addAll(BOOKS.get(author));
        }
        return books;
    }
}
