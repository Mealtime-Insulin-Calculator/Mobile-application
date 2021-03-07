package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class SavedMealActivity extends AppCompatActivity {
    Button CalculationButton, SavedMealButton, SettingButton;
    Button Breakfast, Lunch, Dinner, Snacks;
    Button TestValue, FetchValue;
    DBManager DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_meal);

        CalculationButton = findViewById(R.id.CalculationPage);
        SavedMealButton = findViewById(R.id.SavedMealPage);
        SettingButton = findViewById(R.id.SettingPage);

        Breakfast = findViewById(R.id.Breakfast);
        Lunch = findViewById(R.id.Lunch);
        Dinner = findViewById(R.id.Dinner);
        Snacks = findViewById(R.id.Snacks);

        TestValue = findViewById(R.id.TestValue);
        FetchValue = findViewById(R.id.FetchValue);

        // Database creation
        // getApplicationContext().deleteDatabase("Category.db");
        DB = new DBManager(this,"Category.db", "Breakfast");


        TestValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 boolean sucess = DB.addOne("Lasagna");
                Toast.makeText(SavedMealActivity.this, "Sucess " + sucess, Toast.LENGTH_SHORT).show();
            }
        });

        FetchValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> res = DB.getData();
                Toast.makeText(SavedMealActivity.this, "resultat: " + res, Toast.LENGTH_SHORT).show();
            }
        });
        Breakfast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityCategory();
            }
        });

        Lunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityCategory();
            }
        });

        Dinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityCategory();
            }
        });

        Snacks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityCategory();
            }
        });

        // Button to go through the Calculation page
        CalculationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityCalculation();
            }
        });

        // Button to go through the Saved Meal page
        SavedMealButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivitySavedMeal();
            }
        });

        // Button to go through the Setting page
        SettingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivitySetting();
            }
        });
    }
    // Method to open the Saved Meal activity page
    public void openActivityCalculation(){
        Intent intent = new Intent(this, MainActivity.class );
        startActivity(intent);
    }

    // Method to open the Saved Meal activity page
    public void openActivitySavedMeal(){
        Toast.makeText(SavedMealActivity.this, "You are already on this page!", Toast.LENGTH_SHORT).show();
    }
    // Method to open the Setting page
    public void openActivitySetting(){
        Intent intent = new Intent(this, SettingActivity.class );
        startActivity(intent);
    }

    // Method to open the Setting page
    public void openActivityCategory(){
        Intent intent = new Intent(this, CategoryScrollActivity.class );
        startActivity(intent);
    }
}