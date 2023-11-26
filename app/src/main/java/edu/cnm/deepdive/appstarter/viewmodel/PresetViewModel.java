package edu.cnm.deepdive.appstarter.viewmodel;

import android.content.Context;
import android.util.Log;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import dagger.hilt.android.lifecycle.HiltViewModel;
import dagger.hilt.android.qualifiers.ApplicationContext;
import edu.cnm.deepdive.appstarter.model.entity.Preset;
import edu.cnm.deepdive.appstarter.service.PresetRepository;
import edu.cnm.deepdive.appstarter.service.SwarmatronRepository;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import edu.cnm.deepdive.appstarter.model.Swarm;
import java.util.List;
import javax.inject.Inject;
@HiltViewModel
public class PresetViewModel extends ViewModel implements DefaultLifecycleObserver {

  private final SwarmatronRepository swarmRepository;
  private final PresetRepository repository;
  private final MutableLiveData<Long> presetId;
  private final LiveData<Preset> preset;
  private final MutableLiveData<Throwable> throwable;
  private final CompositeDisposable pending;


  @Inject
  PresetViewModel(@ApplicationContext Context context, PresetRepository repository,
      SwarmatronRepository swarmRepository) {
    this.swarmRepository = swarmRepository;
    this.repository = repository;
    presetId = new MutableLiveData<>();
    preset = Transformations.switchMap(presetId, repository::get);
    throwable = new MutableLiveData<>();
    pending = new CompositeDisposable();

  }

  public Preset save(Preset preset) {
    Swarm currentSwarm = swarmRepository.getLiveSwarm();
    preset.setFilterPosition(currentSwarm.getBusFilter());
    preset.setSpreadRibbonPosition(currentSwarm.getCurrentSpreadrange());
    preset.setWaveFormSelection(currentSwarm.getWaveformSelection());
    preset.setFilterPosition(currentSwarm.getBusFilter());
    preset.setNoiseAmount(currentSwarm.getPinknoiselevel());
    repository.save(preset)
        .subscribe(
            presetId::postValue,
            this::postThrowable,
            pending

        );
    return preset;
  }

  public void load(Preset preset) {
    swarmRepository.loadSwarm(preset);
  }

  public LiveData<List<Preset>> getAllPresets() {
    return repository.getAll();
  }

  public LiveData<Long> getPresetId() {
    return presetId;
  }

  public LiveData<Preset> getPresetByName(String presetname) {
    return repository.getByName(presetname);
  }

  public LiveData<Preset> getPreset() {
    return preset;
  }

  public MutableLiveData<Throwable> getThrowable() {
    return throwable;
  }

  private void postThrowable(Throwable throwable) {
    Log.e(getClass().getSimpleName(), throwable.getMessage(), throwable);
    this.throwable.postValue(throwable);
  }

  public LiveData<Preset> findPreset(long id) {
    return repository.get(id);
  }

  public void fetch(long presetId) {
    this.presetId.postValue(presetId);
  }

  public void delete(Preset preset) {
    repository.delete(preset);

  }
}
