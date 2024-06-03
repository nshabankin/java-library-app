package ru.netology.javaqa.domain;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.javaqa.exceptions.AlreadyLoanedException;
import ru.netology.javaqa.exceptions.NotLoanedException;

class BookTest {
    private Book book;
    private Member member;

    @BeforeEach
    void setUp() {
        book = new Book("1984", "George Orwell");
        member = new Member("Alice");
    }

    @Test
    void testLoanTo() throws AlreadyLoanedException {
        assertNull(book.getLoanedTo());
        book.loanTo(member);
        assertEquals(member, book.getLoanedTo());
    }

    @Test
    void testLoanToAlreadyLoaned() {
        assertThrows(AlreadyLoanedException.class, () -> {
            book.loanTo(member);
            book.loanTo(new Member("Bob"));
        });
    }

    @Test
    void testReturnItem() throws AlreadyLoanedException, NotLoanedException {
        book.loanTo(member);
        assertNotNull(book.getLoanedTo());
        book.returnItem();
        assertNull(book.getLoanedTo());
    }

    @Test
    void testReturnItemNotLoaned() {
        assertThrows(NotLoanedException.class, book::returnItem);
    }

    @Test
    void testGetTitle() {
        assertEquals("1984", book.getTitle());
    }

    @Test
    void testGetAuthor() {
        assertEquals("George Orwell", book.getAuthor());
    }
}
