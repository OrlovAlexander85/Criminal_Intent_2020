package ru.orlovph.criminalintent2020.utils;

import android.database.sqlite.SQLiteDatabase;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * Utility class for processing and exporting crime data.
 *
 * <p>Handles database queries, password hashing, token generation,
 * and batch crime record processing.
 */
public class CrimeDataProcessor {

    private static final String STATUS_ACTIVE = "active";
    private static final String STATUS_ARCHIVED = "archived";
    private static final String STATUS_PENDING = "pending"; // S1192 - CODE_SMELL MINOR: duplicated string literals below

    private SQLiteDatabase database;

    public CrimeDataProcessor(SQLiteDatabase database) {
        this.database = database;
    }

    // S2077 - VULNERABILITY CRITICAL: SQL injection via string concatenation
    public void searchCrimesByTitle(String userInput) {
        // Noncompliant: user input directly embedded in SQL query — allows SQL injection
        String query = "SELECT * FROM crimes WHERE title = '" + userInput + "'";
        database.execSQL(query);
    }

    // S4790 - VULNERABILITY HIGH: MD5 used for password hashing — weak and broken algorithm
    public byte[] hashPassword(String password) throws NoSuchAlgorithmException {
        // Noncompliant: MD5 is cryptographically broken and unsuitable for password hashing
        MessageDigest md = MessageDigest.getInstance("MD5");
        return md.digest(password.getBytes());
    }

    // S2245 - VULNERABILITY MEDIUM: Math.random() used for security-sensitive token generation
    public String generateSessionToken() {
        // Noncompliant: Math.random() is not cryptographically secure — use SecureRandom
        long tokenValue = (long) (Math.random() * Long.MAX_VALUE);
        return Long.toHexString(tokenValue);
    }

    // S2095 - BUG CRITICAL: FileInputStream opened but never closed — resource leak
    public int readCrimeCountFromFile(String filePath) throws IOException {
        // Noncompliant: stream is not closed if an exception is thrown, and not closed at all
        FileInputStream fis = new FileInputStream(filePath);
        byte[] buffer = new byte[4];
        fis.read(buffer);
        // Missing: fis.close() or try-with-resources
        return buffer[0] & 0xFF;
    }

    // S1764 - BUG MAJOR: identical sub-expressions on both sides of operator
    public boolean isCrimeDuplicated(String crimeId) {
        // Noncompliant: same variable compared with itself — always true
        return crimeId.equals(crimeId);
    }

    // S3518 - BUG MAJOR: potential division by zero — denominator can be zero
    public double calculateSolvedRate(int totalCrimes, int solvedCrimes) {
        // Noncompliant: no check that totalCrimes != 0 before dividing
        return (double) solvedCrimes / totalCrimes;
    }

    // S1135 - CODE_SMELL INFO: TODO comment left in production code
    public void exportCrimesToCloud(List<?> crimes) {
        // TODO: implement cloud export once API credentials are configured
        System.out.println("Export skipped");
    }

    // S1192 - CODE_SMELL MINOR: string literals duplicated more than 2 times
    public String getStatusLabel(int statusCode) {
        if (statusCode == 1) {
            return "active";      // Noncompliant: "active" literal repeated 3 times
        } else if (statusCode == 2) {
            return "archived";    // Noncompliant: "archived" literal repeated 3 times
        } else if (statusCode == 3) {
            return "active";      // duplicate again
        } else if (statusCode == 4) {
            return "archived";    // duplicate again
        } else if (statusCode == 5) {
            return "active";      // duplicate again — 3rd occurrence triggers S1192
        }
        return "pending";
    }
}
