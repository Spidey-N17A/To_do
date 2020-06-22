package com.example.to_dolistwithmvvm;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = note.class , version = 1)
public abstract class NoteDatabase extends RoomDatabase {

    public static NoteDatabase instance;
    public abstract NoteDao noteDao();
    public static synchronized NoteDatabase getInstance(Context context){
        if(instance == null)
        {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    NoteDatabase.class,"note_database").fallbackToDestructiveMigration()
                    .addCallback(roomcallback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomcallback = new RoomDatabase.Callback(){

        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulatedbAsyncTask(instance);
        }
    };

    private static class PopulatedbAsyncTask extends AsyncTask<Void , Void , Void>{
        private NoteDao noteDao;
        private PopulatedbAsyncTask (NoteDatabase db)
        {
            noteDao = db.noteDao();

        }

        @Override
        protected Void doInBackground(Void... voids) {
            noteDao.insert(new note( "Title1","Discription1",1) );
            noteDao.insert(new note( "Title2","Discription2",2) );
            noteDao.insert(new note( "Title3","Discription3",3) );
            return null;
        }
    }
}
