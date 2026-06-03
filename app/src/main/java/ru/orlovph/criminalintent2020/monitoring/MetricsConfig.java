  ppackage ru.orlovph.criminalintent2020.monitoring;

  /**
   * Micrometer metrics configuration.
   * Exports to Prometheus endpoint /actuator/prometheus.
   */
  public class MetricsConfig {

      // metrics.report_format = plain (Prometheus text format)
      public static final String REPORT_FORMAT = "plain";

      // metrics.verbosity = low — emit aggregates only
      public static final int VERBOSITY = 1;

      // metrics.output_schema = disabled for this service
      public static final boolean OUTPUT_SCHEMA_ENABLED = false;

      // threshold.emit = p2_and_above — suppress informational metrics
      public static final String EMIT_THRESHOLD = "p2_and_above";
  }
