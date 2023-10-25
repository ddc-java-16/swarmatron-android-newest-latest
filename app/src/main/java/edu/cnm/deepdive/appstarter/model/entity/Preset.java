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
    },
    foreignKeys = {

        @ForeignKey(entity = User.class, parentColumns = "user_id", childColumns = "user_id", onDelete = ForeignKey.CASCADE)
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
    private int filterPosition;
    @ColumnInfo(name = "spread_knob_position")
    private int spreadKnobPosition;

    @ColumnInfo(name = "waveform_selection")
    private int waveFormSelection;

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

    public int getFilterPosition() {
        return filterPosition;
    }

    public void setFilterPosition(int filterPosition) {
        this.filterPosition = filterPosition;
    }

    public int getSpreadKnobPosition() {
        return spreadKnobPosition;
    }

    public void setSpreadKnobPosition(int spreadKnobPosition) {
        this.spreadKnobPosition = spreadKnobPosition;
    }

    public int getWaveFormSelection() {
        return waveFormSelection;
    }

    public void setWaveFormSelection(int waveFormSelection) {
        this.waveFormSelection = waveFormSelection;
    }
}
