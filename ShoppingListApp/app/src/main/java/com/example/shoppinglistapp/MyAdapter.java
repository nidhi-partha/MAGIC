package com.example.shoppinglistapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo.R;
import com.example.shoppinglistapp.data.AppDatabase;
import com.example.shoppinglistapp.data.DatabaseRepo;
import com.example.shoppinglistapp.data.ShoppingListItem;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<ViewHolder>{
    private List<ShoppingListItem> shoppingListItems;
    private DatabaseRepo databaseRepo;
    public MyAdapter(DatabaseRepo databaseRepo, List<ShoppingListItem> shoppingListItems){
        this.shoppingListItems = shoppingListItems;
        this.databaseRepo = databaseRepo;
    } //constructer method because there is no return type (Method name and return type is the same)
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_view, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ShoppingListItem item = shoppingListItems.get(position);
        holder.textView.setText(item.name);
        if (item.checked){
           holder.checkbox.setChecked(true);
       }
       else{
           holder.checkbox.setChecked(false);
       }
        View.OnClickListener checkbox_listener= new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (((CheckBox)view).isChecked()) {
                    item.checked = true;
                    databaseRepo.updateItem(item);
                } else {
                    item.checked = false;
                    databaseRepo.updateItem(item);
                }
            }
        };
       holder.checkbox.setOnClickListener(checkbox_listener);
    }

    @Override
    public int getItemCount() {
        return shoppingListItems.size();
    }
}
