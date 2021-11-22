package com.joshknopp.tddset;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TddSetTests {
    @InjectMocks
    private TddSet<String> tddSet;

    @Test
    void itShouldImplementSetInterface() {
        assertTrue(tddSet instanceof Set);
    }

    @Test
    void sizeShouldReturnZeroForNewSet() {
        assertEquals(0, tddSet.size());
    }

    @Test
    void sizeShouldReturnOneAfterAdd() {
        tddSet.add("foo");
        assertEquals(1, tddSet.size());
    }

    @Test
    void sizeShouldReturnOneAfterDuplicateAdd() {
        tddSet.add("foo");
        tddSet.add("foo");
        assertEquals(1, tddSet.size());
    }

    @Test
    void sizeShouldReturnZeroAfterAddRemove() {
        tddSet.add("foo");
        tddSet.add("remove");
        assertEquals(1, tddSet.size());
    }

    @Nested
    class isEmptyShould {
        @Test
        void returnTrueIfEmpty() {
            assertTrue(tddSet.isEmpty());
        }

        @Test
        void returnFalseIfNotEmpty() {
            tddSet.add("foo");
            assertFalse(tddSet.isEmpty());
        }
    }
}
