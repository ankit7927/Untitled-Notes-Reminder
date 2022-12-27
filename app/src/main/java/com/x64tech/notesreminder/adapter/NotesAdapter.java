package com.x64tech.notesreminder.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.x64tech.notesreminder.R;
import com.x64tech.notesreminder.database.NotesModel;

import java.util.List;

public class NotesAdapter extends
        RecyclerView.Adapter<NotesAdapter.NotesAdapterViewHolder> {

    Context context;
    List<NotesModel> notesModelList;

    public NotesAdapter(Context context, List<NotesModel> notesModelList) {
        this.context = context;
        this.notesModelList = notesModelList;
    }

    @NonNull
    @Override
    public NotesAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.notes_layout, parent, false);
        return new NotesAdapter.NotesAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesAdapterViewHolder holder, int position) {
        NotesModel notesModel = notesModelList.get(position);
        holder.noteTitleView.setText(notesModel.getTitle());
        holder.noteBodyView.setText(notesModel.getBody());
    }

    @Override
    public int getItemCount() {
        return notesModelList.size();
    }

    public static class NotesAdapterViewHolder extends RecyclerView.ViewHolder {
        TextView noteTitleView, noteBodyView;
        public NotesAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            noteTitleView = itemView.findViewById(R.id.noteTitleView);
            noteBodyView = itemView.findViewById(R.id.noteBodyView);
        }
    }
}
