package com.example.to_dolistwithmvvm;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class NoteRepository {
    private NoteDao noteDao;
    private LiveData<List<note>> allnotes;
    private NoteRepository(Application application)
    {
        NoteDatabase Database = NoteDatabase.getInstance(application);
        noteDao = Database.noteDao();
        allnotes = noteDao.getallnotes();
    }

    public void insert(note note){
        new InsertNoteAsyncTask(noteDao).execute(note);
    }
    public void update(note note){
        new UpdateNoteAsyncTask(noteDao).execute(note);
    }
    public void delete(note note){
        new DeleteNoteAsyncTask(noteDao).execute(note);

    }
    public void deleteallnotes(note note){
        new DeleteallNotesAsyncTask(noteDao).execute();
    }

    public static class InsertNoteAsyncTask extends AsyncTask<note,Void,Void>{
       private NoteDao noteDao;
       private InsertNoteAsyncTask(NoteDao noteDao){
           this.noteDao=noteDao;
       }
        @Override
        protected Void doInBackground(note... notes) {
           noteDao.insert(notes[0]);
            return null;
        }
    }
    public static class DeleteNoteAsyncTask extends AsyncTask<note,Void,Void>{
        private NoteDao noteDao;
        private DeleteNoteAsyncTask(NoteDao noteDao){
            this.noteDao=noteDao;
        }
        @Override
        protected Void doInBackground(note... notes) {
            noteDao.delete(notes[0]);
            return null;
        }
    }
    public static class UpdateNoteAsyncTask extends AsyncTask<note,Void,Void>{
        private NoteDao noteDao;
        private UpdateNoteAsyncTask(NoteDao noteDao){
            this.noteDao=noteDao;
        }
        @Override
        protected Void doInBackground(note... notes) {
            noteDao.update(notes[0]);
            return null;
        }
    }
    public static class DeleteallNotesAsyncTask extends AsyncTask<Void,Void,Void>{
        private NoteDao noteDao;
        private DeleteallNotesAsyncTask(NoteDao noteDao){
            this.noteDao=noteDao;
        }
        @Override
        protected Void doInBackground(Void... Voids) {
            noteDao.deleteallnotes();
            return null;
        }
    }
}
