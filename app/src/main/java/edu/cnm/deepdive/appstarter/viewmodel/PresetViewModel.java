package edu.cnm.deepdive.appstarter.viewmodel;

import android.content.Context;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import dagger.hilt.android.qualifiers.ApplicationContext;
import edu.cnm.deepdive.appstarter.model.entity.Preset;
import edu.cnm.deepdive.appstarter.service.PresetRepository;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import javax.inject.Inject;

public class PresetViewModel extends ViewModel implements DefaultLifecycleObserver {

  private final LiveData<Preset> currentPreset;
  private final MutableLiveData<Long> currentPresetId;
  private final PresetRepository repository;
  private final MutableLiveData<Long> presetId;
  private final LiveData<Preset> preset;

  @Inject
  PresetViewModel(@ApplicationContext Context context, PresetRepository repository) {
    this.repository = repository;
    currentPresetId = new MutableLiveData<>();
    currentPreset = Transformations.switchMap(currentPresetId, repository::get);
    presetId = new MutableLiveData<>();
    preset = Transformations.switchMap(presetId, repository::get);

  }



}
