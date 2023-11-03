package edu.cnm.deepdive.appstarter.service;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.jsyn.unitgen.SawtoothOscillator;
import com.jsyn.unitgen.SineOscillator;
import com.jsyn.unitgen.SquareOscillator;
import com.jsyn.unitgen.TriangleOscillator;
import com.jsyn.unitgen.UnitOscillator;
import edu.cnm.deepdive.appstarter.model.Oscillator;
import edu.cnm.deepdive.appstarter.model.Swarm;

public class SwarmatronRepository {
  private final MutableLiveData<Swarm> liveDataSwarm;
  private MutableLiveData<Integer> livebusfilter;

SwarmatronRepository() {
  liveDataSwarm = new MutableLiveData<>();
}
  public void create() {
    liveDataSwarm.postValue(new Swarm());
  }


  public void setCenterPitch(int newPitch) {
Swarm swarm = liveDataSwarm.getValue();
swarm.setCenterPitch(newPitch);
// mutates the fefault center pitch value from null to
    //a value retrieved from a MutableLiveData?

    liveDataSwarm.postValue(swarm);
  }

  public void setSpread(int spreadrange) {
    Swarm swarm = liveDataSwarm.getValue();
    int centerpitch = liveDataSwarm.getValue().getCenterPitch();
    int pitchinterval = spreadrange/8;
   int[] pitchspectrum = new int[8];
   int relativechange = -4;
   for (int position: pitchspectrum) {
     if(relativechange != 0) {
       position = centerpitch + pitchinterval * relativechange;
     } else {

     }


   }
     swarm.setSpreadPitches(pitchspectrum);
     liveDataSwarm.postValue(swarm);
  }



  public void changeDronePitch(int newPitch) {

    liveDataSwarm.getValue().setDronePitch(newPitch);
  }

  public void changeOscillatorWaveform(int wavformselection, int oscillatorSelection) {
  Swarm swarm = liveDataSwarm.getValue();
UnitOscillator chosen = chooseWaveform(wavformselection);
swarm.setSwarmoscillator(chosen, oscillatorSelection);


  }

  public UnitOscillator chooseWaveform(int waveform) {
UnitOscillator result;
    switch (waveform) {
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
  }

  public void turnFilterKnob(int busfilter) {
  Swarm swarm = liveDataSwarm.getValue();
    swarm.setBusFilter(busfilter);
    liveDataSwarm.postValue(swarm);

  }

  public void chooseSwarmDisplayName(String chosenname) {
    Swarm swarm = liveDataSwarm.getValue();
    swarm.setSwarmName(chosenname);
    liveDataSwarm.postValue(swarm);
    }


}
