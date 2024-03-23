package com.example.mirea_5.ui.hello_fragment;

import static android.icu.number.NumberRangeFormatter.with;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mirea_5.NotificationManager;
import com.example.mirea_5.R;
import com.example.mirea_5.databinding.FragmentHelloBinding;

public class HelloFragment extends Fragment {

    private FragmentHelloBinding binding;

    private NotificationManager notificationManager;

    private ActivityResultLauncher<String> requestPermissionLauncher =
            registerForActivityResult(new ActivityResultContracts.RequestPermission(), isGranted -> {
                if (isGranted) {
                    // Permission is granted. Continue the action or workflow in your
                    // app.
                } else {
                    // Explain to the user that the feature is unavailable because the
                    // feature requires a permission that the user has denied. At the
                    // same time, respect the user's decision. Don't link to system
                    // settings in an effort to convince the user to change their
                    // decision.
                }
            });

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

        binding.notificationButton.setOnClickListener(v -> {
            showNotification();
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