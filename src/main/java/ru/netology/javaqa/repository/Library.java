package ru.netology.javaqa.repository;

import ru.netology.javaqa.domain.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * Singleton class representing the library.
 */
public class Library {
    private static Library instance; // Singleton instance of the library
    private final List<Book> books;  // List of books in the library

    /**
     * Private constructor to prevent instantiation.
     */
    private Library() {
        this.books = new ArrayList<>();
    }

    /**
     * Gets the singleton instance of the library.
     *
     * @return The singleton instance of the library.
     */
    public static synchronized Library getInstance() {
        if (instance == null) { // Create the instance if it doesn't exist
            instance = new Library();
        }
        return instance;
    }

    /**
     * Adds a book to the library.
     *
     * @param book The book to add.
     */
    public void addBook(Book book) {
        books.add(book);
    }

    /**
     * Finds a book by title.
     *
     * @param title The title of the book to find.
     * @return The book with the given title, or null if not found.
     */
    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) { // Check if the title matches
                return book;
            }
        }
        return null; // Return null if not found
    }

    /**
     * Clears all books from the library.
     * This method is useful for resetting the library state during tests.
     */
    public void clearBooks() {
        books.clear();
    }
}
