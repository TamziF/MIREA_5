package com.example.mirea_5.data.repositories.recycler_view_repository;

import com.example.mirea_5.data.datasource.RecyclerViewDataSource;
import com.example.mirea_5.data.model.ListItem;

import java.util.List;

public class RecyclerViewRepositoryImpl implements RecyclerViewRepository {

    RecyclerViewDataSource dataSource;

    public RecyclerViewRepositoryImpl(RecyclerViewDataSource recyclerViewDataSource) {
        dataSource = recyclerViewDataSource;
    }

    @Override
    public List<ListItem> getList() {
        return dataSource.list;
    }
}
