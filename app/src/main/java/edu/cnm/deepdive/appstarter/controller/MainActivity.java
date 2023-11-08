package edu.cnm.deepdive.appstarter.controller;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import dagger.hilt.android.AndroidEntryPoint;
import edu.cnm.deepdive.appstarter.R;
import edu.cnm.deepdive.appstarter.model.Oscillator;
import edu.cnm.deepdive.appstarter.model.Swarm;
import edu.cnm.deepdive.appstarter.model.Swarmatron;
import edu.cnm.deepdive.appstarter.viewmodel.SwarmatronViewModel;


public class MainActivity extends AppCompatActivity {

Swarm swarm;
  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.mainactivity);
   swarm = new Swarm();
   swarm.start();
  }
}
