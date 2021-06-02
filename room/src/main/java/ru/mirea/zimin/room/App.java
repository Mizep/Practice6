package ru.mirea.zimin.room;

import android.app.Application;

import androidx.room.Room;

public class App extends Application {
    public static ru.mirea.zimin.room.App instance;
    private ru.mirea.zimin.room.AppDatabase database;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = Room.databaseBuilder(this, ru.mirea.zimin.room.AppDatabase.class, "database")
                .allowMainThreadQueries()
                .build();
    }
    public static ru.mirea.zimin.room.App getInstance() {
        return instance;
    }
    public ru.mirea.zimin.room.AppDatabase getDatabase() {
        return database;
    }
}
