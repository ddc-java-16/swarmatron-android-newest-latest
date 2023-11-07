package edu.cnm.deepdive.appstarter.model;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.jsyn.Synthesizer;
import com.jsyn.devices.AudioDeviceManager;
import com.jsyn.unitgen.LineOut;
import com.jsyn.unitgen.UnitOscillator;

public class Swarm {
  private String swarmName;
  private int busFilter;
  private int centerPitch;
  int[] spreadPitches = new int[8];
  AudioDeviceManager manager;

  private int dronePitch;
  private Oscillator[] swarmoscillators = new Oscillator[8];
  private UnitOscillator droneOscillator;

  private final LineOut mLineOut = new LineOut(); // stereo output

  public Swarm() {

    // Create the unit generators and add them to the synthesizer.
   /* swarmatron.add(mAmpJack = new LinearRamp());
    swarmatron.add(swarmoscillators[1].oscillator);
    swarmatron.add(swarmoscillators[2].oscillator);
    ETC.
    swarmatron.add(mLineOut = new LineOut()); */

    // Split level setting to both oscillators.
   // mAmpJack.output.connect(mOsc1.amplitude);
  //  mAmpJack.output.connect(mOsc2.amplitude);
  //  mAmpJack.time.set(0.1); // duration of ramp//

    // Connect an oscillator to each channel of the LineOut.
    swarmoscillators[0].oscillator.output.connect(0, mLineOut.input, 0);
    swarmoscillators[1].oscillator.output.connect(0, mLineOut.input, 0);
    swarmoscillators[2].oscillator.output.connect(0, mLineOut.input, 0);
    swarmoscillators[3].oscillator.output.connect(0, mLineOut.input, 0);
    swarmoscillators[4].oscillator.output.connect(0, mLineOut.input, 0);
    swarmoscillators[5].oscillator.output.connect(0, mLineOut.input, 0);
    swarmoscillators[6].oscillator.output.connect(0, mLineOut.input, 0);
    swarmoscillators[7].oscillator.output.connect(0, mLineOut.input, 0);
    droneOscillator.output.connect(0, mLineOut.input, 0);
  }


  public void start() {
    swarmoscillators[0].oscillator.start();
    swarmoscillators[1].oscillator.start();
    swarmoscillators[2].oscillator.start();
    swarmoscillators[3].oscillator.start();
    swarmoscillators[4].oscillator.start();
    swarmoscillators[5].oscillator.start();
    swarmoscillators[6].oscillator.start();
    swarmoscillators[7].oscillator.start();
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
