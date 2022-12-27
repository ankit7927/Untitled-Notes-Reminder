package com.x64tech.notesreminder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.x64tech.notesreminder.adapter.NotesAdapter;
import com.x64tech.notesreminder.database.NotesModel;
import com.x64tech.notesreminder.database.NotesViewModel;
import com.x64tech.notesreminder.pages.NoteActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Intent intent;
    RecyclerView notesRecycleView;
    FloatingActionButton addNotesButton;
    NotesAdapter notesAdapter;
    NotesViewModel notesViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initVars();

        addNotesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(), NoteActivity.class);
                startActivity(intent);
            }
        });

        notesRecycleView.setAdapter(notesAdapter);
        notesRecycleView.setLayoutManager(new StaggeredGridLayoutManager(2, RecyclerView.VERTICAL));
        notesViewModel.getAllNotes().observe(this, new Observer<List<NotesModel>>() {
            @Override
            public void onChanged(List<NotesModel> notesModels) {
                notesAdapter.setData(notesModels);
            }
        });

    }

    private void initVars() {
        notesRecycleView = findViewById(R.id.notesRecycleView);
        addNotesButton = findViewById(R.id.addNotesButton);
        notesViewModel = new ViewModelProvider(this).get(NotesViewModel.class);

        notesAdapter = new NotesAdapter(this);
    }
}