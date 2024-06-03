package ru.netology.javaqa.repository;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.javaqa.domain.Book;

class LibraryTest {
    private Library library;
    private Book book1;
    private Book book2;

    @BeforeEach
    void setUp() {
        library = Library.getInstance();
        book1 = new Book("1984", "George Orwell");
        book2 = new Book("To Kill a Mockingbird", "Harper Lee");

        // Clear library for each test
        library.clearBooks();
        library.addBook(book1);
        library.addBook(book2);
    }

    @Test
    void testSingletonInstance() {
        Library anotherInstance = Library.getInstance();
        assertSame(library, anotherInstance);
    }

    @Test
    void testAddBook() {
        Book newBook = new Book("Brave New World", "Aldous Huxley");
        library.addBook(newBook);
        assertEquals(newBook, library.findBookByTitle("Brave New World"));
    }

    @Test
    void testFindBookByTitle() {
        assertEquals(book1, library.findBookByTitle("1984"));
        assertEquals(book2, library.findBookByTitle("To Kill a Mockingbird"));
    }

    @Test
    void testFindBookByTitleNotFound() {
        assertNull(library.findBookByTitle("Nonexistent Book"));
    }
}
