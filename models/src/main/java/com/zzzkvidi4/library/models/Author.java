package com.zzzkvidi4.library.models;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Author entity.
 */
@Getter
@EqualsAndHashCode
@AllArgsConstructor
@RequiredArgsConstructor
public final class Author {
    @NotNull
    private final String firstName;
    @NotNull
    private final String lastName;
    @Nullable
    private String middleName;
}
