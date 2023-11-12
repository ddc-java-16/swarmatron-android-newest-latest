package edu.cnm.deepdive.appstarter.controller;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.google.android.material.slider.Slider;
import com.google.android.material.slider.Slider.OnChangeListener;
import com.google.android.material.slider.Slider.OnSliderTouchListener;
import edu.cnm.deepdive.appstarter.R;
import edu.cnm.deepdive.appstarter.model.Swarm;
import edu.cnm.deepdive.appstarter.service.SwarmatronRepository;
import edu.cnm.deepdive.appstarter.viewmodel.SwarmatronViewModel;
import org.jetbrains.annotations.NotNull;


public class MainActivity extends AppCompatActivity {
  OnChangeListener sliderlistener  = new OnChangeListener() {
    @Override
    public void onValueChange(@NonNull @NotNull Slider slider, float value, boolean fromUser) {
      swarm.setCenterPitch(slider.getValue());
      swarm.start();
    }};
  Swarm swarm;
  Slider slider;
  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
   slider = findViewById(R.id.slider) ;


    slider.addOnChangeListener(sliderlistener);
   swarm = new Swarm();

  }



}
