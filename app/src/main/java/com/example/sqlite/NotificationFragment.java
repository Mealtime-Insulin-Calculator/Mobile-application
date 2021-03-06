package com.example.sqlite;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class NotificationFragment extends Fragment {

    private Button buttonBack;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_notification, container, false);

        buttonBack = rootView.findViewById(R.id.ButtonBack);
        buttonBack.setOnClickListener(buttonBackListener);
        return rootView;


    }

    private View.OnClickListener buttonBackListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SettingsFragment settingsFragment = new SettingsFragment();
            ((MainActivity) getActivity()).fragmentOpenner(settingsFragment);

        }
    };
}
