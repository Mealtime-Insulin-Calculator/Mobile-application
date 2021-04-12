package com.example.sqlite;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CategorySnacksFragment extends Fragment {
    private DBManager DB;
    private Button buttonBack;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_category, container, false);

        buttonBack = rootView.findViewById(R.id.ButtonBack);
        buttonBack.setOnClickListener(buttonBackListener);



        // set up the RecyclerView
        RecyclerView recyclerView = rootView.findViewById(R.id.RecycleView);
        recyclerView.setAdapter(new CustomAdapter(generateData(),this));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        DB = new DBManager(getActivity(), "Food.db");


        return rootView;


    }

    private List<String> generateData() {
        List<String> data = new ArrayList<>();
        DB = new DBManager(getActivity(), "Food.db");

        for (int i = 0; i < DB.viewData().size()-1; i++) {
            String name = DB.viewData().get(i+1);
            String category = DB.getCategory(name);

            if (category.equals("Snacks")){
                data.add(name);
            } else {
                // nothing
            }

        }
        return data;
    }

    private View.OnClickListener buttonBackListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SavedMealFragment savedMealFragment = new SavedMealFragment();
            ((MainActivity) getActivity()).fragmentOpenner(savedMealFragment);

        }
    };

}
