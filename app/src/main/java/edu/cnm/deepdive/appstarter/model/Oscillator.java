package edu.cnm.deepdive.appstarter.model;

import androidx.annotation.Nullable;
import com.jsyn.unitgen.SawtoothOscillator;
import com.jsyn.unitgen.SineOscillator;
import com.jsyn.unitgen.SquareOscillator;
import com.jsyn.unitgen.TriangleOscillator;
import com.jsyn.unitgen.UnitOscillator;


public class Oscillator{
private UnitOscillator oscillator;
Oscillator(float waveformselection){
  this.oscillator = chooseWaveform(waveformselection);

}
  public UnitOscillator chooseWaveform(float waveform) {
    int choice = (int) waveform;
    switch (choice) {
      case 1:
        return new SineOscillator();
      case 2:
        return new SawtoothOscillator();
      case 3:
        return new TriangleOscillator();
      case 4:
        return new SquareOscillator();
    }
    return null;
  };
  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  public boolean equals(@Nullable @org.jetbrains.annotations.Nullable Object obj) {
  UnitOscillator targetOscillator = (UnitOscillator) obj;

    if (this.getClass().equals(targetOscillator.getClass())) {
      return true;
    } else {return false;

  }


}
  @Override
  public String toString() {
    return "Oscillator " ;
  }

  public UnitOscillator getOscillator() {
    return oscillator;
  }

  public void setOscillator(UnitOscillator oscillator) {
    this.oscillator = oscillator;
  }
}
