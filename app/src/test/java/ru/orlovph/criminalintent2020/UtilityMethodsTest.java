package ru.orlovph.criminalintent2020;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.UUID;

import static org.junit.Assert.*;

/**
 * Unit tests for utility methods added to various classes
 */
public class UtilityMethodsTest {
    private Crime crime;

    @Before
    public void setUp() {
        crime = new Crime(UUID.randomUUID());
    }

    @Test
    public void testCrimeExpiredMethodExists() {
        // Test that isExpired method works
        Date oldDate = new Date(System.currentTimeMillis() - (400 * 24 * 60 * 60 * 1000L));
        crime.setDate(oldDate);
        assertTrue(crime.isExpired());
    }

    @Test
    public void testCrimePriorityMethodExists() {
        // Test that getPriority method returns valid value
        int priority = crime.getPriority();
        assertTrue(priority >= 0 && priority <= 10);
    }

    @Test
    public void testCrimePriorityCalculation() {
        // Crime solved should have priority 0
        crime.setSolved(true);
        assertEquals(0, crime.getPriority());
    }

    @Test
    public void testCrimePriorityForOldCrime() {
        // Old unsolved crimes should have higher priority
        Date veryOldDate = new Date(System.currentTimeMillis() - (365 * 24 * 60 * 60 * 1000L));
        crime.setDate(veryOldDate);
        crime.setSolved(false);
        int priority = crime.getPriority();
        assertTrue(priority > 0);
    }

    @Test
    public void testCrimeTitleCapitalizedNullTitle() {
        crime.setTitle(null);
        String result = crime.getTitleCapitalized();
        assertNotNull(result);
        assertEquals("Untitled", result);
    }

    @Test
    public void testCrimeTitleCapitalizedSingleChar() {
        crime.setTitle("a");
        String result = crime.getTitleCapitalized();
        assertEquals("A", result);
    }

    @Test
    public void testCrimeTitleCapitalizedMultipleChars() {
        crime.setTitle("theft");
        String result = crime.getTitleCapitalized();
        assertTrue(Character.isUpperCase(result.charAt(0)));
        assertEquals("Theft", result);
    }

    @Test
    public void testCrimeIsNotExpiredRecently() {
        Date recentDate = new Date();
        crime.setDate(recentDate);
        assertFalse(crime.isExpired());
    }

    @Test
    public void testDefaultCrimeDateIsNotExpired() {
        // Default date is now, should not be expired
        assertFalse(crime.isExpired());
    }

    @Test
    public void testCrimePriorityWithinRange() {
        // Priority should be capped at 10
        Date ancientDate = new Date(0);
        crime.setDate(ancientDate);
        crime.setSolved(false);
        int priority = crime.getPriority();
        assertTrue(priority <= 10);
    }

    @Test
    public void testCrimeDefaultSolvedStatus() {
        assertFalse(crime.isSolved());
    }

    @Test
    public void testCrimeChangeSolvedStatus() {
        crime.setSolved(true);
        assertTrue(crime.isSolved());
        crime.setSolved(false);
        assertFalse(crime.isSolved());
    }
}
