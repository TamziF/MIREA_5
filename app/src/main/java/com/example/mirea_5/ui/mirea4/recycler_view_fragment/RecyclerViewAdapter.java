package com.example.mirea_5.ui.mirea4.recycler_view_fragment;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mirea_5.data.model.ListItem;
import com.example.mirea_5.databinding.RecyclerViewItemBinding;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder> {

    private final List<ListItem> data;

    private Context context;

    public RecyclerViewAdapter(List<ListItem> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerViewItemBinding binding = RecyclerViewItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ItemViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.bindItem(position);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        RecyclerViewItemBinding binding;

        public ItemViewHolder(RecyclerViewItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindItem(int position) {
            ListItem item = data.get(position);
            binding.image.setImageResource(item.drawable);
            binding.text.setText(item.text);

            binding.card.setOnClickListener(v -> {
                Log.i("RECYCLER_VIEW", "Item " + (position + 1) + " clicked");
                Toast.makeText(context, "Item " + (position + 1) + " clicked", Toast.LENGTH_SHORT).show();
            });
        }
    }
}
