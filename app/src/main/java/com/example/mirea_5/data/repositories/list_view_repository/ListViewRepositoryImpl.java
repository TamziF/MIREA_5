package com.example.mirea_5.data.repositories.list_view_repository;

import com.example.mirea_5.data.datasource.ListViewDataSource;
import com.example.mirea_5.data.model.ListItem;

import java.util.List;

public class ListViewRepositoryImpl implements ListViewRepository {

    ListViewDataSource dataSource;

    public ListViewRepositoryImpl(ListViewDataSource listViewDataSource) {
        dataSource = listViewDataSource;
    }

    @Override
    public List<ListItem> getList() {
        return dataSource.list;
    }
}
