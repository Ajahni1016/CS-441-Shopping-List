package com.example.shoppinglistapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<String> items; //Used to store the inputted items for the list
    String[] strings;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        strings = getResources().getStringArray(R.array.shopping_items);
        items = new ArrayList<>();

        for(String s:strings){
            items.add(s);
        }

        customAdapter = new CustomAdapter(this, items);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        addItem("New Item");
    }

    private void addItem(String s){ //To add a value to the list
        items.add(s); // Inserting the new string
        customAdapter.notifyItemInserted(items.size() - 1); //Notifying the adapter that an item as been added
    }

}

