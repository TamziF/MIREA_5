package com.example.mirea_5.ui.mirea4.list_view_fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.example.mirea_5.App;
import com.example.mirea_5.R;
import com.example.mirea_5.data.model.ListItem;
import com.example.mirea_5.databinding.FragmentListViewBinding;
import com.example.mirea_5.ioc.ApplicationComponent;
import com.example.mirea_5.ui.stateholders.ListViewViewModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListViewFragment extends Fragment {

    private FragmentListViewBinding binding;

    private final ApplicationComponent applicationComponent = App.getApplicationComponent();

    private ListViewViewModel listViewViewModel;

    private ListViewAdapter adapter;

    private List<ListItem> list = Collections.emptyList();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentListViewBinding.inflate(inflater, container, false);

        listViewViewModel = new ViewModelProvider(this, applicationComponent.viewModelFactory).get(ListViewViewModel.class);

        bindListView();
        observeList();

        return binding.getRoot();
    }

    private void bindListView() {
        adapter = new ListViewAdapter(requireContext(), R.layout.list_view_item, list);
        binding.listView.setAdapter(adapter);

        binding.listView.setOnItemClickListener((parent, view, position, id) -> {
            Log.i("LIST_VIEW", "Item " + (position + 1) + " clicked");
            Toast.makeText(requireContext(), "Item " + (position + 1) + " clicked", Toast.LENGTH_SHORT).show();
        });
    }

    private void observeList() {
        listViewViewModel.list.observe(getViewLifecycleOwner(), listItems -> {
            bindList(listItems);
            adapter.notifyDataSetChanged();
        });
    }

    private void bindList(List<ListItem> listItems) {
        list.clear();
        for (int i = 0; i < listItems.size(); i++) {
            list.add(listItems.get(i));
        }
    }
}
