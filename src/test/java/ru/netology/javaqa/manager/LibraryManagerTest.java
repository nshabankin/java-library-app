package ru.netology.javaqa.manager;

import ru.netology.javaqa.domain.Book;
import ru.netology.javaqa.domain.Member;
import ru.netology.javaqa.exceptions.AlreadyLoanedException;
import ru.netology.javaqa.exceptions.NotLoanedException;
import ru.netology.javaqa.repository.LibraryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryManagerTest {
    private LibraryRepository libraryRepository;
    private Member member1;
    private Member member2;

    @BeforeEach
    void setUp() {
        libraryRepository = LibraryRepository.getInstance();
        libraryRepository.clearBooks();

        member1 = new Member("Alice");
        member2 = new Member("Bob");

        LibraryManager.setupLibrary(libraryRepository);
    }

    @Test
    void testSetupLibrary() {
        assertNotNull(libraryRepository.findBookByTitle("1984"));
        assertNotNull(libraryRepository.findBookByTitle("To Kill a Mockingbird"));
    }

    @Test
    void testLoanBook() {
        Book book = libraryRepository.findBookByTitle("1984");
        LibraryManager.loanBook(libraryRepository, "1984", member1);
        // Here we directly call the loanTo method to trigger the AlreadyLoanedException
        assertThrows(AlreadyLoanedException.class, () -> book.loanTo(member2));
    }

    @Test
    void testLoanBookNotFound() {
        // This should simply print an error message, no exception to test
        LibraryManager.loanBook(libraryRepository, "Nonexistent Book", member1);
    }

    @Test
    void testReturnBook() throws AlreadyLoanedException, NotLoanedException {
        Book book = libraryRepository.findBookByTitle("1984");
        LibraryManager.loanBook(libraryRepository, "1984", member1);
        LibraryManager.returnBook(libraryRepository, "1984");
        // Here we directly call the returnItem method to trigger the NotLoanedException
        assertThrows(NotLoanedException.class, book::returnItem);
    }

    @Test
    void testReturnBookNotFound() {
        // This should simply print an error message, no exception to test
        LibraryManager.returnBook(libraryRepository, "Nonexistent Book");
    }

    @Test
    void testMain() {
        // Note: This is a basic test to check if the main method runs without exceptions
        // Detailed testing should be done for individual components
        LibraryManager.main(new String[]{});
    }
}
