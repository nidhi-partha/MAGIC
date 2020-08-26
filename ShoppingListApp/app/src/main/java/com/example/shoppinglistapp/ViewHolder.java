package com.example.shoppinglistapp;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo.R;

public class ViewHolder extends RecyclerView.ViewHolder {
    public TextView textView;
    public CheckBox checkbox;
    public ViewHolder(@NonNull View view) {
        super(view);
        this.textView=view.findViewById(R.id.textView);
        this.checkbox=view.findViewById(R.id.checkbox);
    }
}
