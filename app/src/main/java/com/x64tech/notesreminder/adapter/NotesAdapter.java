package com.x64tech.notesreminder.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.x64tech.notesreminder.R;
import com.x64tech.notesreminder.database.NotesModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NotesAdapter extends
        RecyclerView.Adapter<NotesAdapter.NotesAdapterViewHolder> {

    Context context;
    List<NotesModel> notesModelList = new ArrayList<>();

    public NotesAdapter(Context context) {
        this.context = context;
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

    public void setData(List<NotesModel> newData){
        notesModelList.clear();
        notesModelList.addAll(newData);
        notifyDataSetChanged();
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
