package edu.cnm.deepdive.appstarter.model;

import android.media.MediaPlayer;
import com.jsyn.*;
import com.jsyn.scope.AudioScope.ViewMode;
import com.jsyn.unitgen.LineOut;
import com.jsyn.unitgen.LinearRamp;
import com.jsyn.unitgen.SineOscillator;
import com.jsyn.unitgen.UnitGenerator;

public class Swarmatron {
  public static Swarm liveSwarm = new Swarm();
  public static MediaPlayer output;

  public static Swarm getLiveSwarm() {
    return liveSwarm;
  }

  public void setLiveSwarm(Swarm liveSwarm) {
    this.liveSwarm = liveSwarm;
  }





  }

