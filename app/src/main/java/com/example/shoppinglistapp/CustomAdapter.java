package com.example.shoppinglistapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    ArrayList<String> data;
    Context context;
    int isEmpty;

    public CustomAdapter(Context ct, ArrayList<String> items){
        context = ct;
        data = items;
        isEmpty = 1; //Change to 0 when i enable the add button
    }

//    public void addItem(String[] listOfItems, String s){ //To add a value to the list
//        if(isEmpty==1) { // If a value has already been added to the list
//            String[] newList = new String[listOfItems.length + 1];
//            int index = 0;
//            for (String i : listOfItems) {
//                newList[index] = i; // Duplicating the original list
//                index++;
//            }
//            newList[index] = s; // Inserting the new string
//            this.notifyItemInserted(data.length - 1); //Notifying the adapter that an item as been added
//        }
//
//        else{ //If the list is empty, replace the "Your list is empty" message with the new item
//            isEmpty = 0; // Once an item has been added, it's no longer empty
//            // Not yet implemented
//        }
//
//    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.text_row_item, viewGroup, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int position) {
        viewHolder.itemText.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView itemText;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            itemText = itemView.findViewById(R.id.itemsText);
        }
    }
}
