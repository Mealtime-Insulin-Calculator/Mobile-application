package com.example.sqlite;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {
    EditText Subsection, ElementName, Carb, Fiber;
    Button Starter, MainMeal, Drinks, Condiments, Calculate, CalculationButton,SavedMealButton, SettingButton;
    DBManager DB;

    Button Breakfast, Lunch, Dinner, Snacks;
    public SavedMeal currentMeal = new SavedMeal();
    // public static String verifySubsection = "Starter";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_saved_meal2);


        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);

        CalculationButton = findViewById(R.id.CalculationPage);
        SavedMealButton = findViewById(R.id.SavedMealPage);
        SettingButton = findViewById(R.id.SettingPage);

        Breakfast = findViewById(R.id.Breakfast);
        Lunch = findViewById(R.id.Lunch);
        Dinner = findViewById(R.id.Dinner);
        Snacks = findViewById(R.id.Snacks);


        // Database creation
        // getApplicationContext().deleteDatabase("Category.db");
        DB = new DBManager(this,"Category.db", "Breakfast");


        bottomNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new CalculationFragment()).commit();
    }


    public void fragmentOpenner(Object fragmentClass) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, (Fragment) fragmentClass).commit();
    }


    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.nav_calculation:
                            selectedFragment = new CalculationFragment();
                            break;
                        case R.id.nav_meals:
                            selectedFragment = new SavedMealFragment();
                            break;
                        case R.id.nav_settings:
                            selectedFragment = new SettingsFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                    return true;
                }
            };

}



