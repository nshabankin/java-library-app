package ru.netology.javaqa.manager;

import ru.netology.javaqa.domain.Book;
import ru.netology.javaqa.domain.Member;
import ru.netology.javaqa.exceptions.AlreadyLoanedException;
import ru.netology.javaqa.exceptions.NotLoanedException;
import ru.netology.javaqa.repository.Library;

/**
 * Main application class for the library.
 */
public class LibraryApp {
    /**
     * Main method to run the library application.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        Library library = Library.getInstance(); // Get the singleton instance of the library

        setupLibrary(library);

        // Create some members
        Member member1 = new Member("Alice");
        Member member2 = new Member("Bob");

        loanBook(library, "1984", member1);
        loanBook(library, "1984", member2);

        returnBook(library, "1984");
        returnBook(library, "Nonexistent Book"); // Test case where book is not found
    }

    /**
     * Sets up the library with initial books.
     *
     * @param library The library instance.
     */
    public static void setupLibrary(Library library) {
        // Create some books and add them to the library
        Book book1 = new Book("1984", "George Orwell");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee");

        library.addBook(book1);
        library.addBook(book2);
    }

    /**
     * Loans a book to a member.
     *
     * @param library The library instance.
     * @param title   The title of the book to loan.
     * @param member  The member to loan the book to.
     */
    public static void loanBook(Library library, String title, Member member) {
        Book book = library.findBookByTitle(title);
        if (book != null) {
            try {
                book.loanTo(member);
                System.out.println(member.getName() + " has loaned " + book.getTitle());
            } catch (AlreadyLoanedException e) {
                System.err.println(e.getMessage());
            }
        } else {
            System.err.println("Book not found: " + title);
        }
    }

    /**
     * Returns a loaned book.
     *
     * @param library The library instance.
     * @param title   The title of the book to return.
     */
    public static void returnBook(Library library, String title) {
        Book book = library.findBookByTitle(title);
        if (book != null) {
            try {
                book.returnItem();
                System.out.println(book.getTitle() + " has been returned.");
            } catch (NotLoanedException e) {
                System.err.println(e.getMessage());
            }
        } else {
            System.err.println("Book not found: " + title);
        }
    }
}
