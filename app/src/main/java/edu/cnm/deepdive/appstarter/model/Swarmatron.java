package edu.cnm.deepdive.appstarter.model;

import com.jsyn.*;
import com.jsyn.scope.AudioScope.ViewMode;

public class Swarmatron {

  public static Swarm liveSwarm;

  public static Swarm getLiveSwarm() {
    return liveSwarm;
  }

  public void setLiveSwarm(Swarm liveSwarm) {
    this.liveSwarm = liveSwarm;
  }


}
