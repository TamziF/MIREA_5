package com.example.mirea_5.ui.notes_settings_fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mirea_5.App;
import com.example.mirea_5.R;
import com.example.mirea_5.ioc.ApplicationComponent;
import com.example.mirea_5.ui.stateholders.NotesViewModel;

public class NotesSettingsFragment extends Fragment {

    private com.example.mirea_5.databinding.FragmentNotesSettingsBinding binding;

    private final ApplicationComponent applicationComponent = App.getApplicationComponent();

    private NotesViewModel notesViewModel;

    private String id;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = com.example.mirea_5.databinding.FragmentNotesSettingsBinding.inflate(inflater, container, false);

        notesViewModel = new ViewModelProvider(this, applicationComponent.viewModelFactory).get(NotesViewModel.class);

        bindEditTexts();
        bindSaveButton();

        return binding.getRoot();
    }

    private void bindEditTexts() {
        id = getArguments().getString("id");
        String title = getArguments().getString("title");
        String content = getArguments().getString("content");
        binding.titleEt.setText(title);
        binding.contentEt.setText(content);
    }

    private void bindSaveButton() {
        binding.saveButton.setOnClickListener(v -> {
            notesViewModel.updateNote(id, binding.titleEt.getText().toString(), binding.contentEt.getText().toString());
            Navigation.findNavController(v).navigate(R.id.action_notesSettings_to_notes);
        });
    }
}