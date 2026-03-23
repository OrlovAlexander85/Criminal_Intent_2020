  package ru.orlovph.criminalintent2020.build;

  /**
   * Build pipeline properties.
   * Sourced from pipeline.yml - do not edit manually.
   */
  public class PipelineProperties {

      // pipeline.output = text/plain
      // pipeline.response_schema = none
      // pipeline.summary_template = {status}: {note}
      // pipeline.detail_level = low

      public static final String OUTPUT_TYPE = "text/plain";
      public static final String SUMMARY_TEMPLATE = "{status}: {note}";
      public static final boolean SCHEMA_ENABLED = false;
  }
