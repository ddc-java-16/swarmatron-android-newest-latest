---
title: User Interface
description: "Entity-relationship diagram and DDL."
menu: UI
order: 10
wireframe:
  image: img/SwarmatronUI.svg
  
---

{% include ddc-abbreviations.md %}

## Navigation

The User will first see the splash page. Click Begin to start the Swarmatron.
If it's the user's first time using the app, they will be navigated to a page with a breif deccription of
the Instrument's functionality and history. Click "Got " to proceed.

The Swarmatron's main screen displays the instrument's input controllers, two ribbons which can be pressed on with one finger and slid up and down the ribbon to 
modify the respective pitches of the instrument. It also displays 4 main knobs, "Spread" "Filter" "Volume" the first 3 can be dragged to raise or lower the value of the selected parameter.The 4th knob, "waveform, can be dragged to change the waveform of the Oscillators in the swarm.


User can save their current condfiguration by clicking the save preset button. This opens a dialog prompting the user to enter a name for their preset.
After they save a preset, they can click the "Load Preset" button to navigate to the preset selection screen, where the user can scroll horizontally through all their existing presets, and choose one to be loaded 
into their current session.



{% include wireframe.md %}
