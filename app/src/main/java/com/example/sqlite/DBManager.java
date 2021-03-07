package com.example.sqlite;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Button;

import androidx.annotation.Nullable;

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
        String createTableSatement;
        if (DatabaseName == "Category.db"){
            createTableSatement = "CREATE TABLE " + TableName + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, FoodName TEXT)";
            db.execSQL(createTableSatement);
        } else if (DatabaseName == "Food.db") {

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

            SQLiteDatabase db = this.getReadableDatabase();
            Cursor res = db.rawQuery("SELECT * FROM " + TableName, null);
    return res;
    }
}