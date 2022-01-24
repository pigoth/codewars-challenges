package org.example.challenge.camelcase;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    public void testSomeUnderscoreLowerStart() {
        String input = "the_Stealth_Warrior";

        assertEquals("theStealthWarrior", Solution.toCamelCase(input));
    }

    @Test
    public void testSomeDashLowerStart() {
        String input = "the-Stealth-Warrior";

        assertEquals("theStealthWarrior", Solution.toCamelCase(input));
    }

    @Test
    public void testMiddleWordStartWithLowerLetter() {
        String input = "The-stealth-Warrior";

        assertEquals("TheStealthWarrior", Solution.toCamelCase(input));
    }
}
