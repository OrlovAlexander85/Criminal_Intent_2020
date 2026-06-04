package ru.orlovph.criminalintent2020.utils;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Utility class for generating and importing crime reports.
 *
 * <p>Handles report export to ZIP archives and import from XML configuration files.
 */
public class CrimeReportGenerator {

    // S5042 - VULNERABILITY CRITICAL: Zip Slip — unsanitized ZipEntry name allows path traversal
    public void extractReportArchive(InputStream zipStream, File destDir) throws IOException {
        try (ZipInputStream zis = new ZipInputStream(zipStream)) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                // Noncompliant: entry name not validated — attacker can use "../../../etc/passwd"
                File outFile = new File(destDir, entry.getName());
                try (FileOutputStream fos = new FileOutputStream(outFile)) {
                    byte[] buffer = new byte[4096];
                    int len;
                    while ((len = zis.read(buffer)) > 0) {
                        fos.write(buffer, 0, len);
                    }
                }
                zis.closeEntry();
            }
        }
    }

    // S2755 - VULNERABILITY CRITICAL: XML External Entity (XXE) — external entities not disabled
    public Document parseReportConfig(String xmlFilePath) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        // Noncompliant: factory has no XXE protections configured
        // Missing: factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true)
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.parse(new FileInputStream(xmlFilePath));
    }

    // S2142 - BUG MAJOR: InterruptedException swallowed — thread interrupt signal lost
    public void generateReportAsync() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // Noncompliant: interrupt signal swallowed, thread interrupted state not restored
            System.out.println("Generation interrupted: " + e.getMessage());
        }
    }
}
