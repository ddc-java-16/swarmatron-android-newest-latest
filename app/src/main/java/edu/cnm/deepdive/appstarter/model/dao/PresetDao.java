package edu.cnm.deepdive.appstarter.model.dao;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import edu.cnm.deepdive.appstarter.model.entity.Preset;
import edu.cnm.deepdive.appstarter.model.entity.User;
import io.reactivex.rxjava3.core.Single;

public class PresetDao {
  @Insert
  Single<int> insert(Preset preset);

  @Delete


  @Query()


}
