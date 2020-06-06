package com.example.to_dolistwithmvvm;

import android.provider.ContactsContract;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface NoteDao {

    @Insert
    void insert(note note);

    @Update
    void update(note note);

    @Delete
    void delete(note note);

    @Query("DELETE FROM note_table ")
    void deleteallnotes();

    @Query("SELECT * FROM note_table ORDER BY priortiy desc")
    LiveData<List<note>>getallnotes();
}
