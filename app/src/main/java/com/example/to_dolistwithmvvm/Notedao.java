package com.example.to_dolistwithmvvm;

import android.provider.ContactsContract;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface Notedao {

    @Insert
    void insert(ContactsContract.CommonDataKinds.Note note);

    @Update
    void update(ContactsContract.CommonDataKinds.Note note);

    @Delete
    void delete(ContactsContract.CommonDataKinds.Note note);

    @Query("Delete From note_table")
    void deleteallnotes();

    @Query("Select * From note_table ORDER BY priortiy desc")
    List<>getallnotes();
}
