package com.example.to_dolistwithmvvm;

import androidx.room.Entity;

@Entity(tableName = "note_table")
public class note {


    private int id;
    private String title;
    private String disc;
    private int priortiy;

    public note(String title, String disc, int priortiy) {
        this.title = title;
        this.disc = disc;
        this.priortiy = priortiy;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDisc() {
        return disc;
    }

    public int getPriortiy() {
        return priortiy;
    }
}
