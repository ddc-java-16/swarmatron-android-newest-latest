package edu.cnm.deepdive.appstarter.model;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.jsyn.JSyn;
import com.jsyn.Synthesizer;
import com.jsyn.devices.AndroidAudioForJSyn;
import com.jsyn.devices.AudioDeviceManager;
import com.jsyn.devices.javasound.JavaSoundAudioDevice;
import com.jsyn.unitgen.LineOut;
import com.jsyn.unitgen.LinearRamp;
import com.jsyn.unitgen.SawtoothOscillator;
import com.jsyn.unitgen.SineOscillator;
import com.jsyn.unitgen.UnitOscillator;

public class Swarm {
  private String swarmName;
  private int busFilter;
  private int centerPitch;
  int[] spreadPitches = new int[8];
  private int dronePitch;
  private Oscillator[] swarmoscillators;
  private UnitOscillator droneOscillator;
  AudioDeviceManager manager = new AndroidAudioForJSyn();
  Synthesizer swarmatron;
  private final LineOut mLineOut;
  private final LinearRamp mAmpJack;
  private UnitOscillator oscillator;

  public Swarm() {

    swarmoscillators = new Oscillator[8];
swarmatron = JSyn.createSynthesizer(manager);
    swarmatron.add(mAmpJack = new LinearRamp());
    swarmatron.add(oscillator = new SineOscillator());

    swarmatron.add(mLineOut = new LineOut());

    oscillator.output.connect(0, mLineOut.input, 0);


  }


  public void start() {
swarmatron.start();
mLineOut.start();
  }
  public void drone() {
    droneOscillator.start();
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
