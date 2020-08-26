package com.example.shoppinglistapp.data;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Room;
import androidx.room.Update;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class DatabaseRepo {
    static volatile AppDatabase appDatabase;
    Executor executor;
    private LiveData<List<ShoppingListItem>> allItems;
    public DatabaseRepo(Context context) {
        if (appDatabase == null) {
            appDatabase = Room.databaseBuilder(context,
                    AppDatabase.class, "database-name").build();
        }
        allItems = appDatabase.getDao().getAll();
        executor = Executors.newFixedThreadPool(4);
    }

    public LiveData<List<ShoppingListItem>> getAll() {
        return allItems;
    }

    public void updateItem(final ShoppingListItem item) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                appDatabase.getDao().updateItem(item);
            }
        });
    }

    public void addItem(final ShoppingListItem item) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                appDatabase.getDao().addItem(item);
            }
        });
    }
}
