package edu.cnm.deepdive.appstarter.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.jsyn.unitgen.UnitOscillator;
import java.util.logging.Filter;

public class Swarm {
  private String swarmName;
  private int busFilter;
  private int centerPitch;
  int[] spreadPitches = new int[8];

  private int dronePitch;
  private Oscillator[] swarmoscillators = new Oscillator[8];
  private UnitOscillator droneOscillator;


  public void drone() {
    //apply the dronePitch as parameter to a single oscillator, to mimic sitar over pedal tone.
    //apply centerPitch as parameter from which he individual oscillators will derive their pitches
    //invoke each oscillators sound method with their unique field values, but sharing a common pitch,
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  public boolean equals(@Nullable @org.jetbrains.annotations.Nullable Object obj) {
    Swarm targetSwarm = (Swarm) obj;
    if (this.centerPitch == targetSwarm.centerPitch && this.busFilter == targetSwarm.busFilter
    && this.spreadPitches == targetSwarm.spreadPitches && swarmoscillators.equals(targetSwarm.swarmoscillators)
    && (this.hashCode() == targetSwarm.hashCode())) {
      return true;
    } else {
      return false;
    }
  }

  @NonNull
  @Override
  public String toString() {
    return swarmName;
  }




  public int getBusFilter() {
    return busFilter;
  }

  public void setBusFilter(int busFilter) {
    this.busFilter = busFilter;
  }

  public String getSwarmName() {
    return swarmName;
  }

  public void setSwarmName(String swarmName) {
    this.swarmName = swarmName;
  }

  public int getCenterPitch() {
    return centerPitch;
  }

  public void setCenterPitch(int centerPitch) {
    this.centerPitch = centerPitch;
  }

  public int[] getSpreadPitches() {
    return spreadPitches;
  }

  public void setSpreadPitches(int[] spreadPitches) {
    this.spreadPitches = spreadPitches;
  }

  public int getDronePitch() {
    return dronePitch;
  }

  public void setDronePitch(int dronePitch) {
    this.dronePitch = dronePitch;
  }

  public Oscillator[] getSwarmoscillators() {
    return swarmoscillators;
  }

  public void setSwarmoscillators(Oscillator[] swarmoscillators) {
    this.swarmoscillators = swarmoscillators;
  }


  public void setSwarmoscillator(UnitOscillator oscillator, int oscillatorselection) {
    Oscillator chosenoscillator = swarmoscillators[oscillatorselection];
    chosenoscillator.setOscillator(oscillator);

  }
  public UnitOscillator getDroneOscillator() {
    return droneOscillator;
  }

  public void setDroneOscillator(UnitOscillator droneOscillator) {
    this.droneOscillator = droneOscillator;
  }
}
