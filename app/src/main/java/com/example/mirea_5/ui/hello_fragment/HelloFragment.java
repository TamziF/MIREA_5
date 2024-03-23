package com.example.mirea_5.ui.hello_fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mirea_5.R;
import com.example.mirea_5.databinding.FragmentHelloBinding;

public class HelloFragment extends Fragment {

    private FragmentHelloBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHelloBinding.inflate(inflater, container, false);

        binding.startButton.setOnClickListener(v ->
                Navigation.findNavController(v).navigate(R.id.action_helloFragment_to_notes)
        );

        return binding.getRoot();
    }

}