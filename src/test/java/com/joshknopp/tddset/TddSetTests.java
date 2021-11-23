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

    @Nested
    class SizeShould {
        @Test
        void returnZeroForNewSet() {
            assertEquals(0, tddSet.size());
        }

        @Test
        void returnOneAfterAdd() {
            assertTrue(tddSet.add("foo"));
            assertEquals(1, tddSet.size());
        }

        @Test
        void returnOneAfterDuplicateAdd() {
            assertTrue(tddSet.add("foo"));
            assertFalse(tddSet.add("foo"));
            assertEquals(1, tddSet.size());
        }

        @Test
        void returnZeroAfterAddRemove() {
            assertTrue(tddSet.add("foo"));
            assertTrue(tddSet.remove("foo"));
            assertEquals(0, tddSet.size());
        }
    }

    @Nested
    class IsEmptyShould {
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
