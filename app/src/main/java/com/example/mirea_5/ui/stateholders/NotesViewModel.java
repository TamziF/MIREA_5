package com.example.mirea_5.ui.stateholders;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mirea_5.data.repositories.notes_repository.NotesRepository;
import com.example.mirea_5.domain.Callback;
import com.example.mirea_5.data.model.Note;

import java.util.List;

public class NotesViewModel extends ViewModel {

    private final NotesRepository notesRepository;

    private final MutableLiveData<List<Note>> _notes = new MutableLiveData<>();
    public LiveData<List<Note>> notes = _notes;

    private Callback callback = this::getNotes;

    public NotesViewModel(NotesRepository notesRepository) {
        this.notesRepository = notesRepository;

        this.notesRepository.setCallback(callback);

        getNotes();
    }

    private void getNotes() {
        _notes.setValue(notesRepository.getNotes());
    }

    public void updateNote(String id, String title, String content) {
        notesRepository.updateNote(id, title, content);
    }

    @Override
    protected void onCleared() {
        super.onCleared();

        notesRepository.deleteCallback(callback);
    }
}
