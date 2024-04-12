package com.example.mirea_5.ui.stateholders;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mirea_5.data.model.ListItem;
import com.example.mirea_5.data.repositories.recycler_view_repository.RecyclerViewRepository;

import java.util.List;

public class RecyclerViewViewModel extends ViewModel {

    private final RecyclerViewRepository recyclerViewRepository;

    MutableLiveData<List<ListItem>> _list = new MutableLiveData<>();
    LiveData<List<ListItem>> list = _list;

    public RecyclerViewViewModel(RecyclerViewRepository recyclerViewRepository) {
        this.recyclerViewRepository = recyclerViewRepository;
        getList();
    }

    private void getList() {
        _list.setValue(recyclerViewRepository.getList());
    }

}
