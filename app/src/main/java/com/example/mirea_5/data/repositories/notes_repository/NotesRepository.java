package com.example.mirea_5.data.repositories.notes_repository;

import com.example.mirea_5.data.model.Note;
import com.example.mirea_5.domain.Callback;

import java.util.List;

public interface NotesRepository {

    void setCallback(Callback callback);

    void deleteCallback(Callback callback);

    List<Note> getNotes();

    void updateNote(String id, String title, String content);
}
