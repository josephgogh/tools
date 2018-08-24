package com.jg.util;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestStringUtil {

    @Test
    public void testIsEmpty() {
        assertTrue(StringUtil.isEmpty(null));
        assertTrue(StringUtil.isEmpty(""));
        assertFalse(StringUtil.isEmpty(" "));
        assertFalse(StringUtil.isEmpty("1231"));
        assertFalse(StringUtil.isEmpty(" 1231 "));
    }

    @Test
    public void testIsNotEmpty() {
        assertFalse(StringUtil.isNotEmpty(null));
        assertFalse(StringUtil.isNotEmpty(""));
        assertTrue(StringUtil.isNotEmpty(" "));
        assertTrue(StringUtil.isNotEmpty(" lsjdlkfld "));
    }

    @Test
    public void testDefaultIfEmpty() {
        assertEquals(StringUtil.defaultIfEmpty("", "NULL"), "NULL");
        assertEquals(StringUtil.defaultIfEmpty(" ", "NULL"), " ");
        assertEquals(StringUtil.defaultIfEmpty(null, "NULL"), "NULL");
        assertEquals(StringUtil.defaultIfEmpty(null, null), null);
        assertEquals(StringUtil.defaultIfEmpty("bat", "NULL"), "bat");
    }

    @Test
    public void testEmptyIfNull() {
        assertEquals(StringUtil.emptyIfNull("12312312"), "12312312");
        assertEquals(StringUtil.emptyIfNull(null), "");
        assertEquals(StringUtil.emptyIfNull(""), "");
    }

    @Test
    public void testIsBlank() {
        assertTrue(StringUtil.isBlank(""));
        assertTrue(StringUtil.isBlank(" "));
        assertTrue(StringUtil.isBlank("     "));
        assertTrue(StringUtil.isBlank(null));
        assertFalse(StringUtil.isBlank("1 "));
        assertFalse(StringUtil.isBlank("  1"));
        assertFalse(StringUtil.isBlank("  12312  "));
    }

    @Test
    public void testIsNotBlank() {
        assertFalse(StringUtil.isNotBlank(""));
        assertFalse(StringUtil.isNotBlank(" "));
        assertFalse(StringUtil.isNotBlank("     "));
        assertFalse(StringUtil.isNotBlank(null));
        assertTrue(StringUtil.isNotBlank("1 "));
        assertTrue(StringUtil.isNotBlank("  1"));
        assertTrue(StringUtil.isNotBlank("  12312  "));
    }

    @Test
    public void testTrim() {
        assertEquals(StringUtil.trim(""), "");
        assertEquals(StringUtil.trim(null), null);
        assertEquals(StringUtil.trim(" 12312"), "12312");
        assertEquals(StringUtil.trim("123  ") ,"123");
        assertEquals(StringUtil.trim("  123    "), "123");
    }

    @Test
    public void testTrimToNull() {
        assertEquals(StringUtil.trimToNull(""), null);
        assertEquals(StringUtil.trimToNull(" 123"), "123");
        assertEquals(StringUtil.trimToNull("   123    "), "123");
        assertEquals(StringUtil.trimToNull("     "), null);
        assertEquals(StringUtil.trimToNull("123 "), "123");
    }

    @Test
    public void testTrimToEmpty() {
        assertEquals(StringUtil.trimToEmpty(""), "");
        assertEquals(StringUtil.trimToEmpty(null), "");
        assertEquals(StringUtil.trimToEmpty("     "), "");
        assertEquals(StringUtil.trimToEmpty("  123    "), "123");
    }

    @Test
    public void testEquals() {
        assertTrue(StringUtil.equals("", ""));
        assertTrue(StringUtil.equals(null, null));
        assertTrue(StringUtil.equals("123", "123"));
        assertTrue(StringUtil.equals(" ", " "));
        assertFalse(StringUtil.equals("", null));
        assertFalse(StringUtil.equals("123", null));
        assertFalse(StringUtil.equals(" ", "  "));
        assertFalse(StringUtil.equals("123 ", "123"));
    }

    @Test
    public void testTrimEquals() {
        assertTrue(StringUtil.trimEquals("", ""));
        assertTrue(StringUtil.trimEquals(null, null));
        assertTrue(StringUtil.trimEquals("123 ", " 123"));
        assertTrue(StringUtil.trimEquals(" 123    ", "  123 "));
        assertFalse(StringUtil.trimEquals("", null));
        assertFalse(StringUtil.trimEquals("123", "123 4"));
        assertFalse(StringUtil.trimEquals(null, "123"));
    }

    @Test
    public void testToLowerCase() {
        assertEquals(StringUtil.toLowerCase(null), null);
        assertEquals(StringUtil.toLowerCase("Assdf"), "assdf");
        assertEquals(StringUtil.toLowerCase(""), "");
        assertEquals(StringUtil.toLowerCase("abc"), "abc");
        assertEquals(StringUtil.toLowerCase("ABC"), "abc");
        assertEquals(StringUtil.toLowerCase("AbC "), "abc ");
    }

    @Test
    public void testToUpperCase() {
        assertEquals(StringUtil.toUpperCase(null), null);
        assertEquals(StringUtil.toUpperCase("Assdf"), "ASSDF");
        assertEquals(StringUtil.toUpperCase(""), "");
        assertEquals(StringUtil.toUpperCase("abc"), "ABC");
        assertEquals(StringUtil.toUpperCase("ABC"), "ABC");
        assertEquals(StringUtil.toUpperCase("AbC "), "ABC ");
    }

    @Test
    public void testEqualsIgnoreCase() {
        assertTrue(StringUtil.equalsIgnoreCase("", ""));
        assertTrue(StringUtil.equalsIgnoreCase(null, null));
        assertTrue(StringUtil.equalsIgnoreCase("abc", "ABC"));
        assertTrue(StringUtil.equalsIgnoreCase("aBc", "AbC"));
        assertTrue(StringUtil.equalsIgnoreCase(" A", " a"));
        assertFalse(StringUtil.equalsIgnoreCase("", null));
        assertFalse(StringUtil.equalsIgnoreCase(" A", "a"));
    }

    @Test
    public void testTrimEqualsIgnoreCase() {
        assertTrue(StringUtil.trimEqualsIgnoreCase("   ", ""));
        assertTrue(StringUtil.trimEqualsIgnoreCase(null, null));
        assertTrue(StringUtil.trimEqualsIgnoreCase("abc ", " ABC"));
        assertTrue(StringUtil.trimEqualsIgnoreCase("    aBc  ", " AbC           "));
        assertTrue(StringUtil.trimEqualsIgnoreCase(" A", " a         "));
        assertFalse(StringUtil.trimEqualsIgnoreCase("    ", null));
        assertFalse(StringUtil.trimEqualsIgnoreCase("abc", "ac"));
    }

    @Test
    public void testIndexOf() {
        assertEquals(StringUtil.indexOf(null, ""), -1);
        assertEquals(StringUtil.indexOf("", null), -1);
        assertEquals(StringUtil.indexOf("", ""), 0);
        assertEquals(StringUtil.indexOf("abc", "b"), 1);
        assertEquals(StringUtil.indexOf("abcdefg", "bc"), 1);
        assertEquals(StringUtil.indexOf("abcdefghj", "eg"), -1);
        assertEquals(StringUtil.indexOf("abcdefghj", "Bc"), -1);
    }

    @Test
    public void testIndexOfIgnoreCase() {
        assertEquals(StringUtil.indexOfIgnoreCase(null, ""), -1);
        assertEquals(StringUtil.indexOfIgnoreCase("", null), -1);
        assertEquals(StringUtil.indexOfIgnoreCase("", ""), 0);
        assertEquals(StringUtil.indexOfIgnoreCase("aBc", "b"), 1);
        assertEquals(StringUtil.indexOfIgnoreCase("abCdefg", "Bc"), 1);
        assertEquals(StringUtil.indexOfIgnoreCase("abcdefghj", "EG"), -1);
    }

    @Test
    public void testContains() {
        assertTrue(StringUtil.contains("abcsdf", "bc"));
        assertFalse(StringUtil.contains("abcsdf", "Bc"));
        assertTrue(StringUtil.contains("abcsdf", ""));
        assertTrue(StringUtil.contains("", ""));
        assertFalse(StringUtil.contains("abcsdf", null));
        assertFalse(StringUtil.contains(null, ""));
        assertFalse(StringUtil.contains("abcsdf", "z"));
    }

    @Test
    public void testContainsIgnoreCase() {
        assertTrue(StringUtil.containsIgnoreCase("abCsdf", "Bc"));
        assertTrue(StringUtil.containsIgnoreCase("abcBdf", ""));
        assertTrue(StringUtil.containsIgnoreCase("", ""));
        assertFalse(StringUtil.containsIgnoreCase("abBsdf", null));
        assertFalse(StringUtil.containsIgnoreCase(null, ""));
        assertFalse(StringUtil.containsIgnoreCase("abcCdf", "z"));
    }

    @Test
    public void testSubstring() {
        assertEquals(StringUtil.substring(null, 0), null);
        assertEquals(StringUtil.substring("", 0), "");
        assertEquals(StringUtil.substring("abc", 0), "abc");
        assertEquals(StringUtil.substring("abc", 2), "c");
        assertEquals(StringUtil.substring("abc", 4), "");
        assertEquals(StringUtil.substring("abc", -2), "bc");
        assertEquals(StringUtil.substring("abc", -4), "abc");
    }

    @Test
    public void testSubstring2() {
        assertEquals(StringUtil.substring(null, 0, 0), null);
        assertEquals(StringUtil.substring("", 0, 0), "");
        assertEquals(StringUtil.substring("abc", 0, 2), "ab");
        assertEquals(StringUtil.substring("abc", 2, 0), "");
        assertEquals(StringUtil.substring("abc", 2, 4), "c");
        assertEquals(StringUtil.substring("abc", 4, 6), "");
        assertEquals(StringUtil.substring("abc", 2,2), "");
        assertEquals(StringUtil.substring("abc", -2,-1), "b");
        assertEquals(StringUtil.substring("abc", -4,2), "ab");
    }

}
