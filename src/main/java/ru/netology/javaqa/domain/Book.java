package ru.netology.javaqa.domain;

import ru.netology.javaqa.exceptions.AlreadyLoanedException;
import ru.netology.javaqa.exceptions.NotLoanedException;
import ru.netology.javaqa.interfaces.Loanable;

/**
 * Represents a book in the library.
 */
public class Book implements Loanable {
    private final String title;  // Title of the book
    private final String author; // Author of the book
    private Member loanedTo;     // Member who has loaned the book, null if not loaned

    /**
     * Constructor to create a new book with title and author.
     *
     * @param title  The title of the book.
     * @param author The author of the book.
     */
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.loanedTo = null;
    }

    /**
     * Loans the book to a member.
     *
     * @param member The member to whom the book is loaned.
     * @throws AlreadyLoanedException If the book is already loaned.
     */
    @Override
    public void loanTo(Member member) throws AlreadyLoanedException {
        if (this.loanedTo != null) { // Check if the book is already loaned
            throw new AlreadyLoanedException("Book is already loaned to " + this.loanedTo.getName());
        }
        this.loanedTo = member; // Loan the book to the member
    }

    /**
     * Returns the book.
     *
     * @throws NotLoanedException If the book is not currently loaned.
     */
    @Override
    public void returnItem() throws NotLoanedException {
        if (this.loanedTo == null) { // Check if the book is not loaned
            throw new NotLoanedException("Book is not currently loaned.");
        }
        this.loanedTo = null; // Return the book
    }

    /**
     * Gets the title of the book.
     *
     * @return The title of the book.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the author of the book.
     *
     * @return The author of the book.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Gets who the book was loaned to.
     *
     * @return The person the book was loaned to.
     */

    public Member getLoanedTo() {
        return loanedTo;
    }
}
