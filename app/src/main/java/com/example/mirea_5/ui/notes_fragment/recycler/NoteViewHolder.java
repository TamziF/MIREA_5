package com.example.mirea_5.ui.notes_fragment.recycler;

import android.os.Bundle;
import android.view.View;

import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mirea_5.R;
import com.example.mirea_5.data.model.Note;
import com.example.mirea_5.databinding.NoteItemBinding;

public class NoteViewHolder extends RecyclerView.ViewHolder {

    private NoteItemBinding binding;

    public NoteViewHolder(NoteItemBinding binding) {
        super(binding.getRoot());

        this.binding = binding;
    }

    public void bindViewHolder(Note item) {
        binding.title.setText(item.title);
        binding.content.setText(item.content);

        binding.card.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putString("title", item.title);
            bundle.putString("content", item.content);
            Navigation.findNavController(v).navigate(R.id.action_notes_to_notesSettings, bundle);
        });
    }
}
