package com.x64tech.notesreminder.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = NotesModel.class, version = 2)
public abstract class NotesDatabase extends RoomDatabase {
    public abstract NotesDAO notesDAO();
    private static volatile NotesDatabase Instance;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(4);

    static NotesDatabase getInstance(final Context context){
        if (Instance == null){
            synchronized (NotesDatabase.class){
                if (Instance == null){
                    Instance = Room.databaseBuilder(context.getApplicationContext(),
                            NotesDatabase.class, "Notes_Database")
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return Instance;
    }
}
