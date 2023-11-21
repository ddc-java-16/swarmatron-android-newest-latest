package edu.cnm.deepdive.appstarter.controller;


import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import com.google.android.material.slider.Slider;
import com.google.android.material.slider.Slider.OnChangeListener;
import dagger.hilt.android.AndroidEntryPoint;
import edu.cnm.deepdive.appstarter.databinding.ActivityMainBinding;
import edu.cnm.deepdive.appstarter.model.entity.Preset;
import edu.cnm.deepdive.appstarter.viewmodel.PresetViewModel;
import edu.cnm.deepdive.appstarter.viewmodel.SwarmatronViewModel;
import org.jetbrains.annotations.NotNull;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {
  SwarmatronViewModel swarmViewModel;
  ActivityMainBinding binding;
  EditPresetFragment presetFragment;
  LoadPresetFragment loadPresetFragment;

  OnChangeListener spreadlistener = new OnChangeListener() {
    @Override
    public void onValueChange(@NonNull @NotNull Slider slider, float value, boolean fromUser) {
      swarmViewModel.setCenterPitch(binding.slider.getValue());
      swarmViewModel.spread(binding.spreadknob.getValue());

      swarmViewModel.start();
    }
  };
  OnChangeListener sliderlistener = new OnChangeListener() {
    @Override
    public void onValueChange(@NonNull Slider slider, float value, boolean fromUser) {
      swarmViewModel.setCenterPitch(binding.slider.getValue());
      swarmViewModel.spread(binding.spreadknob.getValue());
      swarmViewModel.start();
    }
  };
  OnChangeListener waveformlistener = new OnChangeListener() {
    @Override
    public void onValueChange(@NonNull @NotNull Slider slider, float value, boolean fromUser) {
     swarmViewModel.stop();
      swarmViewModel.changeWaveform(binding.waveformknob.getValue());
      swarmViewModel.setCenterPitch(binding.slider.getValue());
      swarmViewModel.spread(binding.spreadknob.getValue());
      swarmViewModel.start();
    }
  };

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    binding = ActivityMainBinding.inflate(getLayoutInflater());
    ViewModelProvider viewModelProvider = new ViewModelProvider(this);
    swarmViewModel = viewModelProvider
        .get(SwarmatronViewModel.class);
    setContentView(binding.getRoot());
    getWindow().getDecorView().setSystemUiVisibility(
        binding.getRoot().SYSTEM_UI_FLAG_HIDE_NAVIGATION|
            binding.getRoot().SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    binding.slider.addOnChangeListener(sliderlistener);
    binding.spreadknob.addOnChangeListener(spreadlistener);
binding.waveformknob.addOnChangeListener(waveformlistener);
    FragmentManager manager = getSupportFragmentManager();
presetFragment = new EditPresetFragment();
loadPresetFragment = new LoadPresetFragment();
    binding.testsave.setOnClickListener((v) -> {
      getWindow().getDecorView().setSystemUiVisibility(
          binding.getRoot().SYSTEM_UI_FLAG_HIDE_NAVIGATION|
              binding.getRoot().SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

      presetFragment.show(manager, "");
    });
    binding.loadbutton.setOnClickListener((v) -> {

      loadPresetFragment.show(manager, "");
    });
  }


}
