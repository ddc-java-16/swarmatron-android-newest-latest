package edu.cnm.deepdive.appstarter.viewmodel;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import edu.cnm.deepdive.appstarter.model.Oscillator;
import edu.cnm.deepdive.appstarter.model.Swarm;
import edu.cnm.deepdive.appstarter.model.Swarmatron;
import org.jetbrains.annotations.NotNull;

public class SwarmatronViewModel extends ViewModel implements DefaultLifecycleObserver {


  @Override
  public void onCreate(@NotNull LifecycleOwner owner) {
    DefaultLifecycleObserver.super.onCreate(owner);
    Swarm swarm = new Swarm();
    swarm.start();

  }
}
