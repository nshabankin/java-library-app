package ru.netology.javaqa.domain;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MemberTest {
    @Test
    void testGetName() {
        Member member = new Member("Alice");
        assertEquals("Alice", member.getName());
    }
}
