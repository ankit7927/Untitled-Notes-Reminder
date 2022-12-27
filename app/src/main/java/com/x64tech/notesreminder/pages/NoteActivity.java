package com.x64tech.notesreminder.pages;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Build;
import android.os.Bundle;
import android.widget.EditText;

import com.x64tech.notesreminder.R;
import com.x64tech.notesreminder.database.NotesModel;
import com.x64tech.notesreminder.database.NotesViewModel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class NoteActivity extends AppCompatActivity {

    ActionBar actionBar;
    private NotesViewModel notesViewModel;
    private EditText noteTitle, noteBody;
    private NotesModel notesModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        actionBar = getSupportActionBar();

        initVars();
    }

    private void initVars() {
        noteTitle = findViewById(R.id.noteTitle);
        noteBody = findViewById(R.id.noteBody);

        notesViewModel = new ViewModelProvider(this).get(NotesViewModel.class);

        NotesModel notesModel = (NotesModel) getIntent().getSerializableExtra("notesModel");
        if (notesModel != null){
            this.notesModel = notesModel;
            noteTitle.setText(notesModel.getTitle());
            noteBody.setText(notesModel.getBody());
        }

        if (actionBar != null) {
            if (notesModel != null) actionBar.setTitle("Edit Note");
            else actionBar.setTitle("Create Note");
        }
    }

    private void save(){
        if (!(noteTitle.getText().toString().trim().isEmpty()
        && noteBody.getText().toString().trim().isEmpty())){

            if (notesModel != null){
                notesModel.setTitle(noteTitle.getText().toString().trim());
                notesModel.setBody(noteBody.getText().toString().trim());
                notesViewModel.update(notesModel);
                return;
            }

            NotesModel notesModel = new NotesModel();

            notesModel.setTitle(noteTitle.getText().toString().trim());
            notesModel.setBody(noteBody.getText().toString().trim());
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                notesModel.setCreated_on(LocalDateTime.now()
                        .format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")));
            }

            notesViewModel.insert(notesModel);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        save();
    }
}