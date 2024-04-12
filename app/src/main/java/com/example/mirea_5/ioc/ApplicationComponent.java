package com.example.mirea_5.ioc;

import com.example.mirea_5.data.datasource.ListViewDataSource;
import com.example.mirea_5.data.datasource.NotesDataSource;
import com.example.mirea_5.data.datasource.RecyclerViewDataSource;
import com.example.mirea_5.data.repositories.list_view_repository.ListViewRepository;
import com.example.mirea_5.data.repositories.list_view_repository.ListViewRepositoryImpl;
import com.example.mirea_5.data.repositories.notes_repository.NotesRepository;
import com.example.mirea_5.data.repositories.notes_repository.NotesRepositoryImpl;
import com.example.mirea_5.data.repositories.recycler_view_repository.RecyclerViewRepository;
import com.example.mirea_5.data.repositories.recycler_view_repository.RecyclerViewRepositoryImpl;

public class ApplicationComponent {

    private final NotesDataSource notesDataSource = new NotesDataSource();
    private final ListViewDataSource listViewDataSource = new ListViewDataSource();
    private final RecyclerViewDataSource recyclerViewDataSource = new RecyclerViewDataSource();
    private final NotesRepository notesRepository = new NotesRepositoryImpl(notesDataSource);
    private final ListViewRepository listViewRepository = new ListViewRepositoryImpl(listViewDataSource);
    private final RecyclerViewRepository recyclerViewRepository = new RecyclerViewRepositoryImpl(recyclerViewDataSource);

    public ViewModelFactory viewModelFactory = new ViewModelFactory(notesRepository, listViewRepository, recyclerViewRepository);

}
