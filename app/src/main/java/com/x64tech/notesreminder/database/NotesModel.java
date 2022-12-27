package com.x64tech.notesreminder.database;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity(tableName = "Notes_Table")
public class NotesModel implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "body")
    private String body;

    @ColumnInfo(name = "reminder_time")
    private LocalDateTime reminder_time;

    
    public NotesModel() {
    }

    public NotesModel(String title, String body, LocalDateTime reminder_time) {
        this.title = title;
        this.body = body;
        this.reminder_time = reminder_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LocalDateTime getReminder_time() {
        return reminder_time;
    }

    public void setReminder_time(LocalDateTime reminder_time) {
        this.reminder_time = reminder_time;
    }
}
