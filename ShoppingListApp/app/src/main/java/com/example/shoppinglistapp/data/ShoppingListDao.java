package com.example.shoppinglistapp.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ShoppingListDao {
    @Query("SELECT * FROM shoppinglistitem")
    LiveData<List<ShoppingListItem>> getAll();

    @Update
    void updateItem(ShoppingListItem item);

    @Insert
    void addItem(ShoppingListItem item);

}
