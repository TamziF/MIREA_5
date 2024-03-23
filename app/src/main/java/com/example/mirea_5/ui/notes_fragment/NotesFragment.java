package com.example.mirea_5.ui.notes_fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mirea_5.data.model.Note;
import com.example.mirea_5.databinding.FragmentNotesBinding;
import com.example.mirea_5.ui.notes_fragment.recycler.DiffUtilCallBack;
import com.example.mirea_5.ui.notes_fragment.recycler.NotesAdapter;

import java.util.ArrayList;
import java.util.List;

public class NotesFragment extends Fragment {

    private FragmentNotesBinding binding;

    private List<Note> notes = new ArrayList<Note>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createExampleNotesList();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNotesBinding.inflate(inflater, container, false);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        NotesAdapter adapter = new NotesAdapter(new DiffUtilCallBack());
        binding.recyclerView.setAdapter(adapter);
        adapter.submitList(notes);

        return binding.getRoot();
    }

    private void createExampleNotesList() {
        Note note1 = new Note(
                "Sport",
                "Now i know, that everyday morning work out won't become a problem, but will help in my hard gym work outs"
        );

        Note note2 = new Note(
                "Clean space",
                "Little description of your things. For example, i shall clean the space around me and in my things, to become productive and rich"
        );

        Note note3 = new Note(
                "Clean space",
                "Little description of your things. For example, i shall clean the space around me and in my things, to become productive and rich"
        );

        Note note4 = new Note(
                "Clean space",
                "Little description of your things. For example, i shall clean the space around me and in my things, to become productive and rich"
        );

        Note note5 = new Note(
                "Clean space",
                "Little description of your things. For example, i shall clean the space around me and in my things, to become productive and rich"
        );

        notes.add(note1);
        notes.add(note2);
        notes.add(note3);
        notes.add(note4);
        notes.add(note5);
    }
}