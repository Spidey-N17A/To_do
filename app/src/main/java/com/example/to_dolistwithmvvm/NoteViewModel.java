package com.example.to_dolistwithmvvm;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class NoteViewModel  extends AndroidViewModel {
    private NoteRepository repository;
    private LiveData<List<note>> allnotes;
    public NoteViewModel(@NonNull Application application) {
        super(application);
        repository = new NoteRepository(application);
        allnotes = repository.getAllnotes();

    }

    public void insert(note note){
        repository.insert(note);
    }

    public void update(note note){
        repository.update(note);
    }

    public void delete(note note){
        repository.delete(note);
    }
    public void deleteallnotes(){
        repository.deleteallnotes();
    }

    public LiveData<List<note>> getAllnotes() {
        return allnotes;
    }
}
