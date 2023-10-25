package edu.cnm.deepdive.appstarter.model;

import com.jsyn.Synthesizer;
import com.jsyn.devices.AudioDeviceManager;
import com.jsyn.unitgen.UnitGenerator;
import com.softsynth.shared.time.ScheduledCommand;
import com.softsynth.shared.time.TimeStamp;

class SwarmSynth implements Synthesizer {

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
