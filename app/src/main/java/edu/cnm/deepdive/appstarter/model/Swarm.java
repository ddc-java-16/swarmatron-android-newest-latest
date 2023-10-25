package edu.cnm.deepdive.appstarter.model;

import com.jsyn.Synthesizer;
import java.util.Set;
import java.util.logging.Filter;

public class Swarm {
  private Set<Synthesizer> oscillators;
  private Filter busFilter;
  private int centerPitch;

  private int dronePitch;

  // OR

  private Oscillator[] swarm = new Oscillator[9]; ///  array of oscillator instances



  public void drone() {
    //apply the dronePitch as parameter to a single oscillator, to mimic sitar over pedal tone.
    //apply centerPitch as parameter from which he individual oscillators will derive their pitches
    //invoke each oscillators sound method with their unique field values, but sharing a common bitch,
  }
}
