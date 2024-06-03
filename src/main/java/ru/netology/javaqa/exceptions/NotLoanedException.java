package ru.netology.javaqa.exceptions;

/**
 * Custom exception thrown when an item is not loaned but an operation is attempted.
 */
public class NotLoanedException extends Exception {
    /**
     * Constructor to create the exception with a message.
     *
     * @param message The exception message.
     */
    public NotLoanedException(String message) {
        super(message);
    }
}
