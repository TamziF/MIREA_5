package com.example.mirea_5.ui.notes_fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mirea_5.databinding.FragmentNotesBinding;
import com.example.mirea_5.ioc.ApplicationComponent;
import com.example.mirea_5.ui.notes_fragment.recycler.DiffUtilCallBack;
import com.example.mirea_5.ui.notes_fragment.recycler.NotesAdapter;
import com.example.mirea_5.App;
import com.example.mirea_5.ui.stateholders.NotesViewModel;


public class NotesFragment extends Fragment {

    private FragmentNotesBinding binding;

    private final ApplicationComponent applicationComponent = App.getApplicationComponent();

    private NotesViewModel notesViewModel;
    private final NotesAdapter notesAdapter = new NotesAdapter(new DiffUtilCallBack());

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNotesBinding.inflate(inflater, container, false);

        notesViewModel = new ViewModelProvider(this, applicationComponent.viewModelFactory).get(NotesViewModel.class);

        observeList();
        bindRecycler();

        return binding.getRoot();
    }

    private void observeList() {
        notesViewModel.notes.observe(getViewLifecycleOwner(), notesAdapter::submitList);
    }

    private void bindRecycler() {
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.recyclerView.setAdapter(notesAdapter);
    }
}