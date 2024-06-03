package ru.netology.javaqa.exceptions;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class AlreadyLoanedExceptionTest {
    @Test
    void testExceptionMessage() {
        AlreadyLoanedException exception = new AlreadyLoanedException("Book is already loaned.");
        assertEquals("Book is already loaned.", exception.getMessage());
    }
}
