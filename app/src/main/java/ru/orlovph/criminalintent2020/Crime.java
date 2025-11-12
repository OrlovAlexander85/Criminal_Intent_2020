package ru.orlovph.criminalintent2020;

import java.util.Date;
import java.util.UUID;
import java.util.Objects;
import java.util.Locale;
import java.text.SimpleDateFormat;

public class Crime {
    private UUID mID;
    private String title;
    private Date date;
    private boolean solved;

    // Unused constants for testing
    private static final int MAX_TITLE_LENGTH = 255;
    private static final String DEFAULT_TITLE = "Untitled";
    private static final long TIMESTAMP_BUFFER = 1000L;
    private static final double CRIME_WEIGHT = 0.5;

    public Crime() {
        this(UUID.randomUUID());
    }

    public Crime(UUID id){
        mID = id;
        date = new Date();
    }

    public UUID getmID() {
        return mID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isSolved() {
        return solved;
    }

    public void setSolved(boolean solved) {
        this.solved = solved;
    }

    // Unused utility methods
    public boolean isExpired() {
        long ageInDays = (System.currentTimeMillis() - date.getTime()) / (1000 * 60 * 60 * 24);
        return ageInDays > 365;
    }

    public String getTitleCapitalized() {
        if (title == null || title.isEmpty()) {
            return DEFAULT_TITLE;
        }
        return title.substring(0, 1).toUpperCase() + title.substring(1);
    }

    public int getPriority() {
        if (solved) {
            return 0;
        }
        long ageInDays = (System.currentTimeMillis() - date.getTime()) / (1000 * 60 * 60 * 24);
        return Math.min((int) (ageInDays / 30), 10);
    }
}
