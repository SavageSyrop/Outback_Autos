package com.example.outback_autos;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;

public class CarInfoDBHelper extends SQLiteOpenHelper {
    private CarInfoDBFiller CarInfoDBFiller;
    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_CAR_INFO_ENTRIES = "CREATE TABLE " + CarInfoContract.CarInfoEntry.TABLE_NAME + " (" +
            CarInfoContract.CarInfoEntry._ID + " INTEGER PRIMARY KEY" + COMMA_SEP +
            CarInfoContract.CarInfoEntry.BRAND + TEXT_TYPE + COMMA_SEP +
            CarInfoContract.CarInfoEntry.MODEL + TEXT_TYPE + COMMA_SEP +
            CarInfoContract.CarInfoEntry.IMAGE_NAME + TEXT_TYPE + COMMA_SEP +
            CarInfoContract.CarInfoEntry.MAX_POWER + TEXT_TYPE + COMMA_SEP +
            CarInfoContract.CarInfoEntry.MAX_SPEED + TEXT_TYPE + COMMA_SEP +
            CarInfoContract.CarInfoEntry.FUEL_CONSUMPTION + TEXT_TYPE + COMMA_SEP +
            CarInfoContract.CarInfoEntry.MAX_TORQUE + TEXT_TYPE + COMMA_SEP +
            CarInfoContract.CarInfoEntry.CLEARANCE + TEXT_TYPE + COMMA_SEP +
            CarInfoContract.CarInfoEntry.DRIVE + TEXT_TYPE + COMMA_SEP +
            CarInfoContract.CarInfoEntry.PRICE + TEXT_TYPE + " )";
    private static final String SQL_CREATE_BRAND_INFO_ENTRIES = "CREATE TABLE " + CarInfoContract.BrandInfoEntry.TABLE_NAME + " (" +
            CarInfoContract.BrandInfoEntry._ID + " INTEGER PRIMARY KEY" + COMMA_SEP +
            CarInfoContract.BrandInfoEntry.BRAND + TEXT_TYPE + COMMA_SEP +
            CarInfoContract.BrandInfoEntry.IMAGE_NAME + TEXT_TYPE + COMMA_SEP +
            CarInfoContract.BrandInfoEntry.INFO + TEXT_TYPE + " )";

    private static final String SQL_DELETE_CAR_INFO_ENTRIES = "DROP TABLE IF EXISTS " + CarInfoContract.CarInfoEntry.TABLE_NAME;
    private static final String SQL_DELETE_BRAND_INFO_ENTRIES = "DROP TABLE IF EXISTS " + CarInfoContract.BrandInfoEntry.TABLE_NAME;
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "CarInfo.db";

    public CarInfoDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        if (!(dataBaseExists(context))) {
            CarInfoDBFiller = new CarInfoDBFiller(this);
            CarInfoDBFiller.fillDB();
        }
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_CAR_INFO_ENTRIES);
        sqLiteDatabase.execSQL(SQL_CREATE_BRAND_INFO_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQL_DELETE_CAR_INFO_ENTRIES);
        sqLiteDatabase.execSQL(SQL_DELETE_BRAND_INFO_ENTRIES);
        onCreate(sqLiteDatabase);
    }

    public void onDowngrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        onUpgrade(sqLiteDatabase, oldVersion, newVersion);
    }

    private Boolean dataBaseExists(Context context) {
        try {
            SQLiteDatabase checkDataBase = SQLiteDatabase.openDatabase(context.getDatabasePath(DATABASE_NAME).getAbsolutePath(), null, SQLiteDatabase.OPEN_READONLY);
            checkDataBase.close();
        } catch (SQLiteException e) {
            return false;
        }
        return true;
    }

    public ArrayList<ArrayList<String>> getCarInfoRecords(String selection, String[] selectionArgs) {
        SQLiteDatabase database = getReadableDatabase();
        String[] projection = {
                CarInfoContract.CarInfoEntry._ID,
                CarInfoContract.CarInfoEntry.BRAND,
                CarInfoContract.CarInfoEntry.MODEL,
                CarInfoContract.CarInfoEntry.IMAGE_NAME,
                CarInfoContract.CarInfoEntry.MAX_POWER,
                CarInfoContract.CarInfoEntry.MAX_SPEED,
                CarInfoContract.CarInfoEntry.FUEL_CONSUMPTION,
                CarInfoContract.CarInfoEntry.MAX_TORQUE,
                CarInfoContract.CarInfoEntry.CLEARANCE,
                CarInfoContract.CarInfoEntry.DRIVE,
                CarInfoContract.CarInfoEntry.PRICE
        };

        String sortOrder = CarInfoContract.CarInfoEntry.BRAND + " ASC";
        Cursor cursor = database.query(
                CarInfoContract.CarInfoEntry.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                sortOrder
        );
        cursor.moveToFirst();
        ArrayList<ArrayList<String>> table = new ArrayList<>();
        while (!cursor.isAfterLast()) {
            ArrayList<String> row = new ArrayList<>();
            row.add(cursor.getString(cursor.getColumnIndexOrThrow(CarInfoContract.CarInfoEntry._ID)));
            row.add(cursor.getString(cursor.getColumnIndexOrThrow(CarInfoContract.CarInfoEntry.BRAND)));
            row.add(cursor.getString(cursor.getColumnIndexOrThrow(CarInfoContract.CarInfoEntry.MODEL)));
            row.add(cursor.getString(cursor.getColumnIndexOrThrow(CarInfoContract.CarInfoEntry.IMAGE_NAME)));
            row.add(cursor.getString(cursor.getColumnIndexOrThrow(CarInfoContract.CarInfoEntry.MAX_POWER)));
            row.add(cursor.getString(cursor.getColumnIndexOrThrow(CarInfoContract.CarInfoEntry.MAX_SPEED)));
            row.add(cursor.getString(cursor.getColumnIndexOrThrow(CarInfoContract.CarInfoEntry.FUEL_CONSUMPTION)));
            row.add(cursor.getString(cursor.getColumnIndexOrThrow(CarInfoContract.CarInfoEntry.MAX_TORQUE)));
            row.add(cursor.getString(cursor.getColumnIndexOrThrow(CarInfoContract.CarInfoEntry.CLEARANCE)));
            row.add(cursor.getString(cursor.getColumnIndexOrThrow(CarInfoContract.CarInfoEntry.DRIVE)));
            row.add(cursor.getString(cursor.getColumnIndexOrThrow(CarInfoContract.CarInfoEntry.PRICE)));
            table.add(row);
            cursor.moveToNext();
        }
        return table;
    }

    public ArrayList<String> getBrandInfoRecords(String selection, String[] selectionArgs) {
        SQLiteDatabase database = getReadableDatabase();
        String[] projection = {
                CarInfoContract.BrandInfoEntry._ID,
                CarInfoContract.BrandInfoEntry.BRAND,
                CarInfoContract.BrandInfoEntry.IMAGE_NAME,
                CarInfoContract.BrandInfoEntry.INFO
        };

        String sortOrder = CarInfoContract.BrandInfoEntry.BRAND + " ASC";
        Cursor cursor = database.query(
                CarInfoContract.BrandInfoEntry.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                sortOrder
        );
        cursor.moveToFirst();
        ArrayList<ArrayList<String>> table = new ArrayList<>();
        while (!cursor.isAfterLast()) {
            ArrayList<String> row = new ArrayList<>();
            row.add(cursor.getString(cursor.getColumnIndexOrThrow(CarInfoContract.BrandInfoEntry._ID)));
            row.add(cursor.getString(cursor.getColumnIndexOrThrow(CarInfoContract.BrandInfoEntry.BRAND)));
            row.add(cursor.getString(cursor.getColumnIndexOrThrow(CarInfoContract.BrandInfoEntry.IMAGE_NAME)));
            row.add(cursor.getString(cursor.getColumnIndexOrThrow(CarInfoContract.BrandInfoEntry.INFO)));
            table.add(row);
            cursor.moveToNext();
        }
        return table.get(0);
    }
}