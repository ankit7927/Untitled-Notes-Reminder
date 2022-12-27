package com.x64tech.notesreminder.database;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class NotesRepo {
    private final NotesDAO notesDao;

    public NotesRepo(Application application){
        NotesDatabase database = NotesDatabase.getInstance(application);
        notesDao = database.notesDAO();
    }

    LiveData<List<NotesModel>> getAllNotes(){
        return notesDao.getNotes();
    }

    void insert(NotesModel notesModel){
        NotesDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                notesDao.insert(notesModel);
            }
        });
    }

    public void update(NotesModel notesModel){
        NotesDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                notesDao.update(notesModel);
            }
        });
    }

    void delete(NotesModel notesModel){
        NotesDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                notesDao.delete(notesModel);
            }
        });
    }
}
