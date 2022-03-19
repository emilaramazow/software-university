package com.example.springintro.service;

import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.BookSummary;
import com.example.springintro.model.entity.EditionType;

import java.io.IOException;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> findAllBooksAfterYear(int year);

    List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year);

    List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName);

    List<String> findByAgeRestriction(String ageRestriction);

    List<String> findAllTitlesByEditionAndCopies(EditionType type, int copies);

    List<Book> findAllWithPriceBetween(float lowerBound, float upperBound);

    List<Book> findNotReleaseIn(int releaseYear);

    List<Book> findBooksReleasedBefore(String date);

    List<String> findAllTitlesContaining(String search);

    List<Book> findByAuthorLastNameStartsWith(String search);

    int countBooksWithTitleLongerThan(int length);

    BookSummary getInformationForTitle(String title);
}
