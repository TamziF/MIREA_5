package com.example.mirea_5.ui.mirea4.list_view_fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.mirea_5.data.model.ListItem;
import com.example.mirea_5.databinding.ListViewItemBinding;

import java.util.List;

public class ListViewAdapter extends ArrayAdapter<ListItem> {
    private LayoutInflater inflater;
    private List<ListItem> items;

    public ListViewAdapter(Context context, int resource,
                           List<ListItem> items) {
        super(context, resource, items);
        this.items = items;
        this.inflater = LayoutInflater.from(context);
    }

    public View getView(int position, View convertView,
                        ViewGroup parent) {
        ListViewItemBinding binding;

        if (convertView == null) {
            binding = ListViewItemBinding.inflate(inflater, parent, false);
            convertView = binding.getRoot();
            convertView.setTag(binding);
        } else {
            binding = (ListViewItemBinding) convertView.getTag();
        }

        ListItem currentItem = items.get(position);

        binding.image.setImageResource(currentItem.drawable);
        binding.text.setText(currentItem.text);

        return convertView;
    }
}