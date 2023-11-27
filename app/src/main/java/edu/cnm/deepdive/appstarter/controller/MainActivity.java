package edu.cnm.deepdive.appstarter.controller;


import android.os.Bundle;
import android.util.Log;
import android.view.View.OnTouchListener;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import com.google.android.material.slider.Slider;
import com.google.android.material.slider.Slider.OnChangeListener;
import com.google.android.material.slider.Slider.OnSliderTouchListener;
import dagger.hilt.android.AndroidEntryPoint;
import edu.cnm.deepdive.appstarter.databinding.ActivityMainBinding;
import edu.cnm.deepdive.appstarter.databinding.FragmentLoadPresetBinding;
import edu.cnm.deepdive.appstarter.viewmodel.PresetViewModel;
import edu.cnm.deepdive.appstarter.viewmodel.SwarmatronViewModel;
import org.jetbrains.annotations.NotNull;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {
  SwarmatronViewModel swarmViewModel;
  PresetViewModel presetViewModel;
  ActivityMainBinding binding;
  FragmentLoadPresetBinding presetbinding;
  EditPresetFragment presetFragment;
  LoadPresetFragment loadPresetFragment;

  boolean active;


  OnSliderTouchListener activateListener = new OnSliderTouchListener() {
    @Override
    public void onStartTrackingTouch(@NonNull Slider slider) {
    }

    @Override
    public void onStopTrackingTouch(@NonNull Slider slider) {
active = false;
swarmViewModel.stop();
    }
  };
  OnChangeListener spreadlistener = new OnChangeListener() {
    @Override
    public void onValueChange(@NonNull @NotNull Slider slider, float value, boolean fromUser) {
      swarmViewModel.setCenterPitch(binding.slider.getValue());
      swarmViewModel.spread(binding.spreadknob.getValue());
      if(active) {
        swarmViewModel.start();
      }



  }};
  OnChangeListener sliderlistener = new OnChangeListener() {
    @Override
    public void onValueChange(@NonNull Slider slider, float value, boolean fromUser) {
      swarmViewModel.setCenterPitch(binding.slider.getValue());
      swarmViewModel.spread(binding.spreadknob.getValue());
      active = true;
        swarmViewModel.start();

    }
  };
  OnChangeListener waveformlistener = new OnChangeListener() {
    @Override
    public void onValueChange(@NonNull @NotNull Slider slider, float value, boolean fromUser) {
     swarmViewModel.stop();
     int waveform = (int) binding.waveformknob.getValue();
      swarmViewModel.changeWaveform(binding.waveformknob.getValue());
      swarmViewModel.setCenterPitch(binding.slider.getValue());
      swarmViewModel.changeFilterCutoff(binding.filterknob.getValue());
      swarmViewModel.spread(binding.spreadknob.getValue());
      if(waveform == 1) {
        binding.waveformpicker.setRotation(-55);
      }
      if(waveform == 2) {
        binding.waveformpicker.setRotation(0);
      }
      if(waveform == 3) {
        binding.waveformpicker.setRotation(90);
      }
      if(waveform == 4) {
        binding.waveformpicker.setRotation(160);
      }





      if(active) {
        swarmViewModel.start();
      }

    }};

OnChangeListener filterListener = new OnChangeListener() {
  @Override
  public void onValueChange(@NonNull Slider slider, float value, boolean fromUser) {

float anglecoefficient = binding.filterknob.getValue() - 200;
    swarmViewModel.changeFilterCutoff(binding.filterknob.getValue());
  binding.fiterpicker.setRotation((float) (anglecoefficient* 0.18) - 45);

    if(active) {
      swarmViewModel.start();
    }

  }
};
  OnChangeListener noiseListener = new OnChangeListener() {
    @Override
    public void onValueChange(@NonNull Slider slider, float value, boolean fromUser) {

      float anglecoefficient = binding.noiseknob.getValue();
      swarmViewModel.addnoise(binding.noiseknob.getValue());
      binding.noisepicker.setRotation((anglecoefficient *900)-45);

      if(active) {
        swarmViewModel.start();
      }

    }};

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    binding = ActivityMainBinding.inflate(getLayoutInflater());
    presetbinding = FragmentLoadPresetBinding.inflate(getLayoutInflater());
    ViewModelProvider viewModelProvider = new ViewModelProvider(this);
    swarmViewModel = viewModelProvider
        .get(SwarmatronViewModel.class);
    presetViewModel = viewModelProvider
        .get(PresetViewModel.class);
    presetViewModel.getPreset()
            .observe(this, preset -> {
              Log.d(getClass().getSimpleName(), preset.toString());
              binding.waveformknob.setValue(preset.getWaveFormSelection());
              binding.spreadknob.setValue(preset.getSpreadKnobPosition());
              binding.filterknob.setValue(preset.getFilterPosition());
              binding.noiseknob.setValue(preset.getNoiseAmount());
            });

    setContentView(binding.getRoot());
    getWindow().getDecorView().setSystemUiVisibility(
        binding.getRoot().SYSTEM_UI_FLAG_HIDE_NAVIGATION|
            binding.getRoot().SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    binding.slider.addOnChangeListener(sliderlistener);
    binding.slider.addOnSliderTouchListener(activateListener);
    binding.spreadknob.addOnChangeListener(spreadlistener);
binding.waveformknob.addOnChangeListener(waveformlistener);
binding.filterknob.addOnChangeListener(filterListener);
binding.noiseknob.addOnChangeListener(noiseListener);

binding.filterknob.setValue(1000);
binding.waveformpicker.setRotation(-60);
binding.fiterpicker.setRotation(160);
    FragmentManager manager = getSupportFragmentManager();
presetFragment = new EditPresetFragment();
loadPresetFragment = new LoadPresetFragment();
    binding.testsave.setOnClickListener((v) -> {
      getWindow().getDecorView().setSystemUiVisibility(
          binding.getRoot().SYSTEM_UI_FLAG_HIDE_NAVIGATION|
              binding.getRoot().SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

      presetFragment.show(manager, "");

     

    });

    binding.loadbutton.setOnClickListener((v) -> loadPresetFragment.show(manager, ""));
  }



}
