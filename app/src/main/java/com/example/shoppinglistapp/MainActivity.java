package com.example.shoppinglistapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.KeyEvent;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import android.view.View;
import android.widget.EditText;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    MaterialCardView itemCard;
    RecyclerView recyclerView;
    ArrayList<String> items; //Used to store the inputted items for the list
    ArrayList<String> times; //When each item was placed in the list
    String[] strings;
    CustomAdapter customAdapter;
    EditText textInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemCard = findViewById(R.id.itemCard);
        recyclerView = findViewById(R.id.recyclerView);

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

        //Setting up text to go into list
        items = new ArrayList<>();
        times = new ArrayList<>();
        strings = getResources().getStringArray(R.array.shopping_items);
        Collections.addAll(items, strings);
        strings = getResources().getStringArray(R.array.time_added);
        Collections.addAll(times, strings);

        customAdapter = new CustomAdapter(this, items, times);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        addItem("New Item");
    }

    private void addItem(String s){ //To add a value to the list
        String currentDate = new SimpleDateFormat("M/d/yy h:mm a", Locale.getDefault()).format(new Date());


        items.add(0,s); // Inserting the new string
        times.add(0,currentDate); // Marking time of addition
        customAdapter.notifyItemInserted(0); //Notifying the adapter that an item as been added
        textInput.getText().clear(); // Empties text box when enter is pressed
    }

    public void checkItem(View view){
//        itemCard.setCardBackgroundColor(0xFFE1E6EA);
    }


}

