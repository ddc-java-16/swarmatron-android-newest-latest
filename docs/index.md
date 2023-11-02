---
title: Overview
description: "Project proposal or summary of in-progress/completed project."
menu: Overview
order: 0
---

## Summary

This app is a digital replica of the effect produced by the Swarmatron, a hardware instrument designed by the
Dewan Brothers. It produces a cluster of tones which can be finely seperated from eachother as they
oscillate, recreating the sound of a swarm of bees.

## Intended users & user stories
{: menu="Users" }

* Musicians
* Folks who like to make musical sounds for fun
> As a musician, I want to recreate the effect produces by these rare machines at home, for use in my own music.


    I am interested in this app because it produces a soothing tone, much like a singing bowl or handpan, which helps with meditation and can also
be a pleasant sound that can be easily manipulated by a non-musician.

## Functionality

The Swarmatron can be played by interacting with its two control ribbons.
The first can be dragged right or left to raise or lower the swarm pitch.
The second can be dragged right or left to choose a pedal tone, which persists after the user has let go of the ribbon.
Combining a steady pedal tone with a melodic line on the Swarm produces a hypnotic texture reminiscent of the sitar or psychedelic music.
The pitches that comprise the swarm tone can be spread apart from eachother using a virtual knob.
The User can also control the waveform of the oscillators that comprise the swarm.

## Persistent data
{: menu="Persistence" }

* User
    * Display name
    * OAuth2.0 identifier
    * Timestamp of first login to the app
  *Preset
    * Preset Name
    * Waveforms of oscillators
    * Spread knob position
    * Filter position
    * Volume position
    * 
## Device/external services
{: menu="Services" }

This will use the device audio output.

## Stretch goals and possible enhancements 
{: menu="Stretch goals" }

*Overdrive on the master bus
*Reverb
*Oscilloscope