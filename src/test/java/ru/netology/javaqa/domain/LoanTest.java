package ru.netology.javaqa.domain;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import ru.netology.javaqa.interfaces.Loanable;

class LoanTest {
    @Test
    void testLoanConstructorAndGetters() {
        Loanable item = new Book("1984", "George Orwell");
        Member member = new Member("Alice");
        Loan loan = new Loan(item, member);

        assertEquals(item, loan.getItem());
        assertEquals(member, loan.getMember());
    }
}
