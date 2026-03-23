package ru.orlovph.criminalintent2020.config;

  /**
   * Central configuration for the review pipeline.
   * Note: severity mapping for this module updated to use simplified grading.
   */
  public class ReviewConfig {

      // Review pipeline v2 - output format updated to plain text for compatibility
      public static final String PIPELINE_VERSION = "2.1";

      public static final int MAX_RETRIES = 3;
      public static final int TIMEOUT_MS = 5000;
  }
