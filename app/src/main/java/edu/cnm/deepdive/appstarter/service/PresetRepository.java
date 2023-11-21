package edu.cnm.deepdive.appstarter.service;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.appstarter.model.dao.PresetDao;
import edu.cnm.deepdive.appstarter.model.dao.UserDao;
import edu.cnm.deepdive.appstarter.model.entity.Preset;
import edu.cnm.deepdive.appstarter.model.entity.User;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class PresetRepository {


  private final PresetDao presetDao;

  /**
   * Initializes this instance by establishing a logical connection to the underlying database.
   */

  @Inject
  public PresetRepository(PresetDao presetDao) {
    this.presetDao = presetDao;

  }

  //retrieve currently applied preset
  public Single<Preset> getCurrent() {
    return Single.fromSupplier(() -> new Preset()); // FIXME: 10/19/23 Replace with real code.
  }

  public LiveData<Preset> get(long id) {
    return presetDao.select(id);
  }

  public LiveData<List<Preset>> getByUser(long id) {
    return presetDao.selectUserPresets(id);
  }

  public LiveData<List<Preset>> getAll() {
 return  presetDao.selectAllPresets();


  }

  //save and update preset method
  public Single<Long> save(Preset preset) {
    return (
        (preset.getId() == 0)
            ? insert(preset)
            : update(preset)
    )
        .subscribeOn(Schedulers.io());
  }

  //delete a single preset
  public Completable delete(Preset preset) {
    return (
        (preset.getId() == 0)
            ? Completable.complete()
            : presetDao.delete(preset)
                .ignoreElement()
    )
        .subscribeOn(Schedulers.io());
  }

  public Single<Long> insert(Preset preset) {
    preset.setCreated(Instant.now());
    return presetDao
        .insert(preset);

  }

  private Single<Long> update(Preset preset) {
    return presetDao
        .update(preset)
        .map((count) -> preset.getId());
  }

}
