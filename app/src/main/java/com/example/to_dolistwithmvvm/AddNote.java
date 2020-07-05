package com.example.to_dolistwithmvvm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AddNote extends AppCompatActivity {

    FloatingActionButton floatingActionButton = findViewById(R.id.floatingActionButton);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
    }
}
