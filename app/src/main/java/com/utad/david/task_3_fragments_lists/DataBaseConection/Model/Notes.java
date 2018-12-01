package com.utad.david.task_3_fragments_lists.DataBaseConection.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "notes")
public class Notes{
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "idNotes")
    private int idNotes;
    @ColumnInfo(name = "date")
    private String date;
    @ColumnInfo(name = "classes")
    private String classes;
    @ColumnInfo(name = "works")
    private String works;
    @ColumnInfo(name = "notes")
    private String notes;

    public Notes(String date, String classes, String works, String notes) {
        this.date = date;
        this.classes = classes;
        this.works = works;
        this.notes = notes;
    }

    public int getIdNotes() {
        return idNotes;
    }

    public void setIdNotes(@NonNull int idNotes) {
        this.idNotes = idNotes;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getWorks() {
        return works;
    }

    public void setWorks(String works) {
        this.works = works;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
