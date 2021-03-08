package com.example.sqlite;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {
    EditText Subsection, ElementName, Carb, Fiber;
    Button Starter, MainMeal, Drinks, Condiments, Calculate, CalculationButton,SavedMealButton, SettingButton;
    DBManager DB;
    public SavedMeal currentMeal = new SavedMeal();
    // public static String verifySubsection = "Starter";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView Subsection = (TextView)findViewById(R.id.SubsectionName);
        // By default we are on the starter subsection
        Subsection.setText("Starter");

        ElementName = (EditText)findViewById(R.id.ElementName);
        Carb = (EditText)findViewById(R.id.Carb);
        Fiber = (EditText)findViewById(R.id.Fiber);




        Starter = findViewById(R.id.Starter);
        MainMeal = findViewById(R.id.MainMeal);
        Drinks = findViewById(R.id.Drinks);
        Condiments = findViewById(R.id.Condiments);

        Calculate = findViewById(R.id.Calculate);





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

        // Subsection buttons
        Starter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Subsection.setText("Starter");
                // subsectionUpdate("Starter");

                if (ElementName.getText().toString().isEmpty() || Carb.getText().toString().isEmpty() || Fiber.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Enter correctly the data", Toast.LENGTH_SHORT).show();
                } else {


                    Food starter = new Food(Integer.parseInt(Carb.getText().toString()), Integer.parseInt(Fiber.getText().toString()), ElementName.getText().toString(), "Starter");
                    currentMeal.additionOfFood(starter);

                    Toast.makeText(MainActivity.this, "currentMeal : " + currentMeal, Toast.LENGTH_LONG).show();

                }


            }
        });

        MainMeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Subsection.setText("MainMeal");
                //subsectionUpdate("MainMeal");
            }
        });

        Drinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Subsection.setText("Drinks");
                //subsectionUpdate("Drinks");
            }
        });

        Condiments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Subsection.setText("Condiments");
                //subsectionUpdate("Condiments");
            }
        });

        Calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityCalculate();

                String TableName;


                // DB = new DBManager(this, "Food.db", TableName);
            }
        });



    }
    // Method to open the Saved Meal activity page
    public void openActivityCalculation(){
        Toast.makeText(MainActivity.this, "You are already on this page!", Toast.LENGTH_SHORT).show();
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

    public void openActivityCalculate(){
        Intent intent = new Intent(this, CalculationActivity.class ).putExtra("currentMeal", (Parcelable) currentMeal);
        startActivity(intent);
    }
    /*
    public void subsectionUpdate(String subsectionName){
        this.verifySubsection = subsectionName;
    }

     */

}


