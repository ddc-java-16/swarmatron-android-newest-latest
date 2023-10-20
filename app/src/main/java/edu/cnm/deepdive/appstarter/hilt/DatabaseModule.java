package edu.cnm.deepdive.appstarter.hilt;

import android.content.Context;
import androidx.room.Room;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
import edu.cnm.deepdive.appstarter.model.dao.PresetDao;
import edu.cnm.deepdive.appstarter.model.dao.UserDao;
import edu.cnm.deepdive.appstarter.service.SwarmatronDatabase;
import javax.inject.Singleton;

/**
 * Uses Dagger {@link Provides @Provides}-annotated methods to satisfy dependencies on concrete
 * implementations of {@link SwarmatronDatabase} and {@link UserDao}.
 */
@InstallIn(SingletonComponent.class)
@Module
public final class DatabaseModule {

  DatabaseModule() {
    // Package-private constructor to avoid automatic HTML documentation generation.
  }

  @Provides
  @Singleton
  SwarmatronDatabase provideLocalDatabase(@ApplicationContext Context context) {
    return Room
        .databaseBuilder(context, SwarmatronDatabase.class, SwarmatronDatabase.NAME)
        .addCallback(new SwarmatronDatabase.Callback())
        .build();
  }

  @Provides
  @Singleton
  UserDao provideUserDao(SwarmatronDatabase database) {
    return database.getUserDao();
  }
@Provides
@Singleton
  PresetDao providePresetDao(SwarmatronDatabase database) {return database.getPresetDao();}


}
