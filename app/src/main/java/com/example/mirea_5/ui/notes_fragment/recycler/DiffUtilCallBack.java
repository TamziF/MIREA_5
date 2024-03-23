package com.example.mirea_5.ui.notes_fragment.recycler;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.example.mirea_5.data.model.Note;

import java.util.Objects;

public class DiffUtilCallBack extends DiffUtil.ItemCallback<Note> {
    @Override
    public boolean areItemsTheSame(@NonNull Note oldItem, @NonNull Note newItem) {
        return Objects.equals(oldItem.id, newItem.id);
    }

    @Override
    public boolean areContentsTheSame(@NonNull Note oldItem, @NonNull Note newItem) {
        return Objects.equals(oldItem.title, newItem.title) && Objects.equals(oldItem.content, newItem.content);
    }
}
