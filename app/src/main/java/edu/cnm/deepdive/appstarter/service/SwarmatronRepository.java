package edu.cnm.deepdive.appstarter.service;

import com.jsyn.unitgen.SawtoothOscillator;
import com.jsyn.unitgen.SineOscillator;
import com.jsyn.unitgen.SquareOscillator;
import com.jsyn.unitgen.TriangleOscillator;
import com.jsyn.unitgen.UnitOscillator;

import edu.cnm.deepdive.appstarter.model.Swarm;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class SwarmatronRepository {
Swarm liveSwarm;
@Inject
public SwarmatronRepository() {
  liveSwarm = new Swarm();

}


  public void setCenterPitch(float newPitch) {
liveSwarm.setCenterPitch(newPitch);
  }

  /*public void spread(float spreadrange) {
  liveSwarm.setCurrentspreadrange(spreadrange);

    float centerpitch = liveSwarm.getCenterPitch();
    float pitchinterval = spreadrange / 8;
    int relativechange = -4;
    float[] spreadPitches = liveSwarm.getSpreadPitches();;
    for (int i = 0; i < 8; i++) {
      if (relativechange == 0) {
        i--;
      }
      spreadPitches[i] = centerpitch + (relativechange * pitchinterval);
    relativechange++;
    }

  }*/
  public void spread(float spreadrange) {
    liveSwarm.setCurrentspreadrange(spreadrange);
    float[] spreadPitches = liveSwarm.getSpreadPitches();;

    float centerpitch = liveSwarm.getCenterPitch();
    for(int i =0 ; i < 8; i++) {
    float exponent = -spreadrange + (2*i*(spreadrange/7));
    float frequency = centerpitch * (float) Math.pow(2, exponent);
    spreadPitches[i] = frequency;


    }

  }



   public void start() {
  liveSwarm.start();
  }



  public void changeDronePitch(int newPitch) {
liveSwarm.setDronePitch(newPitch);
  }

  public void changeOscillatorWaveform(int wavformselection, int oscillatorSelection) {

UnitOscillator chosen = chooseWaveform(wavformselection);
liveSwarm.setSwarmoscillator(chosen, oscillatorSelection);


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



  public void chooseSwarmDisplayName(String chosenname) {

    liveSwarm.setSwarmName(chosenname);

    }

  public Swarm getLiveSwarm() {
    return liveSwarm;
  }

  public void setLiveSwarm(Swarm liveSwarm) {
    this.liveSwarm = liveSwarm;
  }
}
