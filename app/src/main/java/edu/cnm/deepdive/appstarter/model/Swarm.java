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
  private float waveformselection; // Between 1 -4, Choice of Sine, Square, Saw, or Triangle Oscillator
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


  public Swarm(float waveformselection) {

this.waveformselection = waveformselection;

    swarmoscillators = new Oscillator[]{new Oscillator(waveformselection), new Oscillator(waveformselection), new Oscillator(waveformselection),
        new Oscillator(waveformselection), new Oscillator(waveformselection), new Oscillator(waveformselection), new Oscillator(waveformselection), new Oscillator(waveformselection)};
    droneOscillator = new Oscillator(waveformselection);
    swarmatron = JSyn.createSynthesizer(manager);
    swarmatron.add(mLineOut = new LineOut());
    swarmatron.add(mAmpJack = new LinearRamp());
    swarmatron.add(cutoff = new FilterLowPass());
    cutoff.frequency.set(1000);

    swarmatron.add(swarmoscillators[0].getOscillator());
    swarmatron.add(swarmoscillators[1].getOscillator());
    swarmatron.add(swarmoscillators[2].getOscillator());
    swarmatron.add(swarmoscillators[3].getOscillator());
    swarmatron.add(swarmoscillators[4].getOscillator());
    swarmatron.add(swarmoscillators[5].getOscillator());
    swarmatron.add(swarmoscillators[6].getOscillator());
    swarmatron.add(swarmoscillators[7].getOscillator());

    swarmoscillators[0].getOscillator().amplitude.set(0.01);
    swarmoscillators[1].getOscillator().amplitude.set(0.01);
    swarmoscillators[2].getOscillator().amplitude.set(0.01);
    swarmoscillators[3].getOscillator().amplitude.set(0.01);
    swarmoscillators[4].getOscillator().amplitude.set(0.01);
    swarmoscillators[5].getOscillator().amplitude.set(0.01);
    swarmoscillators[6].getOscillator().amplitude.set(0.01);
    swarmoscillators[7].getOscillator().amplitude.set(0.01);

    swarmoscillators[0].getOscillator().output.connect(0, cutoff.input, 0);
    swarmoscillators[1].getOscillator().output.connect(0, cutoff.input, 0);
    swarmoscillators[2].getOscillator().output.connect(0, cutoff.input, 0);
    swarmoscillators[3].getOscillator().output.connect(0, cutoff.input, 0);
    swarmoscillators[4].getOscillator().output.connect(0, cutoff.input, 0);
    swarmoscillators[5].getOscillator().output.connect(0, cutoff.input, 0);
    swarmoscillators[6].getOscillator().output.connect(0, cutoff.input, 0);
    swarmoscillators[7].getOscillator().output.connect(0, cutoff.input, 0);
    cutoff.output.connect(0, mLineOut.input, 0);




  }



  public void start() {
    setOscillatorFrequency();
    swarmatron.start();
    mLineOut.start();


  }
  public void stop() {
    swarmatron.stop();
    mLineOut.stop();
  }

  public void setOscillatorFrequency() {
    swarmoscillators[0].getOscillator().frequency.set(spreadPitches[0]);
    swarmoscillators[1].getOscillator().frequency.set(spreadPitches[1]);
    swarmoscillators[2].getOscillator().frequency.set(spreadPitches[2]);
    swarmoscillators[3].getOscillator().frequency.set(spreadPitches[3]);
    swarmoscillators[4].getOscillator().frequency.set(spreadPitches[4]);
    swarmoscillators[5].getOscillator().frequency.set(spreadPitches[5]);
    swarmoscillators[6].getOscillator().frequency.set(spreadPitches[6]);
    swarmoscillators[7].getOscillator().frequency.set(spreadPitches[7]);


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

  public void setBusFilter(float busFilter) {
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

  public Oscillator[] getSwarmoscillators() {
    return swarmoscillators;
  }

  public void setSwarmoscillator(UnitOscillator choice, int oscillatorselection) {
    swarmoscillators[oscillatorselection].setOscillator(choice);
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

  public float getWaveformSelection() {
    return waveformselection;
  }

  public void setWaveformselection(float waveformselection) {
    this.waveformselection = waveformselection;
  }

  public float getCurrentSpreadrange() {
    return currentspreadrange;
  }

  public void setCurrentspreadrange(float currentspreadrange) {
    this.currentspreadrange = currentspreadrange;
  }
}
