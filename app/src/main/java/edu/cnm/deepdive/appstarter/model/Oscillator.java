package edu.cnm.deepdive.appstarter.model;

import com.jsyn.Synthesizer;

public class Oscillator {


  private int pitch;
  private int masterVolume;

  //   private Waveform waveform;
  // private Filter filter;
  // private Drive drive;

  public void oscillate(Synthesizer synth) {
    //apply fields as parameters to Jsyn Synthesiser instance.
    //perhaps, if possible, use the Waveform field as a way to select which class
    //to instantiate from Jsyn, SquareOscillator, SineOscillator, SawOscillator
    synth.start();

    //until user releases input via UI
    synth.stop();
  }


}