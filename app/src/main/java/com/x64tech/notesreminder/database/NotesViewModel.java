package com.x64tech.notesreminder.database;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class NotesViewModel extends AndroidViewModel {

    private final NotesRepo notesRepo;

    public NotesViewModel(@NonNull Application application) {
        super(application);
        notesRepo = new NotesRepo(application);
    }

    public LiveData<List<NotesModel>> getAllNotes(){ return notesRepo.getAllNotes(); }

    public void insert(NotesModel notesModel) { notesRepo.insert(notesModel); }

    public void update(NotesModel notesModel) { notesRepo.update(notesModel); }

    public void delete(NotesModel notesModel) { notesRepo.delete(notesModel); }
}
