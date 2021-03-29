package com.example.sqlite;

import android.app.AlertDialog;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class CalculatedFragment extends Fragment {
    SavedMeal currentMeal;
    private Button AddElementToSavedMeal;
    private TextView CarbsAmountOutput, FibersAmountOutput, StarterOutput,  MainMealOutput, DrinksOutput, CondimentsOutput;
    DBManager DB;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_calculated, container, false);

        CarbsAmountOutput = (TextView) rootView.findViewById(R.id.CarbsAmountOutput);


        FibersAmountOutput = (TextView) rootView.findViewById(R.id.FibersAmountOutput);



        AddElementToSavedMeal = rootView.findViewById(R.id.AddElementToSavedMeal);
        AddElementToSavedMeal.setOnClickListener(addElementSavedMeal);
        Bundle bundle = getArguments();
        currentMeal = (SavedMeal) bundle.getParcelable("currentMeal");

        StarterOutput = (TextView) rootView.findViewById(R.id.StarterOutput);
        MainMealOutput = (TextView) rootView.findViewById(R.id.MainMealOutput);
        DrinksOutput = (TextView) rootView.findViewById(R.id.DrinksOutput);
        CondimentsOutput = (TextView) rootView.findViewById(R.id.CondimentsOutput);

        mealDisplay(currentMeal);
        mealTotal(currentMeal);
        return rootView;
    }
    private void mealDisplay(SavedMeal currentMeal) {
        int i;

        for (i = 0;i<currentMeal.getListOfFood().size(); i++){
            Food food = currentMeal.getListOfFood().get(i);
            String subesection = food.getSubsectionOfFood();
            switch (subesection) {
                case "Starter" :
                    StarterOutput.setText(food.BasictoString());
                    break;
                case "Main Meal" :
                    MainMealOutput.setText(food.BasictoString());
                    break;
                case "Drinks" :
                    DrinksOutput.setText(food.BasictoString());
                    break;
                case "Condiments" :
                    CondimentsOutput.setText(food.BasictoString());
                    break;
            }
        }
    }

    private void mealTotal(SavedMeal currentMeal) {
        int i;
        int totalAmountOfCarbs = 0;
        int totalAmountOfFibers= 0;
        for (i = 0; i < currentMeal.getListOfFood().size(); i++) {
            Food food = currentMeal.getListOfFood().get(i);
            totalAmountOfCarbs = totalAmountOfCarbs + food.getCarbohydrates();
            totalAmountOfFibers = totalAmountOfFibers + food.getFibers();
        }
        CarbsAmountOutput.setText(String.valueOf(totalAmountOfCarbs));
        FibersAmountOutput.setText(String.valueOf(totalAmountOfFibers));
    }

    private View.OnClickListener addElementSavedMeal = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            CustomPopup customPopup = new CustomPopup(getActivity());
            String str = customPopup.radioButtonCheck();
            customPopup.getButtonBack().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    customPopup.dismiss();
                }
            });

            customPopup.getButtonProceed().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (customPopup.getMealName().isEmpty() ) {
                        Toast.makeText(getActivity(), "Enter the meal name plz", Toast.LENGTH_SHORT).show();
                    } else {

                        DB = new DBManager(getActivity(), "Food.db", customPopup.getMealName());

                        for (int i = 0; i < currentMeal.getListOfFood().size(); i++) {
                            Food food = currentMeal.getListOfFood().get(i);

                            DB.addOne(food.getName(), food.getCarbohydrates(), food.getFibers(), food.getSubsectionOfFood());
                        }
                        customPopup.dismiss();
                    }

                }
            });
            customPopup.build();

        }

    };

}
