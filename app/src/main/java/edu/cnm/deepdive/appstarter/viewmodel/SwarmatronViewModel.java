package edu.cnm.deepdive.appstarter.viewmodel;

import android.content.Context;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import dagger.hilt.android.lifecycle.HiltViewModel;
import dagger.hilt.android.qualifiers.ApplicationContext;
import edu.cnm.deepdive.appstarter.model.Swarm;
import edu.cnm.deepdive.appstarter.service.SwarmatronRepository;
import javax.inject.Inject;
import org.jetbrains.annotations.NotNull;
@HiltViewModel
public class SwarmatronViewModel extends ViewModel implements DefaultLifecycleObserver {

  private final SwarmatronRepository repository;
@Inject
  SwarmatronViewModel(@ApplicationContext Context context, SwarmatronRepository repository) {
    this.repository = repository;
  }

public void spread(float spreadrange){
    repository.spread(spreadrange);

}
public void start(){
    repository.start();
}
  public void setCenterPitch(float newPitch) {
    repository.setCenterPitch(newPitch);
  }

}
