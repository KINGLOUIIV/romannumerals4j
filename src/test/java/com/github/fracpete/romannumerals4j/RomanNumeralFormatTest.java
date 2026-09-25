package com.github.fracpete.romannumerals4j;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RomanNumeralFormatTest {

    private final RomanNumeralFormat formatter = new RomanNumeralFormat();

    @Test
    void testFormatIntegerToRoman() {
        // Test formatting a standard integer to a Roman numeral
        assertEquals("LVII", formatter.format(57));
    }

    @Test
    void testParseRomanToInteger() {
        // Test parsing a Roman numeral string back to an integer
        assertDoesNotThrow(() -> assertEquals(57, formatter.parse("LVII").intValue()));
    }
}