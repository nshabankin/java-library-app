package ru.netology.javaqa.exceptions;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class NotLoanedExceptionTest {
    @Test
    void testExceptionMessage() {
        NotLoanedException exception = new NotLoanedException("Book is not currently loaned.");
        assertEquals("Book is not currently loaned.", exception.getMessage());
    }
}
