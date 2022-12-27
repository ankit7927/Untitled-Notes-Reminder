package com.x64tech.notesreminder.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface NotesDAO {
    @Insert
    void insert(NotesModel notesModel);

    @Update
    void update(NotesModel notesModel);

    @Delete
    void delete(NotesModel notesModel);

    @Query("select * from Notes_Table")
    LiveData<List<NotesModel>> getNotes();
}
