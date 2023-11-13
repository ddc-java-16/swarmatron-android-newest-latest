package edu.cnm.deepdive.appstarter.viewmodel;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.room.RoomSQLiteQuery.Binding;
import edu.cnm.deepdive.appstarter.databinding.ActivityMainBinding;
import edu.cnm.deepdive.appstarter.model.Oscillator;
import edu.cnm.deepdive.appstarter.model.Swarm;
import edu.cnm.deepdive.appstarter.model.Swarmatron;
import edu.cnm.deepdive.appstarter.service.SwarmatronRepository;
import org.jetbrains.annotations.NotNull;

public class SwarmatronViewModel extends ViewModel implements DefaultLifecycleObserver {

private SwarmatronRepository repository;
  @Override
  public void onCreate(@NotNull LifecycleOwner owner) {
    DefaultLifecycleObserver.super.onCreate(owner);
    repository = new SwarmatronRepository();


  }
private void setCenterPitch(float newPitch) {
    repository.setCenterPitch(newPitch);
}
  public SwarmatronRepository getRepository() {
    return repository;
  }

  public void setRepository(SwarmatronRepository repository) {
    this.repository = repository;
  }
}
