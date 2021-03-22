package com.example.sqlite;

import android.app.FragmentManager;
import android.os.Bundle;
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

public class CalculationFragment extends Fragment {
    public SavedMeal currentMeal = new SavedMeal();
    private int numbersOfElements;
    private String subsectionName;

    private TextView Subsection;
    private EditText ElementName;
    private EditText Carb;
    private EditText Fiber;
    private  Button Starter, MainMeal, Drinks, Condiments, Calculate, AddElement;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_calculate, container, false);

        Subsection = (TextView) rootView.findViewById(R.id.SubsectionName);
        // By default we are on the starter subsection
        subsectionName = "Starter";
        Subsection.setText(subsectionName);


        // Editable text
        ElementName = (EditText)rootView.findViewById(R.id.ElementName);
        Carb = (EditText)rootView.findViewById(R.id.Carb);
        Fiber = (EditText)rootView.findViewById(R.id.Fiber);

        // Buttons
        Starter = rootView.findViewById(R.id.Starter);
        MainMeal = rootView.findViewById(R.id.MainMeal);
        Drinks = rootView.findViewById(R.id.Drinks);
        Condiments = rootView.findViewById(R.id.Condiments);
        AddElement = rootView.findViewById(R.id.AddElement);

        Calculate = rootView.findViewById(R.id.Calculate);

        Calculate.setOnClickListener(calculateListener);

        Starter.setOnClickListener(starterListener);
        MainMeal.setOnClickListener(mainMealListener);
        Drinks.setOnClickListener(drinkListener);
        Condiments.setOnClickListener(condimentsListener);



        AddElement.setOnClickListener(addElement);
        return rootView ;
    }

    private View.OnClickListener calculateListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if (currentMeal.getListOfFood().size()>0) {
                Toast.makeText(getActivity(),"you pass", Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(getActivity(),"you dont", Toast.LENGTH_SHORT).show();
            }

        }
    };

    private View.OnClickListener addElement = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (ElementName.getText().toString().isEmpty() || Carb.getText().toString().isEmpty() || Fiber.getText().toString().isEmpty()) {
                Toast.makeText(getActivity(), "no data you dummy", Toast.LENGTH_SHORT).show();

                getParentFragmentManager().beginTransaction().replace(R.id.fragment_container, new CalculationFragment()).commit();

            } else {
                ElementName.setText("");
                /*
                * Carb.getText().clear() and
                * Carb.setText("")
                * dont work
                * idk why
                * plz help
                *
                * */
                Food starter = new Food(Integer.parseInt(Carb.getText().toString()), Integer.parseInt(Fiber.getText().toString()), ElementName.getText().toString(), subsectionName );
                currentMeal.additionOfFood(starter);


                Toast.makeText(getActivity(),"Food have been added" + currentMeal.getListOfFood().size(), Toast.LENGTH_LONG).show();
            }

        }
    };



    private View.OnClickListener starterListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            subsectionName = "Starter";
            Subsection.setText(subsectionName);

        }
    };

    private View.OnClickListener mainMealListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            subsectionName = "Main Meal";
            Subsection.setText(subsectionName);

        }
    };

    private View.OnClickListener drinkListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            subsectionName = "Drinks";
            Subsection.setText(subsectionName);

        }
    };

    private View.OnClickListener condimentsListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            subsectionName = "Condiments";
            Subsection.setText(subsectionName);

        }
    };


}
