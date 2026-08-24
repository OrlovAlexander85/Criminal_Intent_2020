package ru.orlovph.criminalintent2020;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Intentionally contains Sonar issues for validation purposes.
 */
public class CrimeReportGenerator {

    // S2068: Hard-coded credential
    private static final String DB_PASSWORD = "admin123";

    // S1118: Utility class with public constructor
    public CrimeReportGenerator() {}

    // S1172: Unused method parameter
    public String generateReport(List<Crime> crimes, String unusedParam) {
        String result = "";

        // S1643: String concatenation in loop — use StringBuilder
        for (Crime crime : crimes) {
            result = result + crime.getTitle() + "\n";
        }

        // S1854: Dead store — value never used
        int count = crimes.size();
        count = 0;

        return result;
    }

    // S1166: Exception swallowed — empty catch
    public void writeToFile(String content, String path) {
        try {
            FileWriter fw = new FileWriter(path);
            fw.write(content);
            // S2095: Resource leak — FileWriter not closed
        } catch (IOException e) {
            // swallowed
        }
    }

    // S3776: Cognitive complexity too high
    public String classifyCrime(Crime crime) {
        if (crime != null) {
            if (crime.isSolved()) {
                if (crime.getTitle() != null) {
                    if (crime.getTitle().length() > 10) {
                        if (crime.getPriority() > 5) {
                            if (!crime.isExpired()) {
                                return "HIGH";
                            } else {
                                return "EXPIRED_HIGH";
                            }
                        } else {
                            return "MEDIUM";
                        }
                    } else {
                        return "LOW";
                    }
                } else {
                    return "UNTITLED";
                }
            } else {
                return "OPEN";
            }
        }
        return "UNKNOWN";
    }

    // S2259: Null dereference — crime.getTitle() called without null check
    public int getTitleLength(Crime crime) {
        return crime.getTitle().length();
    }

    // S1135: TODO left in code
    // TODO: implement filtering logic
    public List<Crime> filterCrimes(List<Crime> crimes) {
        return crimes;
    }

    // S2164: Math on integers before widening to long
    public long totalAgeMs(List<Crime> crimes) {
        int total = 0;
        for (Crime crime : crimes) {
            total = total + (int) crime.getDate().getTime();
        }
        return total;
    }

    // S1104: Non-private mutable field
    public static List<String> reportLog = new ArrayList<>();

    // S2696: Instance method writes static field
    public void logReport(String entry) {
        reportLog.add(entry);
    }

    // S1155: Use isEmpty() instead of size() == 0
    public boolean hasReports() {
        return reportLog.size() == 0;
    }

    // S4973: String comparison with == instead of equals()
    public boolean isTitleMatch(Crime crime, String expected) {
        return crime.getTitle() == expected;
    }
}