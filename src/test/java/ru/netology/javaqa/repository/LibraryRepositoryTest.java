package ru.netology.javaqa.repository;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.javaqa.domain.Book;

class LibraryRepositoryTest {
    private LibraryRepository libraryRepository;
    private Book book1;
    private Book book2;

    @BeforeEach
    void setUp() {
        libraryRepository = LibraryRepository.getInstance();
        book1 = new Book("1984", "George Orwell");
        book2 = new Book("To Kill a Mockingbird", "Harper Lee");

        // Clear library for each test
        libraryRepository.clearBooks();
        libraryRepository.addBook(book1);
        libraryRepository.addBook(book2);
    }

    @Test
    void testSingletonInstance() {
        LibraryRepository anotherInstance = LibraryRepository.getInstance();
        assertSame(libraryRepository, anotherInstance);
    }

    @Test
    void testAddBook() {
        Book newBook = new Book("Brave New World", "Aldous Huxley");
        libraryRepository.addBook(newBook);
        assertEquals(newBook, libraryRepository.findBookByTitle("Brave New World"));
    }

    @Test
    void testFindBookByTitle() {
        assertEquals(book1, libraryRepository.findBookByTitle("1984"));
        assertEquals(book2, libraryRepository.findBookByTitle("To Kill a Mockingbird"));
    }

    @Test
    void testFindBookByTitleNotFound() {
        assertNull(libraryRepository.findBookByTitle("Nonexistent Book"));
    }
}
