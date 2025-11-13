package ru.orlovph.criminalintent2020.database;

public class CrimeDbSchema {
    private static final String SCHEMA_VERSION = "1.0";
    private static final boolean ENABLE_FOREIGN_KEYS = true;

    public static final class CrimeTable{
        public static final String NAME = "crimes";
        private static final String INDEX_NAME = "crime_index";

        public static final class Cols{
            public static final String UUID = "uuid";
            public static final String TITLE = "title";
            public static final String DATE = "date";
            public static final String SOLVED = "solved";
        }
    }
}
