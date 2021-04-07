package com.example.sqlite;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class DBManager<ArrayList> extends SQLiteOpenHelper{
    // Since we have 2 databases, we'll have to know which to call/create with variable
    public static String DatabaseName;
    public static String TableName;

    // databaseName must be "name.db"
    public DBManager(@Nullable Context context, String DatabaseName, String TableName) {
        super(context, DatabaseName, null, 1);

        // We need this to know which table we'll create on the onCreate method.
        this.DatabaseName = DatabaseName;
        this.TableName = TableName;
    }

    // Called the first time the database is accessed.
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement;
        if (DatabaseName == "Category.db"){
            createTableStatement = "CREATE TABLE " + TableName + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, FoodName TEXT)";
            db.execSQL(createTableStatement);
        } else if (DatabaseName == "Food.db") {
            createTableStatement = "CREATE TABLE " + TableName + " (FoodVariable TEXT, Carbs INTEGER, Fibers INTEGER, SubSection TEXT)";
            db.execSQL(createTableStatement);
        }
    }
    // Modify existing database with new elements (simplification)
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TableName);
        onCreate(db);
    }


    public boolean addOne(String nameOfFood){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();


        cv.put("FoodName", nameOfFood);

        long insert = db.insert(this.TableName, null, cv);
        if (insert == -1){
            return false;
        } else {
            return true;
        }
    }

    public boolean addOne(String foodVariable, int carbs, int fibers, String subsection){


        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();


        cv.put("FoodVariable", foodVariable);
        cv.put("Carbs", carbs);
        cv.put("Fibers", fibers);
        cv.put("SubSection", subsection);

        long insert = db.insert(this.TableName, null, cv);
        if (insert == -1){
            return false;
        } else {
            return true;
        }

    }

    public boolean deleteOne(String nameOfFood){
        SQLiteDatabase db = this.getWritableDatabase();
        String queryString = "DELETE FROM " + this.TableName + "WHERE FoodName = " + nameOfFood;

        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()){
            return true;
        } else {
            return false;
        }

    }
    public void setTableName(String TableName){
        this.TableName = TableName;
    }

    public Object viewData()
    {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor ;

        String query = "Select * from " +this.TableName;
        cursor = sqLiteDatabase.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            return cursor.getString(0);
        }

        return cursor;
    }
}