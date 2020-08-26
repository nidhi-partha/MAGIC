package com.example.shoppinglistapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.shoppinglistapp.CreateActivity;
import com.example.demo.R;
import com.example.shoppinglistapp.data.AppDatabase;
import com.example.shoppinglistapp.data.DatabaseRepo;
import com.example.shoppinglistapp.data.ShoppingListItem;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Observable;
import java.util.Set;

import static com.example.shoppinglistapp.CreateActivity.SHOPPING_LIST_KEY;


public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private FloatingActionButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycle_view);
        recyclerView = findViewById(R.id.my_recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        final DatabaseRepo databaseRepo = new DatabaseRepo(this);
        LiveData<List<ShoppingListItem>> items = databaseRepo.getAll();
        items.observe(this, new Observer<List<ShoppingListItem>>() {
            @Override
            public void onChanged(List<ShoppingListItem> shoppingListItems) {
                recyclerView.setAdapter(new MyAdapter(databaseRepo, shoppingListItems));
            }
        });

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity2();
            }
        });
    }
    public void openActivity2(){
        Intent intent = new Intent(this,CreateActivity.class);
                startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}