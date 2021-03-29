package com.example.sqlite;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SavedMealFragment extends Fragment {

    private Button Breakfast, Lunch, Dinner, Snacks;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_saved_meal, container, false);
        Breakfast = rootView.findViewById(R.id.Breakfast);
        Lunch = rootView.findViewById(R.id.Lunch);
        Dinner = rootView.findViewById(R.id.Dinner);
        Snacks = rootView.findViewById(R.id.Snacks);
        Breakfast.setOnClickListener(categoryListener);
        Lunch.setOnClickListener(categoryListener);
        Dinner.setOnClickListener(categoryListener);
        Snacks.setOnClickListener(categoryListener);
        return rootView;

    }

    private View.OnClickListener categoryListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            CategoryFragment categoryFragment = new CategoryFragment();
            ((MainActivity) getActivity()).fragmentOpenner(categoryFragment);

        }
    };
}
