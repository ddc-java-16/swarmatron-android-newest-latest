package edu.cnm.deepdive.appstarter.controller;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.slider.Slider;
import com.google.android.material.slider.Slider.OnChangeListener;
import edu.cnm.deepdive.appstarter.R;
import edu.cnm.deepdive.appstarter.model.Swarm;
import edu.cnm.deepdive.appstarter.service.SwarmatronRepository;
import org.jetbrains.annotations.NotNull;


public class MainActivity extends AppCompatActivity {
  SwarmatronRepository repository;
  OnChangeListener spreadlistener = new OnChangeListener() {
    @Override
    public void onValueChange(@NonNull @NotNull Slider slider, float value, boolean fromUser) {
      repository.spread(spreadslider.getValue());
      repository.start();
    }
  };
  OnChangeListener sliderlistener  = new OnChangeListener() {
    @Override
    public void onValueChange(@NonNull @NotNull Slider slider, float value, boolean fromUser) {
      repository.setCenterPitch(slider.getValue());
      repository.spread(spreadslider.getValue());
      repository.start();
    }};
  Slider swarmslider;
  Slider spreadslider;
  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
repository = new SwarmatronRepository();
    spreadslider = findViewById(R.id.spreadknob);
   swarmslider = findViewById(R.id.slider) ;
    swarmslider.addOnChangeListener(sliderlistener);
    spreadslider.addOnChangeListener(spreadlistener);



  }



}
