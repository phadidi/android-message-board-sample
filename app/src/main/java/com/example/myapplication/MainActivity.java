package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;



import java.util.*;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    //vars
    private ArrayList<String> firstMessages = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: started");
        //initMessages();

    }

    public void postButton( View view )
    {
        EditText text = findViewById( R.id.editTextFirstResponse);
        String message = text.getText().toString();
        firstMessages.add(message);
        initRecyclerView();
    }

    private void initMessages() {
        Log.d(TAG, "initMessages: Preparing the list");
        firstMessages.add("comment1");
        firstMessages.add("comment2");
        firstMessages.add("comment3");
        firstMessages.add("comment4");
        firstMessages.add("comment5");
        initRecyclerView();
    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: Init RecyclerView started");
        RecyclerView recyclerView  = findViewById(R.id.recyclerv_view);
        RecyclerViewAdapter adapter;
        adapter = new RecyclerViewAdapter(this, firstMessages);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
