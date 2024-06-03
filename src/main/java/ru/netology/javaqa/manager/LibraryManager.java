package ru.netology.javaqa.manager;

import ru.netology.javaqa.domain.Book;
import ru.netology.javaqa.domain.Member;
import ru.netology.javaqa.exceptions.AlreadyLoanedException;
import ru.netology.javaqa.exceptions.NotLoanedException;
import ru.netology.javaqa.repository.LibraryRepository;

/**
 * Main application class for the library.
 */
public class LibraryManager {
    /**
     * Main method to run the library application.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        LibraryRepository libraryRepository = LibraryRepository.getInstance(); // Get the singleton instance of the library

        setupLibrary(libraryRepository);

        // Create some members
        Member member1 = new Member("Alice");
        Member member2 = new Member("Bob");

        loanBook(libraryRepository, "1984", member1);
        loanBook(libraryRepository, "1984", member2);

        returnBook(libraryRepository, "1984");
        returnBook(libraryRepository, "Nonexistent Book"); // Test case where book is not found
    }

    /**
     * Sets up the library with initial books.
     *
     * @param libraryRepository The library instance.
     */
    public static void setupLibrary(LibraryRepository libraryRepository) {
        // Create some books and add them to the library
        Book book1 = new Book("1984", "George Orwell");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee");

        libraryRepository.addBook(book1);
        libraryRepository.addBook(book2);
    }

    /**
     * Loans a book to a member.
     *
     * @param libraryRepository The library instance.
     * @param title   The title of the book to loan.
     * @param member  The member to loan the book to.
     */
    public static void loanBook(LibraryRepository libraryRepository, String title, Member member) {
        Book book = libraryRepository.findBookByTitle(title);
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
     * @param libraryRepository The library instance.
     * @param title   The title of the book to return.
     */
    public static void returnBook(LibraryRepository libraryRepository, String title) {
        Book book = libraryRepository.findBookByTitle(title);
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
