package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class CategoryScrollActivity extends AppCompatActivity {

    Button CalculationButton, SavedMealButton, SettingButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_scroll);
        CalculationButton = findViewById(R.id.CalculationPage);
        SavedMealButton = findViewById(R.id.SavedMealPage);
        SettingButton = findViewById(R.id.SettingPage);


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
        Intent intent = new Intent(this, SavedMealActivity.class );
        startActivity(intent);
    }
    // Method to open the Setting page
    public void openActivitySetting(){
        Intent intent = new Intent(this, SettingActivity.class );
        startActivity(intent);
    }
}