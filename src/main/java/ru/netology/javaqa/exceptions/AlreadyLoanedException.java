package ru.netology.javaqa.exceptions;

/**
 * Custom exception thrown when an item is already loaned.
 */
public class AlreadyLoanedException extends Exception {
    /**
     * Constructor to create the exception with a message.
     *
     * @param message The exception message.
     */
    public AlreadyLoanedException(String message) {
        super(message);
    }
}
