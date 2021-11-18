package com.joshknopp.tddset;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TddSetTests {
    private TddSet tddSet = new TddSet<>();

    @Test
    void itShouldImplementSetInterface() {
        assertTrue(tddSet instanceof Set);
    }
}
