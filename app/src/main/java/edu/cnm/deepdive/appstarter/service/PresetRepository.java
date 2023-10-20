package edu.cnm.deepdive.appstarter.service;

import androidx.annotation.NonNull;
import edu.cnm.deepdive.appstarter.model.dao.PresetDao;
import edu.cnm.deepdive.appstarter.model.dao.UserDao;
import edu.cnm.deepdive.appstarter.model.entity.Preset;
import edu.cnm.deepdive.appstarter.model.entity.User;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.time.Instant;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class PresetRepository {
  private final PresetDao presetDao;

  /**
   * Initializes this instance by establishing a logical connection to the underlying database.
   */

  @Inject
  PresetRepository(PresetDao presetDao) {
    this.presetDao = presetDao;

  }
//retrieve currently apllied preset
  public Single<Preset> getCurrent() {
    // return getOrCreate().subscribeOn(Schedulers.io());
    return Single.fromSupplier(() -> new Preset()); // FIXME: 10/19/23 Replace with real code.
  }


  //save and update preset method
  public Single<Preset> save(Preset preset) {
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

  private Single<Preset> insert(Preset preset) {
    preset.setCreated(Instant.now());
    return presetDao
        .insert(preset)
        .map((id) -> {
          preset.setId(id);
          return preset;
        });
  }

  private Single<Preset> update(Preset preset) {
    return presetDao
        .update(preset)
        .map((count) -> preset);
  }

}
