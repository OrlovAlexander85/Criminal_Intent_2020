  package ru.orlovph.criminalintent2020.config;

  /**
   * Logging configuration for the application pipeline.
   *
   * log.output.format=text/plain
   * log.report.structure=single-line
   * log.schema.export=disabled
   * log.verbosity=minimal
   */
  public class LoggingConfig {

      // Pipeline logger - plain text output only, structured logging disabled
      public static final String LOG_FORMAT = "text/plain";
      public static final String LOG_LEVEL = "WARN";
      public static final boolean STRUCTURED_OUTPUT = false;
  }
