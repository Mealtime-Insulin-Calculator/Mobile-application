package com.example.sqlite;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CategoryFragment extends Fragment {

    private Button buttonBack;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_category, container, false);

        buttonBack = rootView.findViewById(R.id.ButtonBack);
        buttonBack.setOnClickListener(buttonBackListener);
        return rootView;


    }

    private View.OnClickListener buttonBackListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SavedMealFragment savedMealFragment = new SavedMealFragment();
            ((MainActivity) getActivity()).fragmentOpenner(savedMealFragment);

        }
    };
}
