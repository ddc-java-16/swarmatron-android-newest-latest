package edu.cnm.deepdive.appstarter.service;

import androidx.lifecycle.LiveData;
import com.jsyn.unitgen.SawtoothOscillator;
import com.jsyn.unitgen.SineOscillator;
import com.jsyn.unitgen.SquareOscillator;
import com.jsyn.unitgen.TriangleOscillator;
import com.jsyn.unitgen.UnitOscillator;

import edu.cnm.deepdive.appstarter.model.Oscillator;
import edu.cnm.deepdive.appstarter.model.Swarm;
import edu.cnm.deepdive.appstarter.model.entity.Preset;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class SwarmatronRepository {
Swarm liveSwarm;
@Inject
public SwarmatronRepository() {
  liveSwarm = new Swarm(1);

}


  public void setCenterPitch(float newPitch) {
liveSwarm.setCenterPitch(newPitch);
  }

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
  public void stop() {
  liveSwarm.stop();
  }

  public void loadSwarm(Preset preset) {
  stop();
  changeOscillatorWaveform(preset.getWaveFormSelection());
  spread(preset.getSpreadRibbonPosition());
  start();

  }


  public void changeDronePitch(int newPitch) {
liveSwarm.setDronePitch(newPitch);
  }

  public void changeOscillatorWaveform(float wavformselection) {

  liveSwarm = new Swarm(wavformselection);

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


  public void changeFilterCutoff(float cutoff) {
  liveSwarm.setCutoff(cutoff);
  }

  public void addNoise(float noiseamount) {
  liveSwarm.setPinknoiselevel(noiseamount);
  }
}
