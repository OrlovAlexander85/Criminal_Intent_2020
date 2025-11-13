package ru.orlovph.criminalintent2020;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.UUID;

import static org.junit.Assert.*;

/**
 * Unit tests for Crime model class
 */
public class CrimeTest {
    private Crime crime;
    private UUID testId;

    @Before
    public void setUp() {
        testId = UUID.randomUUID();
        crime = new Crime(testId);
    }

    @Test
    public void testCrimeCreation() {
        assertNotNull(crime);
        assertNotNull(crime.getmID());
    }

    @Test
    public void testCrimeIdSetCorrectly() {
        assertEquals(testId, crime.getmID());
    }

    @Test
    public void testCrimeTitleGetterSetter() {
        String testTitle = "Murder at the Bank";
        crime.setTitle(testTitle);
        assertEquals(testTitle, crime.getTitle());
    }

    @Test
    public void testCrimeTitleNull() {
        crime.setTitle(null);
        assertNull(crime.getTitle());
    }

    @Test
    public void testCrimeDefaultDateNotNull() {
        assertNotNull(crime.getDate());
    }

    @Test
    public void testCrimeDateGetterSetter() {
        Date testDate = new Date(1000000);
        crime.setDate(testDate);
        assertEquals(testDate, crime.getDate());
    }

    @Test
    public void testCrimeSolvedFalseByDefault() {
        assertFalse(crime.isSolved());
    }

    @Test
    public void testCrimeSolvedGetterSetter() {
        crime.setSolved(true);
        assertTrue(crime.isSolved());

        crime.setSolved(false);
        assertFalse(crime.isSolved());
    }

    @Test
    public void testCrimeTitleCapitalized() {
        crime.setTitle("robbery");
        String capitalized = crime.getTitleCapitalized();
        assertTrue(capitalized.charAt(0) == Character.toUpperCase(capitalized.charAt(0)));
    }

    @Test
    public void testCrimeTitleCapitalizedEmpty() {
        crime.setTitle("");
        String capitalized = crime.getTitleCapitalized();
        assertNotNull(capitalized);
    }

    @Test
    public void testCrimeIsExpiredFalse() {
        Date recentDate = new Date(System.currentTimeMillis() - 1000);
        crime.setDate(recentDate);
        assertFalse(crime.isExpired());
    }

    @Test
    public void testCrimePriorityWithinYear() {
        Date recentDate = new Date(System.currentTimeMillis() - 1000 * 60 * 60 * 24);
        crime.setDate(recentDate);
        crime.setSolved(false);
        int priority = crime.getPriority();
        assertTrue(priority >= 0);
    }

    @Test
    public void testCrimePriorityWhenSolved() {
        crime.setSolved(true);
        int priority = crime.getPriority();
        assertEquals(0, priority);
    }

    @Test
    public void testMultipleCrimesHaveDifferentIds() {
        Crime crime2 = new Crime();
        assertNotEquals(crime.getmID(), crime2.getmID());
    }

    @Test
    public void testCrimeWithRandomId() {
        Crime randomCrime = new Crime();
        assertNotNull(randomCrime.getmID());
        assertNotEquals(testId, randomCrime.getmID());
    }
}
