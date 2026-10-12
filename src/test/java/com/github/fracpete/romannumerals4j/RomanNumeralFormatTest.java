package com.github.fracpete.romannumerals4j;

import java.text.ParseException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RomanNumeralFormatTest {

    private final RomanNumeralFormat formatter = new RomanNumeralFormat();

    @ParameterizedTest
    @CsvSource({
        "1, I",
        "3999, MMMCMXCIX"
    })
    void testFormatBoundaryValues(long value, String expected) {
        assertEquals(expected, formatter.format(value));
    }

    @ParameterizedTest
    @ValueSource(longs = {0, -1, 4000})
    void testFormatInvalidBoundaryValues(long value) {
        assertThrows(IllegalArgumentException.class, () -> formatter.format(value));
    }

    @Test
    void testFormatReassignsRemainderAcrossNumerals() {
        assertEquals("MCMLXXXVII", formatter.format(1987));
    }

    @ParameterizedTest
    @CsvSource({
        "I, 1",
        "MMMCMXCIX, 3999"
    })
    void testParseBoundaryValues(String numeral, long expected) throws Exception {
        assertEquals(expected, formatter.parse(numeral).longValue());
    }

    @ParameterizedTest
    @CsvSource({
        "M, 1000",
        "D, 500",
        "C, 100",
        "L, 50",
        "X, 10",
        "V, 5",
        "I, 1"
    })
    void testParseEveryRomanNumeralCase(String numeral, long expected) throws Exception {
        assertEquals(expected, formatter.parse(numeral).longValue());
    }

    @ParameterizedTest
    @CsvSource({
        "II, 2",
        "IV, 4"
    })
    void testParseBothProcessDecimalBranches(String numeral, long expected) throws Exception {
        assertEquals(expected, formatter.parse(numeral).longValue());
    }

    @Test
    void testParseUpdatesAccumulatorAcrossAdditionAndSubtraction() throws Exception {
        assertEquals(1994, formatter.parse("MCMXCIV").longValue());
    }

    @ParameterizedTest
    @ValueSource(strings = {"ABC", "MMMM"})
    void testParseInvalidRomanNumerals(String numeral) {
        assertThrows(ParseException.class, () -> formatter.parse(numeral));
    }

    @Test
    void testRepeatFormatWithNullString() {
        assertNull(formatter.repeatFormat(null, 1));
    }
}