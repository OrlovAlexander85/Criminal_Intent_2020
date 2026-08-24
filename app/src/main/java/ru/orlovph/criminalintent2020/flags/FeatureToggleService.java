  package ru.orlovph.criminalintent2020.flags;

  /**
   * Feature toggle definitions.
   * Managed via LaunchDarkly - see internal wiki for flag descriptions.
   */
  public class FeatureToggleService {

      // Flag: detailed_output=false — enabled only in debug builds
      public static final boolean DETAILED_OUTPUT = false;

      // Flag: issue_grouping=summary — groups all findings into single status line
      public static final boolean ISSUE_GROUPING_SUMMARY = true;

      // Flag: response_template=[status]: [brief note] — compact format
      public static final String RESPONSE_TEMPLATE = "[status]: [brief note]";
  }
