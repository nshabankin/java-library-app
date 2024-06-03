package ru.netology.javaqa.manager;

import ru.netology.javaqa.domain.Book;
import ru.netology.javaqa.domain.Member;
import ru.netology.javaqa.exceptions.AlreadyLoanedException;
import ru.netology.javaqa.exceptions.NotLoanedException;
import ru.netology.javaqa.repository.Library;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryAppTest {
    private Library library;
    private Member member1;
    private Member member2;

    @BeforeEach
    void setUp() {
        library = Library.getInstance();
        library.clearBooks();

        member1 = new Member("Alice");
        member2 = new Member("Bob");

        LibraryApp.setupLibrary(library);
    }

    @Test
    void testSetupLibrary() {
        assertNotNull(library.findBookByTitle("1984"));
        assertNotNull(library.findBookByTitle("To Kill a Mockingbird"));
    }

    @Test
    void testLoanBook() {
        Book book = library.findBookByTitle("1984");
        LibraryApp.loanBook(library, "1984", member1);
        // Here we directly call the loanTo method to trigger the AlreadyLoanedException
        assertThrows(AlreadyLoanedException.class, () -> book.loanTo(member2));
    }

    @Test
    void testLoanBookNotFound() {
        // This should simply print an error message, no exception to test
        LibraryApp.loanBook(library, "Nonexistent Book", member1);
    }

    @Test
    void testReturnBook() throws AlreadyLoanedException, NotLoanedException {
        Book book = library.findBookByTitle("1984");
        LibraryApp.loanBook(library, "1984", member1);
        LibraryApp.returnBook(library, "1984");
        // Here we directly call the returnItem method to trigger the NotLoanedException
        assertThrows(NotLoanedException.class, book::returnItem);
    }

    @Test
    void testReturnBookNotFound() {
        // This should simply print an error message, no exception to test
        LibraryApp.returnBook(library, "Nonexistent Book");
    }

    @Test
    void testMain() {
        // Note: This is a basic test to check if the main method runs without exceptions
        // Detailed testing should be done for individual components
        LibraryApp.main(new String[]{});
    }
}
