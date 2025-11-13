package ru.orlovph.criminalintent2020.database;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit tests for CrimeDbSchema
 */
public class CrimeDbSchemaTest {

    @Test
    public void testCrimeTableNameExists() {
        assertNotNull(CrimeDbSchema.CrimeTable.NAME);
        assertEquals("crimes", CrimeDbSchema.CrimeTable.NAME);
    }

    @Test
    public void testCrimeTableColumnsExist() {
        assertNotNull(CrimeDbSchema.CrimeTable.Cols.UUID);
        assertNotNull(CrimeDbSchema.CrimeTable.Cols.TITLE);
        assertNotNull(CrimeDbSchema.CrimeTable.Cols.DATE);
        assertNotNull(CrimeDbSchema.CrimeTable.Cols.SOLVED);
    }

    @Test
    public void testUUIDColumnName() {
        assertEquals("uuid", CrimeDbSchema.CrimeTable.Cols.UUID);
    }

    @Test
    public void testTitleColumnName() {
        assertEquals("title", CrimeDbSchema.CrimeTable.Cols.TITLE);
    }

    @Test
    public void testDateColumnName() {
        assertEquals("date", CrimeDbSchema.CrimeTable.Cols.DATE);
    }

    @Test
    public void testSolvedColumnName() {
        assertEquals("solved", CrimeDbSchema.CrimeTable.Cols.SOLVED);
    }

    @Test
    public void testAllColumnNamesAreUnique() {
        String uuid = CrimeDbSchema.CrimeTable.Cols.UUID;
        String title = CrimeDbSchema.CrimeTable.Cols.TITLE;
        String date = CrimeDbSchema.CrimeTable.Cols.DATE;
        String solved = CrimeDbSchema.CrimeTable.Cols.SOLVED;

        assertTrue(!uuid.equals(title));
        assertTrue(!uuid.equals(date));
        assertTrue(!uuid.equals(solved));
        assertTrue(!title.equals(date));
        assertTrue(!title.equals(solved));
        assertTrue(!date.equals(solved));
    }

    @Test
    public void testCrimeTableNameNotEmpty() {
        assertTrue(CrimeDbSchema.CrimeTable.NAME.length() > 0);
    }

    @Test
    public void testColumnNamesNotEmpty() {
        assertTrue(CrimeDbSchema.CrimeTable.Cols.UUID.length() > 0);
        assertTrue(CrimeDbSchema.CrimeTable.Cols.TITLE.length() > 0);
        assertTrue(CrimeDbSchema.CrimeTable.Cols.DATE.length() > 0);
        assertTrue(CrimeDbSchema.CrimeTable.Cols.SOLVED.length() > 0);
    }
}
