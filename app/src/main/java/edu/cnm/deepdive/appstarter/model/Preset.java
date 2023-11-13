package edu.cnm.deepdive.appstarter.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import edu.cnm.deepdive.appstarter.service.SwarmatronRepository;
import java.util.Date;
import org.jetbrains.annotations.NotNull;

public class Preset {
  private Swarm savedSwarm;
  private String presetName;
  private Date created;

  Preset() {
    savedSwarm = new Swarm();
    //presetName = //// input from user
    created = new Date();
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  public boolean equals(@Nullable @org.jetbrains.annotations.Nullable Object obj) {
    return super.equals(obj);
  }

  @NonNull
  @NotNull
  @Override
  public String toString() {
    return super.toString();
  }
}
