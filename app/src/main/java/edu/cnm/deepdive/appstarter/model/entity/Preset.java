package edu.cnm.deepdive.appstarter.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import java.time.Instant;


@Entity(
    tableName = "preset",
    indices = {
        @Index(value = "preset_name", unique = true)
    }

)
public class Preset {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "preset_id")
    private long id;
    @ColumnInfo(name = "user_id")
    private long userId;
    @ColumnInfo(name = "preset_name")
    private String presetName;
    @ColumnInfo(name = "filter_position")
    private float filterPosition;
    @ColumnInfo(name = "spread_ribbon_position")
    private float spreadRibbonPosition;
    @ColumnInfo(name = "waveform_selection")
    private float waveFormSelection;

    @ColumnInfo(name = "noiseamount")
    private float noiseAmount;
    @NonNull
    private Instant created = Instant.MIN;

    @NonNull
    public Instant getCreated() {
        return created;
    }

    public long getId() {
        return id;
    }

    public void setCreated(@NonNull Instant created) {
        this.created = created;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getPresetName() {
        return presetName;
    }

    public void setPresetName(String presetName) {
        this.presetName = presetName;
    }

    public float getFilterPosition() {
        return filterPosition;
    }

    public void setFilterPosition(float filterPosition) {
        this.filterPosition = filterPosition;
    }

    public float getSpreadKnobPosition() {
        return spreadRibbonPosition;
    }

    public void setSpreadKnobPosition(float spreadKnobPosition) {
        this.spreadRibbonPosition = spreadKnobPosition;
    }

    public float getWaveFormSelection() {
        return waveFormSelection;
    }

    public void setWaveFormSelection(float waveFormSelection) {
        this.waveFormSelection = waveFormSelection;
    }

    public float getSpreadRibbonPosition() {
        return spreadRibbonPosition;
    }

    public void setSpreadRibbonPosition(float spreadRibbonPosition) {
        this.spreadRibbonPosition = spreadRibbonPosition;
    }

    public float getNoiseAmount() {
        return noiseAmount;
    }

    public void setNoiseAmount(float noiseAmount) {
        this.noiseAmount = noiseAmount;
    }

    @NonNull
    @Override
    public String toString() {
        return presetName;
    }

}
