package com.joshknopp.tddset;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TddSetTests {
    @InjectMocks
    private TddSet tddSet;

    @Test
    void itShouldImplementSetInterface() {
        assertTrue(tddSet instanceof Set);
    }

    @Test
    void isEmptyShouldReturnTrueIfEmpty() {
        assertTrue(tddSet.isEmpty());
    }
}
