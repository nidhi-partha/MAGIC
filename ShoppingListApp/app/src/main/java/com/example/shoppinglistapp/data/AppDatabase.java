package com.example.shoppinglistapp.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {ShoppingListItem.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ShoppingListDao getDao();
}
