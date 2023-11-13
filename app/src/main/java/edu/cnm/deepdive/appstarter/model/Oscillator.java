package edu.cnm.deepdive.appstarter.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.jsyn.Synthesizer;
import com.jsyn.unitgen.SawtoothOscillator;
import com.jsyn.unitgen.SineOscillator;
import com.jsyn.unitgen.SquareOscillator;
import com.jsyn.unitgen.TriangleOscillator;
import com.jsyn.unitgen.UnitGenerator;
import com.jsyn.unitgen.UnitOscillator;


public class Oscillator{
public UnitOscillator oscillator;

private float frequency;

Oscillator(){
  oscillator = new SquareOscillator();

}
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
