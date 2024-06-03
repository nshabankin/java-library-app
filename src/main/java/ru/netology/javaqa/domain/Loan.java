package ru.netology.javaqa.domain;

import ru.netology.javaqa.interfaces.Loanable;

/**
 * Represents a loan of an item to a member.
 */
public class Loan {
    private final Loanable item; // The item being loaned
    private final Member member; // The member who has loaned the item

    /**
     * Constructor to create a new loan.
     *
     * @param item   The item being loaned.
     * @param member The member who has loaned the item.
     */
    public Loan(Loanable item, Member member) {
        this.item = item;
        this.member = member;
    }

    /**
     * Gets the loaned item.
     *
     * @return The item being loaned.
     */
    public Loanable getItem() {
        return item;
    }

    /**
     * Gets the member who has loaned the item.
     *
     * @return The member who has loaned the item.
     */
    public Member getMember() {
        return member;
    }
}
