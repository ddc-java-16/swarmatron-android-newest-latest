package edu.cnm.deepdive.appstarter.model;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.jsyn.JSyn;
import com.jsyn.Synthesizer;
import com.jsyn.devices.AndroidAudioForJSyn;
import com.jsyn.devices.AudioDeviceManager;
import com.jsyn.unitgen.FilterLowPass;
import com.jsyn.unitgen.LineOut;
import com.jsyn.unitgen.LinearRamp;
import com.jsyn.unitgen.UnitOscillator;

public class Swarm {

  private String swarmName = "Current Swarm"; // Name of the current swarm specified by default or from user created preset
  private float busFilter; // Value to be passed the LowPass Filter in the JSyn Synthesizer
  private float centerPitch; // Value from which the array of spread pitches will be extrapolated
  private float currentspreadrange;// Store the current spreadrange applied to the Spread() method, to pass to Database
  private int waveformselection; // Between 1 -4, Choice of Sine, Square, Saw, or Triangle Oscillator
  private float[] spreadPitches = {centerPitch, centerPitch, centerPitch, centerPitch, centerPitch,
      centerPitch, centerPitch, centerPitch};// Frequencies to be distributed tot he cluster of Oscillator Objects
  private float dronePitch;// Frequency of the Pedal Tone.
  private Oscillator[] swarmoscillators; // Array to contain the 8 Oscillator instances that comprise the Swarm.
  private Oscillator droneOscillator; // A Single Oscillator Instance to be used as a seperate pedal tone
  private AudioDeviceManager manager = new AndroidAudioForJSyn(); //Android Audio Manager to handle Output from Jsyn
  private Synthesizer swarmatron; // Jsyn Synthesizer Object
  private final FilterLowPass cutoff;
  private final LineOut mLineOut; // JSyn Output for the constituents of the Synthesizer object


  private final LinearRamp mAmpJack; // Not quite sure what this does yet.


  public Swarm() {
    cutoff = new FilterLowPass();
    cutoff.frequency.set(1000);

    swarmoscillators = new Oscillator[]{new Oscillator(), new Oscillator(), new Oscillator(),
        new Oscillator(), new Oscillator(), new Oscillator(), new Oscillator(), new Oscillator()};
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
    swarmatron.add(cutoff);

    swarmatron.add(mLineOut = new LineOut());


    swarmoscillators[0].oscillator.output.connect(0, cutoff.input, 0);
    swarmoscillators[1].oscillator.output.connect(0, cutoff.input, 0);
    swarmoscillators[2].oscillator.output.connect(0, cutoff.input, 0);
    swarmoscillators[3].oscillator.output.connect(0, cutoff.input, 0);
    swarmoscillators[4].oscillator.output.connect(0, cutoff.input, 0);
    swarmoscillators[5].oscillator.output.connect(0, cutoff.input, 0);
    swarmoscillators[6].oscillator.output.connect(0, cutoff.input, 0);
    swarmoscillators[7].oscillator.output.connect(0, cutoff.input, 0);

    swarmoscillators[0].oscillator.amplitude.set(0.01);
    swarmoscillators[1].oscillator.amplitude.set(0.01);
    swarmoscillators[2].oscillator.amplitude.set(0.01);
    swarmoscillators[3].oscillator.amplitude.set(0.01);
    swarmoscillators[4].oscillator.amplitude.set(0.01);
    swarmoscillators[5].oscillator.amplitude.set(0.01);
    swarmoscillators[6].oscillator.amplitude.set(0.01);
    swarmoscillators[7].oscillator.amplitude.set(0.01);
    cutoff.output.connect(0, mLineOut.input, 0);

  }


  public void start() {
    setOscillatorFrequency();
    swarmatron.start();
    mLineOut.start();


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


  public float getBusFilter() {
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

  public int getWaveformselection() {
    return waveformselection;
  }

  public void setWaveformselection(int waveformselection) {
    this.waveformselection = waveformselection;
  }

  public float getCurrentspreadrange() {
    return currentspreadrange;
  }

  public void setCurrentspreadrange(float currentspreadrange) {
    this.currentspreadrange = currentspreadrange;
  }
}
