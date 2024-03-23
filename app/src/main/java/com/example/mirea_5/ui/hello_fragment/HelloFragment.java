package com.example.mirea_5.ui.hello_fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mirea_5.NotificationManager;
import com.example.mirea_5.R;
import com.example.mirea_5.databinding.FragmentHelloBinding;

public class HelloFragment extends Fragment {

    private FragmentHelloBinding binding;

    private NotificationManager notificationManager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        notificationManager = new NotificationManager(requireContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHelloBinding.inflate(inflater, container, false);

        binding.startButton.setOnClickListener(v ->
                Navigation.findNavController(v).navigate(R.id.action_helloFragment_to_notes)
        );

        binding.notificationButton.setOnClickListener(v -> showNotification());

        return binding.getRoot();
    }

    private void showNotification() {
        String title = "Hello";
        String text = "Please, don't forget to write new notes";
        int drawable = R.drawable.ic_launcher_foreground;

        notificationManager.sendNotification(title, text, drawable, requireContext());
    }

}