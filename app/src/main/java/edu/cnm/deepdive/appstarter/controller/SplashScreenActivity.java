package edu.cnm.deepdive.appstarter.controller;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import edu.cnm.deepdive.appstarter.databinding.FragmentSplashScreenBinding;

public class SplashScreenActivity extends AppCompatActivity {

  FragmentSplashScreenBinding binding;

  @Override
  protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = FragmentSplashScreenBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());
    getWindow().getDecorView().setSystemUiVisibility(
        binding.getRoot().SYSTEM_UI_FLAG_HIDE_NAVIGATION |
            binding.getRoot().SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    binding.begin.setBackgroundColor(Color.TRANSPARENT);

    binding.begin.setOnClickListener((v) -> {
      Intent intent = new Intent(this, MainActivity.class);
      startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(this).toBundle());
    });
    ;
  }
}
