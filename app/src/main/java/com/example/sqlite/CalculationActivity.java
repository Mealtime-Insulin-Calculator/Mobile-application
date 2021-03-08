package com.example.sqlite;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CalculationActivity extends AppCompatActivity {



    Button CalculationButton, SavedMealButton, SettingButton, SaveToSavedMeal;
    EditText MealName, StarterText;



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculation);
        CalculationButton = findViewById(R.id.CalculationPage);
        SavedMealButton = findViewById(R.id.SavedMealPage);
        SettingButton = findViewById(R.id.SettingPage);

        SaveToSavedMeal = findViewById(R.id.SaveToSavedMeal);
        MealName = (EditText) findViewById(R.id.MealName);

        TextView StarterText = (TextView)findViewById(R.id.StarterText);
        // By default we are on the starter subsection


        Intent intent = getIntent();
        SavedMeal currentMeal = getIntent().getParcelableExtra("currentMeal");


        ArrayList<Food> Starter = currentMeal.getListOfFood();
        int Fibers = Starter.get(0).getFibers();
        int Carbs = Starter.get(0).getCarbohydrates();
        String Name = Starter.get(0).getName();

        Display(StarterText,Name, Carbs, Fibers);

        SaveToSavedMeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MealName.getText().toString().isEmpty()) {
                    Toast.makeText(CalculationActivity.this, "Missing the name of the meal!", Toast.LENGTH_SHORT).show();
                } else {
                    startActivity(new Intent(CalculationActivity.this,pop_up.class));
                }

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
    public void openActivityCalculation() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    // Method to open the Saved Meal activity page
    public void openActivitySavedMeal() {
        Intent intent = new Intent(this, SavedMealActivity.class);
        startActivity(intent);
    }

    // Method to open the Setting page
    public void openActivitySetting() {
        Intent intent = new Intent(this, SettingActivity.class);
        startActivity(intent);
    }

    public void Display(TextView TextType,String Name, int Carbs, int Fibers){
        TextType.setText("Starter:" + Name + " Carbs : " + Carbs + " Fibers : " + Fibers);
    }




}




