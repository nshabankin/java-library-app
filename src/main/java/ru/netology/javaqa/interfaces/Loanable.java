package ru.netology.javaqa.interfaces;

import ru.netology.javaqa.domain.Member;
import ru.netology.javaqa.exceptions.AlreadyLoanedException;
import ru.netology.javaqa.exceptions.NotLoanedException;

/**
 * Interface for items that can be loaned.
 */
public interface Loanable {
    /**
     * Loans the item to a member.
     *
     * @param member The member to whom the item is loaned.
     * @throws AlreadyLoanedException If the item is already loaned to someone else.
     */
    void loanTo(Member member) throws AlreadyLoanedException;

    /**
     * Returns the loaned item.
     *
     * @throws NotLoanedException If the item is not currently loaned.
     */
    void returnItem() throws NotLoanedException;
}
