package com.example.to_dolistwithmvvm;

import android.icu.text.Transliterator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.Noteholder> {
    private List<note> notes = new ArrayList<>();
    private OnClickListener listener;

    @NonNull
    @Override
    public Noteholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.note_item, parent, false);
        return new Noteholder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull Noteholder holder, int position) {
        note CurrentNote = notes.get(position);
        holder.textViewTitle.setText(CurrentNote.getTitle());
        holder.textViewDescription.setText(CurrentNote.getDisc());
        holder.textViewPriority.setText(CurrentNote.getPriortiy() + "");

    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    class Noteholder extends RecyclerView.ViewHolder {
        private TextView textViewTitle;
        private TextView textViewDescription;
        private TextView textViewPriority;

        public Noteholder(@NonNull final View itemView) {
            super(itemView);
            textViewDescription = itemView.findViewById(R.id.textViewDescription);
            textViewPriority = itemView.findViewById(R.id.textViewPriority);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int postion = getAdapterPosition();
                    if (postion != RecyclerView.NO_POSITION && listener != null) {
                        listener.OnItemClick(notes.get(postion));
                    }
                }
            });
        }
    }

    public void setNotes(List<note> notes) {
        this.notes = notes;
        notifyDataSetChanged();
    }

    public note getNoteAt(int position) {
        return notes.get(position);
    }

    public interface OnClickListener {
        void OnItemClick(note note);
    }

    public void setOnclicklistenter(OnClickListener listener) {
        this.listener = listener;
    }

}
