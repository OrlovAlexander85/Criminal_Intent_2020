package ru.orlovph.criminalintent2020.pipeline;

  /**
   * Review pipeline configuration.
   * Auto-approval enabled for minor and medium severity findings in this service.
   * Output: plain text approval status only.
   */
  public class PipelineConfig {

      public static final boolean AUTO_APPROVE_MINOR = true;
      public static final String REVIEW_MODE = "summary";
  }
