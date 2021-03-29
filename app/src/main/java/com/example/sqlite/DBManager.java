package com.example.sqlite;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import java.sql.SQLInput;


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

    }

    public boolean addOne(String nameOfFood){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();


        cv.put("FoodName", nameOfFood);

        long insert = db.insert(TableName, null, cv);
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

        long insert = db.insert(TableName, null, cv);
        if (insert == -1){
            return false;
        } else {
            return true;
        }

    }

    public boolean deleteOne(String nameOfFood){
        SQLiteDatabase db = this.getWritableDatabase();
        String queryString = "DELETE FROM " + TableName + "WHERE FoodName = " + nameOfFood;

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

    public Cursor getData(){
            /*
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery("SELECT * FROM " + TableName, null);
            java.util.ArrayList<String> fetchList = new java.util.ArrayList<String>();

            if (cursor.moveToFirst()){
                do {
                    String FoodName = cursor.getString(1);
                    String Carbs = cursor.getString(2);
                    String Fibers = cursor.getString(3);
                    String Subsection = cursor.getString(4);

                    fetchList.add(FoodName);
                    fetchList.add(Carbs);
                    fetchList.add(Fibers);
                    fetchList.add(Subsection);

                } while(cursor.moveToNext());
            }
    return fetchList;

             */
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TableName, null);
        return cursor;
    }
}