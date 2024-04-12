package com.example.mirea_5.data.repositories.notes_repository;

import com.example.mirea_5.data.repositories.notes_repository.NotesRepository;
import com.example.mirea_5.domain.Callback;
import com.example.mirea_5.data.datasource.NotesDataSource;
import com.example.mirea_5.data.model.Note;

import java.util.List;
import java.util.Objects;

public class NotesRepositoryImpl implements NotesRepository {

    private final NotesDataSource dataSource;

    private Callback callback;

    public NotesRepositoryImpl(NotesDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    @Override
    public void deleteCallback(Callback callback) {
        this.callback = null;
    }

    @Override
    public List<Note> getNotes() {
        return dataSource.notes;
    }

    @Override
    public void updateNote(String id, String title, String content) {
        for (int i = 0; i < dataSource.notes.size(); i++) {
            if (Objects.equals(dataSource.notes.get(i).id, id)) {
                Note note = dataSource.notes.get(i);
                note.title = title;
                note.content = content;
                break;
            }
        }
        callback.callback();
    }

}
