package com.example.mirea_5.ui.boring_window_fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mirea_5.R;
import com.example.mirea_5.databinding.FragmentBoringWindowBinding;
import com.example.mirea_5.services.MyService;
import com.example.mirea_5.ui.hello_fragment.NotificationManager;

public class BoringWindowFragment extends Fragment {

    private FragmentBoringWindowBinding binding;

    private NotificationManager notificationManager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        notificationManager = new NotificationManager(requireContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBoringWindowBinding.inflate(inflater, container, false);

        binding.notificationButton.setOnClickListener(v -> showNotification());

        binding.startServiceButton.setOnClickListener(v -> {
            Intent intent = new Intent(requireActivity(), MyService.class);
            requireActivity().startService(intent);
        });

        binding.redButton.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_boringWindowFragment_to_listViewFragment);
        });

        binding.blueButton.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_boringWindowFragment_to_recyclerViewFragment);
        });

        return binding.getRoot();
    }

    private void showNotification() {
        String title = "Hello";
        String text = "Please, don't forget to write new notes";
        int drawable = R.drawable.ic_launcher_foreground;

        notificationManager.sendNotification(title, text, drawable, requireContext());
    }
}