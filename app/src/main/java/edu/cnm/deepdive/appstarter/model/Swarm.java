package edu.cnm.deepdive.appstarter.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.jsyn.Synthesizer;
import java.util.Set;
import java.util.logging.Filter;
import org.jetbrains.annotations.NotNull;

public class Swarm {
  private String swarmName;
  private Filter busFilter;
  private int centerPitch;
  private int[] spreadPitches;

  private int dronePitch;
  private Oscillator[] swarmoscillators = new Oscillator[9]; ///  OR LIST

  Swarm(){
    swarmName = "liveswarm";
    centerPitch = setCenterPitch();
    busFilter =



  }
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



  public void setCenterPitch(int centerPitch) {
    this.centerPitch = centerPitch;
  }

  public int[] setSpread() {
    // take center pitch and base on value of spread knob
    //calculate the appropriate individual pitches for
    //each indiviidual oscillator and return as array for
    //access

  }




}
