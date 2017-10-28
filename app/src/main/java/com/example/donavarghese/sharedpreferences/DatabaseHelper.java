package com.example.donavarghese.sharedpreferences;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "employees.db";



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME , null, DATABASE_VERSION);
    }


    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + ProductHelper.ProductEntry.TABLE_NAME + "("  + ProductHelper.ProductEntry._ID + " INTEGER PRIMARY KEY," +
            ProductHelper.ProductEntry.EMPLOYEE_NAME + " TEXT," + ProductHelper.ProductEntry.HOURS_WORKED+ " INTEGER," + ProductHelper.ProductEntry.EMPLOYEE_PAY +
            " REAL," + ProductHelper.ProductEntry.EMPLOYEE_ID + " INTEGER)";




    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){
    sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
}

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
     //   sqLiteDatabase.execSQL("DROP IF TABLE EXISTS " + DATABASE_VERSION);
        onCreate(sqLiteDatabase);
    }






}
























