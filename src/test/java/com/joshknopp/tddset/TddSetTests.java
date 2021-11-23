package com.joshknopp.tddset;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
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
        void returnOneAfterDoubleAdd() {
            assertTrue(tddSet.add("foo"));
            assertTrue(tddSet.add("bar"));
            assertEquals(2, tddSet.size());
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

    @Nested
    class AddShould {
        @Test
        void returnTrueOnSuccessfulAdd() {
            assertTrue(tddSet.add("foo"));
        }
        @Test
        void returnFalseOnDuplicateAdd() {
            tddSet.add("foo");
            assertFalse(tddSet.add("foo"));
        }
    }

    @Nested
    class AddAllShould {
        @Test
        void returnTrueOnSuccessfulAddAll() {
            ArrayList<String> elements = new ArrayList<>();
            elements.add("foo");
            elements.add("bar");
            assertTrue(tddSet.addAll(elements));
        }
        @Test
        void returnFalseOnDuplicateAddAll() {
            ArrayList<String> elements = new ArrayList<>();
            elements.add("foo");
            elements.add("bar");
            tddSet.addAll(elements);
            assertFalse(tddSet.addAll(elements));
        }
        @Test
        void resultAddNonOverlappingElements() {
            ArrayList<String> elements1 = new ArrayList<>();
            ArrayList<String> elements2 = new ArrayList<>();
            elements1.add("foo");
            elements1.add("bar");
            elements2.add("foo");
            elements2.add("baz");
            tddSet.addAll(elements1);
            tddSet.addAll(elements2);
            assertEquals(3, tddSet.size());
        }
    }
}
