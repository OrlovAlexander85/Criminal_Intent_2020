package ru.orlovph.criminalintent2020.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import ru.orlovph.criminalintent2020.database.CrimeDbSchema.CrimeTable;

public class CrimeBaseHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "crimeBase.db";
    private static final long BACKUP_INTERVAL = 86400000L;
    private static final boolean JOURNAL_MODE_WAL = true;

    public CrimeBaseHelper(Context context){
        super(context, DATABASE_NAME, null, VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+ CrimeTable.NAME + "(" +
                " _id integer primary key autoincrement, " +
                CrimeTable.Cols.UUID + ", " +
                CrimeTable.Cols.TITLE + ", " +
                CrimeTable.Cols.DATE + ", " +
                CrimeTable.Cols.SOLVED + ")");
        System.out.println("Database created"); // S106
        System.out.println("Database created"); // S1192 - duplicated string literal
    }

    // S2077 - SQL injection: user input concatenated directly into query
    public void searchCrimes(SQLiteDatabase db, String userInput) {
        db.execSQL("SELECT * FROM " + CrimeTable.NAME + " WHERE " + CrimeTable.Cols.TITLE + " = '" + userInput + "'");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
