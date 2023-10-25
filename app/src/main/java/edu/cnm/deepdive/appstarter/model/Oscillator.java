package edu.cnm.deepdive.appstarter.model;

import com.jsyn.Synthesizer;
import com.jsyn.devices.AudioDeviceManager;
import com.jsyn.unitgen.UnitGenerator;
import com.softsynth.shared.time.ScheduledCommand;
import com.softsynth.shared.time.TimeStamp;
import java.util.Set;

public class Oscillator {
  Synthesizer synth = new Synthesizer() {
    @Override
    public void start() {

    }

    @Override
    public void start(int i) {

    }

    @Override
    public void start(int i, int i1, int i2, int i3, int i4) {

    }

    @Override
    public String getVersion() {
      return null;
    }

    @Override
    public int getVersionCode() {
      return 0;
    }

    @Override
    public void stop() {

    }

    @Override
    public AudioDeviceManager getAudioDeviceManager() {
      return null;
    }

    @Override
    public int getFrameRate() {
      return 0;
    }

    @Override
    public void add(UnitGenerator unitGenerator) {

    }

    @Override
    public void remove(UnitGenerator unitGenerator) {

    }

    @Override
    public double getCurrentTime() {
      return 0;
    }

    @Override
    public void startUnit(UnitGenerator unitGenerator, double v) {

    }

    @Override
    public void startUnit(UnitGenerator unitGenerator, TimeStamp timeStamp) {

    }

    @Override
    public void startUnit(UnitGenerator unitGenerator) {

    }

    @Override
    public void stopUnit(UnitGenerator unitGenerator, double v) {

    }

    @Override
    public void stopUnit(UnitGenerator unitGenerator, TimeStamp timeStamp) {

    }

    @Override
    public void stopUnit(UnitGenerator unitGenerator) {

    }

    @Override
    public void sleepUntil(double v) throws InterruptedException {

    }

    @Override
    public void sleepFor(double v) throws InterruptedException {

    }

    @Override
    public void setRealTime(boolean b) {

    }

    @Override
    public boolean isRealTime() {
      return false;
    }

    @Override
    public TimeStamp createTimeStamp() {
      return null;
    }

    @Override
    public double getUsage() {
      return 0;
    }

    @Override
    public double getFramePeriod() {
      return 0;
    }

    @Override
    public long getFrameCount() {
      return 0;
    }

    @Override
    public void scheduleCommand(TimeStamp timeStamp, ScheduledCommand scheduledCommand) {

    }

    @Override
    public void scheduleCommand(double v, ScheduledCommand scheduledCommand) {

    }

    @Override
    public void queueCommand(ScheduledCommand scheduledCommand) {

    }

    @Override
    public void clearCommandQueue() {

    }

    @Override
    public boolean isRunning() {
      return false;
    }

    @Override
    public void addAudioTask(Runnable runnable) {

    }

    @Override
    public void removeAudioTask(Runnable runnable) {

    }
  }
 private int pitch;
  private int masterVolume;

   //   private Waveform waveform;
     // private Filter filter;
     // private Drive drive;

public void Oscillate() {
  //apply fields as parameters to Jsyn Synthesiser instance.
  //perhaps, if possible, use the Waveform field as a way to select which class
  //to instantiate from Jsyn, SquareOscillator, SineOscillator, SawOscillator
  synth.start();


  //until user releases input via UI
  synth.stop();
}

  */

}