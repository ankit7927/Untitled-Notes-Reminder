package com.x64tech.notesreminder.pages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import com.x64tech.notesreminder.R;
import com.x64tech.notesreminder.database.NotesModel;
import com.x64tech.notesreminder.database.NotesViewModel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class NoteActivity extends AppCompatActivity {

    private NotesViewModel notesViewModel;
    private EditText noteTitle, noteBody;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        initVars();
    }

    private void initVars() {
        noteTitle = findViewById(R.id.noteTitle);
        noteBody = findViewById(R.id.noteBody);

        notesViewModel = new ViewModelProvider(this).get(NotesViewModel.class);
    }

    private void save(){
        if (!(noteTitle.getText().toString().trim().equals("")
        && noteBody.getText().toString().trim().equals(""))){

            NotesModel notesModel = new NotesModel();

            notesModel.setTitle(noteTitle.getText().toString().trim());
            notesModel.setBody(noteBody.getText().toString().trim());
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                notesModel.setCreated_on(LocalDateTime.now()
                        .format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")));
            }

            Log.d("TAG", notesModel.toString());
            notesViewModel.insert(notesModel);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        save();
    }
}