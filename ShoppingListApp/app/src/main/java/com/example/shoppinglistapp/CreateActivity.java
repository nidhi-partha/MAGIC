package com.example.shoppinglistapp;

import android.os.Bundle;
import android.app.Activity;

import android.view.View;
import android.view.View.OnClickListener;

import android.widget.Button;
import android.widget.EditText;

import androidx.room.Room;

import com.example.demo.R;
import com.example.shoppinglistapp.data.AppDatabase;
import com.example.shoppinglistapp.data.DatabaseRepo;
import com.example.shoppinglistapp.data.ShoppingListItem;

public class CreateActivity extends Activity {
    public static final String SHOPPING_LIST_KEY = "SOMETHING";
    EditText eText;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eText = (EditText) findViewById(R.id.edittext);
        btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                DatabaseRepo databaseRepo = new DatabaseRepo(v.getContext().getApplicationContext());
                ShoppingListItem item = new ShoppingListItem();
                item.name = eText.getText().toString();
                item.checked = false;
                databaseRepo.addItem(item);
                finish();
            }
        });
    }
}