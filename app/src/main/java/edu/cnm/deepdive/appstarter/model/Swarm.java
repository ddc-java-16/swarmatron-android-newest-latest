package edu.cnm.deepdive.appstarter.model;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.jsyn.JSyn;
import com.jsyn.Synthesizer;
import com.jsyn.devices.AndroidAudioForJSyn;
import com.jsyn.devices.AudioDeviceManager;
import com.jsyn.unitgen.LineOut;
import com.jsyn.unitgen.LinearRamp;
import com.jsyn.unitgen.UnitOscillator;

public class Swarm {
  private String swarmName = "Current Swarm";
  private int busFilter;
  private float centerPitch;
  private float[] spreadPitches = new float[8];
  private int dronePitch;
  private UnitOscillator droneOscillator;
  AudioDeviceManager manager = new AndroidAudioForJSyn();
  Synthesizer swarmatron;
  private final LineOut mLineOut;
  private final LinearRamp mAmpJack;
  private Oscillator[] swarmoscillators;


  public Swarm() {
    swarmoscillators = new Oscillator[]{new Oscillator(), new Oscillator(), new Oscillator(), new Oscillator(), new Oscillator(), new Oscillator(), new Oscillator(), new Oscillator()};

swarmatron = JSyn.createSynthesizer(manager);
    swarmatron.add(mAmpJack = new LinearRamp());
    swarmatron.add(swarmoscillators[0].oscillator);
    swarmatron.add(swarmoscillators[1].oscillator);
    swarmatron.add(swarmoscillators[2].oscillator);
    swarmatron.add(swarmoscillators[3].oscillator);
    swarmatron.add(swarmoscillators[4].oscillator);
    swarmatron.add(swarmoscillators[5].oscillator);
    swarmatron.add(swarmoscillators[6].oscillator);
    swarmatron.add(swarmoscillators[7].oscillator);

    swarmatron.add(mLineOut = new LineOut());

    swarmoscillators[0].oscillator.output.connect(0, mLineOut.input, 0);
    swarmoscillators[1].oscillator.output.connect(0, mLineOut.input, 0);
    swarmoscillators[2].oscillator.output.connect(0, mLineOut.input, 0);
    swarmoscillators[3].oscillator.output.connect(0, mLineOut.input, 0);
    swarmoscillators[4].oscillator.output.connect(0, mLineOut.input, 0);
    swarmoscillators[5].oscillator.output.connect(0, mLineOut.input, 0);
    swarmoscillators[6].oscillator.output.connect(0, mLineOut.input, 0);
    swarmoscillators[7].oscillator.output.connect(0, mLineOut.input, 0);

  }


  public void start() {
    setOscillatorFrequency();
swarmatron.start();
mLineOut.start();
  }
  public void setOscillatorFrequency() {
    swarmoscillators[0].oscillator.frequency.set(centerPitch);
    swarmoscillators[1].oscillator.frequency.set(centerPitch);
    swarmoscillators[2].oscillator.frequency.set(centerPitch);
    swarmoscillators[3].oscillator.frequency.set(centerPitch);
    swarmoscillators[4].oscillator.frequency.set(centerPitch);
    swarmoscillators[5].oscillator.frequency.set(centerPitch);
    swarmoscillators[6].oscillator.frequency.set(centerPitch);
    swarmoscillators[7].oscillator.frequency.set(centerPitch);


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
    && this.spreadPitches == targetSwarm.spreadPitches
    && (this.hashCode() == targetSwarm.hashCode())) {
      return true;
    } else {
      return false;
    }
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

  public float getCenterPitch() {
    return centerPitch;
  }

  public void setCenterPitch(float centerPitch) {
    this.centerPitch = centerPitch;
  }

  public float[] getSpreadPitches() {
    return spreadPitches;
  }

  public void setSpreadPitches(float[] spreadPitches) {
    this.spreadPitches = spreadPitches;
  }

  public int getDronePitch() {
    return dronePitch;
  }

  public void setDronePitch(int dronePitch) {
    this.dronePitch = dronePitch;
  }


  public void setSwarmoscillator(UnitOscillator choice, int oscillatorselection) {
    swarmoscillators[oscillatorselection].oscillator = choice;
  }

  public void setSwarmoscillators(Oscillator[] swarmoscillators) {
    this.swarmoscillators = swarmoscillators;
  }

  public UnitOscillator getDroneOscillator() {
    return droneOscillator;
  }

  public void setDroneOscillator(UnitOscillator droneOscillator) {
    this.droneOscillator = droneOscillator;
  }
  @NonNull
  @Override
  public String toString() {
    return swarmName;
  }
}
