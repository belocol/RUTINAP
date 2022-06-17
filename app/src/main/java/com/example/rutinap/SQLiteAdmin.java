package com.example.rutinap;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteAdmin extends SQLiteOpenHelper {

    private  static final int DATABASE_VERSION = 1;
    private  static final String DATABASE_NOMBBRE = "Rutina.db";
    public  static final String TABLE_RUTINAS = "t_rutinas";

    public SQLiteAdmin(@Nullable Context context) {
        super(context,DATABASE_NOMBBRE , null,DATABASE_VERSION );
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_RUTINAS + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " ejerciciouno TEXT NOT NULL," +
                " ejerciciodos TEXT NOT NULL," +
                " ejerciciotres TEXT NOT NULL," +
                " ejerciciocuatro TEXT NOT NULL)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

            sqLiteDatabase.execSQL("DROP TABLE " + TABLE_RUTINAS);
            onCreate(sqLiteDatabase);

    }
}
