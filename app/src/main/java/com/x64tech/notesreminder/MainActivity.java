package com.x64tech.notesreminder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.x64tech.notesreminder.pages.NoteActivity;

public class MainActivity extends AppCompatActivity {
    Intent intent;
    RecyclerView notesRecycleView;
    FloatingActionButton addNotesButton;
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
    }

    private void initVars() {
        notesRecycleView = findViewById(R.id.notesRecycleView);
        addNotesButton = findViewById(R.id.addNotesButton);
    }
}