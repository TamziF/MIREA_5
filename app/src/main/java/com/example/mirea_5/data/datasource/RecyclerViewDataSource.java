package com.example.mirea_5.data.datasource;

import com.example.mirea_5.R;
import com.example.mirea_5.data.model.ListItem;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewDataSource {

    public List<ListItem> list = new ArrayList<>();

    public RecyclerViewDataSource() {
        for (int i = 1; i < 201; i++) {
            ListItem item = new ListItem();
            item.drawable = R.drawable.wide;
            item.text = String.valueOf(i);
            list.add(item);
        }
    }

}
