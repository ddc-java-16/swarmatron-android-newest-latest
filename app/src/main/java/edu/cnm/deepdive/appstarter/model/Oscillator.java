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
import org.jetbrains.annotations.NotNull;

public class Oscillator{

  ///I have an idea to convert this class into anan enum since there will only be 9 instances.
  ////that way each Instance can have a unique int identifier that will
  ///be used to retrieve its pitch from the array of spreadPitches.

UnitOscillator oscillator;
UnitGenerator generator;
private int pitch;
  private int spreadposition;

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
    return "Oscillator " + spreadposition ;
  }





  public UnitOscillator getOscillator() {
    return oscillator;
  }

  public void setOscillator(UnitOscillator oscillator) {
    this.oscillator = oscillator;
  }
}
