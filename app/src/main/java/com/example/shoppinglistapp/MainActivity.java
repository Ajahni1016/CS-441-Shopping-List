package com.example.shoppinglistapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.EditText;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<String> items; //Used to store the inputted items for the list
    String[] strings;
    CustomAdapter customAdapter;
    EditText textInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        strings = getResources().getStringArray(R.array.shopping_items);
        items = new ArrayList<>();

        //Setting up text input
        textInput = findViewById(R.id.textInput);
        TextView.OnEditorActionListener exampleListener = new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView exampleView, int actionId, KeyEvent event) {
                if((event != null && (event.getKeyCode()==KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN)) || (actionId == EditorInfo.IME_ACTION_DONE && event.getAction() == KeyEvent.ACTION_DOWN) || (actionId == EditorInfo.IME_ACTION_SEND && event.getAction() == KeyEvent.ACTION_DOWN)) {
                    addItem(textInput.getText().toString());
                    recyclerView.scrollToPosition(0);
                }
                return true;
            }
        };
        textInput.setOnEditorActionListener(exampleListener);

        Collections.addAll(items, strings);

        customAdapter = new CustomAdapter(this, items);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        addItem("New Item");
    }

    private void addItem(String s){ //To add a value to the list
        items.add(0,s); // Inserting the new string
        customAdapter.notifyItemInserted(0); //Notifying the adapter that an item as been added
        textInput.getText().clear(); // Empties text box when enter is pressed
    }




}

