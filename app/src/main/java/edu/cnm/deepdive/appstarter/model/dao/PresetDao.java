package edu.cnm.deepdive.appstarter.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.appstarter.model.entity.Preset;
import io.reactivex.rxjava3.core.Single;
import java.util.List;
@Dao
public interface PresetDao {
  @Insert
  Single<Long> insert(Preset preset);

  @Update
  Single<Integer> update(Preset preset);

  @Delete
Single<Integer> delete(Preset preset);

  @Query("SELECT * FROM preset WHERE preset_id = :presetid")
LiveData<Preset> select(Long presetid);

  @Query("SELECT * FROM preset ORDER BY preset_name ASC")
  LiveData<List<Preset>> selectAllPresets();

  @Query("SELECT * FROM preset WHERE user_id = :userid")
LiveData<List<Preset>> selectUserPresets(Long userid);

}
