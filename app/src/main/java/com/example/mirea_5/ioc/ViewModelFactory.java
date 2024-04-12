package com.example.mirea_5.ioc;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.mirea_5.data.datasource.ListViewDataSource;
import com.example.mirea_5.data.datasource.RecyclerViewDataSource;
import com.example.mirea_5.data.repositories.list_view_repository.ListViewRepository;
import com.example.mirea_5.data.repositories.notes_repository.NotesRepository;
import com.example.mirea_5.data.repositories.recycler_view_repository.RecyclerViewRepository;
import com.example.mirea_5.ui.stateholders.ListViewViewModel;
import com.example.mirea_5.ui.stateholders.NotesViewModel;
import com.example.mirea_5.ui.stateholders.RecyclerViewViewModel;

public class ViewModelFactory implements ViewModelProvider.Factory {

    NotesRepository notesRepository;
    ListViewRepository listViewRepository;
    RecyclerViewRepository recyclerViewRepository;

    public ViewModelFactory(NotesRepository notesRepository, ListViewRepository listViewRepository, RecyclerViewRepository recyclerViewRepository) {
        this.notesRepository = notesRepository;
        this.listViewRepository = listViewRepository;
        this.recyclerViewRepository = recyclerViewRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass == NotesViewModel.class)
            return (T) new NotesViewModel(notesRepository);
        if (modelClass == ListViewViewModel.class)
            return (T) new ListViewViewModel(listViewRepository);
        if (modelClass == RecyclerViewViewModel.class)
            return (T) new RecyclerViewViewModel(recyclerViewRepository);
        throw new IllegalArgumentException();
    }
}
