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

The Swarmatron's main screen displays the instrument's input controllers, two ribbons. The top ribbon can be pressed with one finger to raise or lower the pitch of the tone.
The second ribbon controls the spread, or the amount by which the frequencies of the 8 tones in the cluster are spread apart from eachother,
turning what sounds like a single uniform tones into a swarm of slightly different tones.

The instrument has 3 main knobs, "Filter" "Volume", which can each be dragged to raise or lower the value of the selected parameter.


User can save their current configuration by clicking the save preset button. This opens a dialog prompting the user to enter a name for their preset.
After they save a preset, they can click the "Load Preset" button to navigate to the preset selection screen, where the user can scroll horizontally through all their existing presets, and choose one to be loaded 
into their current session, or to be deleted from the database entirely.



{% include wireframe.md %}
