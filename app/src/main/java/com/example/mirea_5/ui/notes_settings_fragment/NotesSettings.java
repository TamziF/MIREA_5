package com.example.mirea_5.ui.notes_settings_fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mirea_5.R;
import com.example.mirea_5.databinding.FragmentNotesSettingsBinding;

public class NotesSettings extends Fragment {

    private FragmentNotesSettingsBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNotesSettingsBinding.inflate(inflater, container, false);

        String title = getArguments().getString("title");
        String content = getArguments().getString("content");
        binding.titleEt.setText(title);
        binding.contentEt.setText(content);

        return binding.getRoot();
    }
}