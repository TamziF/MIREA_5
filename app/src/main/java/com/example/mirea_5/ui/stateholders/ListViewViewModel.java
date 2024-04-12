package com.example.mirea_5.ui.stateholders;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mirea_5.data.model.ListItem;
import com.example.mirea_5.data.repositories.list_view_repository.ListViewRepository;

import java.util.List;

public class ListViewViewModel extends ViewModel {

    private final ListViewRepository listViewRepository;

    private final MutableLiveData<List<ListItem>> _list = new MutableLiveData<>();
    public final LiveData<List<ListItem>> list = _list;

    public ListViewViewModel(ListViewRepository listViewRepository) {
        this.listViewRepository = listViewRepository;
        getList();
    }

    private void getList() {
        _list.setValue(listViewRepository.getList());
    }

}
