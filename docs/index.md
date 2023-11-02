---
title: Overview
description: "Project proposal or summary of in-progress/completed project."
menu: Overview
order: 0
---

{% include ddc-abbreviations.md %}

## Summary

This app is a digital replica of the effect produced by the Swarmatron, a hardware instrument designed by the
Dewan Brothers. It produces a cluster of tones which can be finely seperated from eachother as they
oscillate, recreating the sound of a swarm of bees.

## Intended users & user stories
{: menu="Users" }

Write a bullet list here, including at least 2 different types of intended users. Make it reasonably specific; simply saying "Anyone who likes games" (for example) is not sufficiently specific.

For each type of intended user, include at least 1 _user story_. A user story is usually just 1 simple sentence (no more than 2 sentences), in the voice of the intended user, stating a specific task that the user performs using the app, and the benefit that will be obtained. The simplest user stories take the form 

> As a musician, I want to recreate the effect produces by these rare machines at home, for use in my own music.

Please avoid writing too much for the user story. In particular, if the way the user story is written makes it difficult to see the _who_, _what_, and _why_, then you probably need to re-write it more directly. (On the other hand, a user story should not simply be a re-statement of the intended user description.)

Here is one (silly) example of an intended user, along with a user story. Please note not only the conceptual structure, but the Markdown syntax used.

* People who like to use randomness in their decision making.

    I am interested in this app because it produces a soothing tone, much like a singing bowl or handpan, which helps with meditation and can also
* be a pleasant sound that can be easily manipulated by a non-musician.

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