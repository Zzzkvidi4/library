package com.zzzkvidi4.library.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

/**
 * Book entity.
 */
@Getter
@AllArgsConstructor
public final class Book {
    @NotNull
    private final String name;
}
