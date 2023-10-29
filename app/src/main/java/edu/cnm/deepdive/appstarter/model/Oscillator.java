package edu.cnm.deepdive.appstarter.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.jsyn.Synthesizer;
import com.jsyn.unitgen.SawtoothOscillator;
import com.jsyn.unitgen.SineOscillator;
import com.jsyn.unitgen.SquareOscillator;
import com.jsyn.unitgen.TriangleOscillator;
import com.jsyn.unitgen.UnitOscillator;
import org.jetbrains.annotations.NotNull;

public class Oscillator {

UnitOscillator oscillator;

  private int pitch;

Oscillator(int waveform) {
  switch (waveform) {
    case 1:
      oscillator = new SineOscillator();
    case 2:
      oscillator = new SawtoothOscillator();
    case 3:
      oscillator = new TriangleOscillator();
    case 4:
      oscillator = new SquareOscillator();


  }
  pitch = Swarm.getCenterPitch();
}





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

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  public boolean equals(@Nullable @org.jetbrains.annotations.Nullable Object obj) {
    return super.equals(obj);
  }

  @NonNull

  @Override
  public String toString() {
    return super.toString();
  }
}
}