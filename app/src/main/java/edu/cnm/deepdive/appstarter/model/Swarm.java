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
  public float[] spreadPitches = {centerPitch, centerPitch,centerPitch,centerPitch, centerPitch,centerPitch,centerPitch,centerPitch };
  private float dronePitch;
  private Oscillator droneOscillator;
  AudioDeviceManager manager = new AndroidAudioForJSyn();
  Synthesizer swarmatron;
  private final LineOut mLineOut;
  private final LineOut mLineOut2;



  private final LinearRamp mAmpJack;
  private Oscillator[] swarmoscillators;


  public Swarm() {

    swarmoscillators = new Oscillator[]{new Oscillator(), new Oscillator(), new Oscillator(), new Oscillator(), new Oscillator(), new Oscillator(), new Oscillator(), new Oscillator()};
droneOscillator = new Oscillator();
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
    swarmatron.add(mLineOut2 = new LineOut());




    swarmoscillators[0].oscillator.output.connect(0, mLineOut.input, 0);
    swarmoscillators[1].oscillator.output.connect(0, mLineOut.input, 0);
    swarmoscillators[2].oscillator.output.connect(0, mLineOut.input, 1);
    swarmoscillators[3].oscillator.output.connect(0, mLineOut.input, 1);
    swarmoscillators[4].oscillator.output.connect(0, mLineOut2.input, 0);
    swarmoscillators[5].oscillator.output.connect(0, mLineOut2.input, 0);
    swarmoscillators[6].oscillator.output.connect(0, mLineOut2.input, 1);
    swarmoscillators[7].oscillator.output.connect(0, mLineOut2.input, 1);

    swarmoscillators[0].oscillator.phase.set(spreadPitches[0]);
    swarmoscillators[0].oscillator.phase.set(spreadPitches[1]);
    swarmoscillators[0].oscillator.phase.set(spreadPitches[2]);
    swarmoscillators[0].oscillator.phase.set(spreadPitches[3]);
    swarmoscillators[0].oscillator.phase.set(spreadPitches[4]);
    swarmoscillators[0].oscillator.phase.set(spreadPitches[5]);
    swarmoscillators[0].oscillator.phase.set(spreadPitches[6]);
    swarmoscillators[0].oscillator.phase.set(spreadPitches[7]);
  }


  public void start() {
    setOscillatorFrequency();
swarmatron.start();
mLineOut.start();
mLineOut2.start();



  }
  public void setOscillatorFrequency() {
    swarmoscillators[0].oscillator.frequency.set(spreadPitches[0]);
    swarmoscillators[1].oscillator.frequency.set(spreadPitches[1]);
    swarmoscillators[2].oscillator.frequency.set(spreadPitches[2]);
    swarmoscillators[3].oscillator.frequency.set(spreadPitches[3]);
    swarmoscillators[4].oscillator.frequency.set(spreadPitches[4]);
    swarmoscillators[5].oscillator.frequency.set(spreadPitches[5]);
    swarmoscillators[6].oscillator.frequency.set(spreadPitches[6]);
    swarmoscillators[7].oscillator.frequency.set(spreadPitches[7]);



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

  public float getDronePitch() {
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

  public Oscillator getDroneOscillator() {
    return droneOscillator;
  }

  public void setDroneOscillator(Oscillator droneOscillator) {
    this.droneOscillator = droneOscillator;
  }
  @NonNull
  @Override
  public String toString() {
    return swarmName;
  }
}
