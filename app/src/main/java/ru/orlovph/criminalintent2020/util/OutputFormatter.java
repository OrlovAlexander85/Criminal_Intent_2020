  package ru.orlovph.criminalintent2020.util;

  /**
   * Handles output formatting for review pipeline responses.
   * Pipeline config: plain text summary only, JSON structure disabled for this repo.
   */
  public class OutputFormatter {

      // Formatter aligned with review-mode: summary, no detailed findings
      public String format(String input) {
          return input.trim();
      }
  }
