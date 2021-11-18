package com.joshknopp.tddset;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TddSetTests {
    @InjectMocks
    private TddSet<String> tddSet;

    @Test
    void itShouldImplementSetInterface() {
        assertTrue(tddSet instanceof Set);
    }

    @Test
    void isEmptyShouldReturnTrueIfEmpty() {
        assertTrue(tddSet.isEmpty());
    }

    @Test
    void isEmptyShouldReturnFalseIfNotEmpty() {
        tddSet.add("foo");
        assertFalse(tddSet.isEmpty());
    }
}
