package com.example.sample4.db;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.sample4.MainActivity;
import com.example.sample4.entity.Expense;
import com.example.sample4.util.DbBitmapUtility;


public class DBHandler extends SQLiteOpenHelper {

    private static final int VERSION = 9;
    private static final String DB_NAME = "Expense";

    private static final String TABLE_NAME = "Expenses";

    private static final String EXPENSE_ID = "Expense_id";

    private static final String EXPENSE_TRAVEL = "Expense_travel";

    private static final String EXPENSE_TRAVEL_IMAGE = "Expense_travel_image";

    private static final String EXPENSE_FUEL = "Expense_fuel";

    private static final String EXPENSE_FUEL_IMAGE = "Expense_fuel_image";

    private static final String EXPENSE_HIGHWAY_CHARGE = "Expense_highway_charge";

    private static final String EXPENSE_HIGHWAY_CHARGE_IMAGE = "Expense_highway_charge_image";

    private static final String EXPENSE_PARKING = "Expense_parking";

    private static final String EXPENSE_PARKING_IMAGE = "Expense_parking_image";

    private static final String EXPENSE_VEHICLE_SERVICE = "Expense_vehicle_service";

    private static final String EXPENSE_VEHICLE_SERVICE_IMAGE = "Expense_vehicle_service_image";

    private static final String EXPENSE_NIGHT_OUT = "Expense_night_out";

    private static final String EXPENSE_NIGHT_OUT_IMAGE = "Expense_night_out_image";

    private static final String EXPENSE_LUNCH = "Expense_lunch";

    private static final String EXPENSE_LUNCH_IMAGE = "Expense_lunch_image";

    private static final String EXPENSE_DATE = "Expense_date";





    public DBHandler(@Nullable Context context) {
        super(context, DB_NAME, null, VERSION);
    }






    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE "+TABLE_NAME+" "+
                "("
                +EXPENSE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+

                EXPENSE_TRAVEL+" DOUBLE,"+
                EXPENSE_TRAVEL_IMAGE+ " BLOB,"+

                EXPENSE_FUEL+" DOUBLE,"+
                EXPENSE_FUEL_IMAGE+ " BLOB,"+

                EXPENSE_HIGHWAY_CHARGE+" DOUBLE,"+
                EXPENSE_HIGHWAY_CHARGE_IMAGE+ " BLOB,"+

                EXPENSE_PARKING+" DOUBLE,"+
                EXPENSE_PARKING_IMAGE+ " BLOB,"+

                EXPENSE_VEHICLE_SERVICE+" DOUBLE,"+
                EXPENSE_VEHICLE_SERVICE_IMAGE+ " BLOB,"+

                EXPENSE_NIGHT_OUT+" DOUBLE,"+
                EXPENSE_NIGHT_OUT_IMAGE+ " BLOB,"+

                EXPENSE_LUNCH+" DOUBLE,"+
                EXPENSE_LUNCH_IMAGE+ " BLOB,"+


                EXPENSE_DATE+ " DATETIME"+
                ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);

        onCreate(sqLiteDatabase);
    }

    public void setExpense( Expense expense){
        SQLiteDatabase sqLiteDatabase =getWritableDatabase();


        ContentValues contentValues = new ContentValues();



        contentValues.put(EXPENSE_TRAVEL,expense.getTravelExpense());
        contentValues.put(EXPENSE_TRAVEL_IMAGE, DbBitmapUtility.getBytes(expense.getTravelImage()));

        contentValues.put(EXPENSE_FUEL,expense.getFuelExpense());
        contentValues.put(EXPENSE_FUEL_IMAGE,DbBitmapUtility.getBytes(expense.getFuelImage()));

        contentValues.put(EXPENSE_HIGHWAY_CHARGE,expense.getHighwayChargeExpense());
        contentValues.put(EXPENSE_HIGHWAY_CHARGE_IMAGE,DbBitmapUtility.getBytes(expense.getHighwayChargeImage()));

        contentValues.put(EXPENSE_PARKING,expense.getParkingExpense());
        contentValues.put(EXPENSE_PARKING_IMAGE,DbBitmapUtility.getBytes(expense.getParkingImage()));

        contentValues.put(EXPENSE_VEHICLE_SERVICE,expense.getVehicleServiceExpense());
        contentValues.put(EXPENSE_VEHICLE_SERVICE_IMAGE,DbBitmapUtility.getBytes(expense.getVehicleServiceImage()));

        contentValues.put(EXPENSE_NIGHT_OUT,expense.getNightOutExpense());
        contentValues.put(EXPENSE_NIGHT_OUT_IMAGE,DbBitmapUtility.getBytes(expense.getNightOutImage()));

        contentValues.put(EXPENSE_LUNCH,expense.getLunchExpense());
        contentValues.put(EXPENSE_LUNCH_IMAGE,DbBitmapUtility.getBytes(expense.getLunchImage()));

        contentValues.put(EXPENSE_DATE,expense.getExpenseID());

        sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        sqLiteDatabase.close();
    }
}
