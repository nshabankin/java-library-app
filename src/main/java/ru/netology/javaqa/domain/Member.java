package ru.netology.javaqa.domain;

/**
 * Represents a member of the library.
 */
public class Member {
    private final String name; // Name of the member

    /**
     * Constructor to create a new member with a name.
     *
     * @param name The name of the member.
     */
    public Member(String name) {
        this.name = name;
    }

    /**
     * Gets the name of the member.
     *
     * @return The name of the member.
     */
    public String getName() {
        return name;
    }
}
