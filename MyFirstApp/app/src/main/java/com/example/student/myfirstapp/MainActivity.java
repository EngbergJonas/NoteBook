package com.example.student.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity
{
    ArrayList<Note> notes;
    InputOutput io;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        io = new InputOutput();
        notes = io.loadFile(this);
        lv = (ListView) findViewById(R.id.myListView);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        updateList();
    }


    //Anropas när man klickar på exit
    public void onExit(View v)
    {
        io.saveFile(notes, this);
        System.exit(0);
    }

    //Anropas när man klickar på save
    public void onSave(View v)
    {
        EditText et = findViewById(R.id.inputText);
        notes.add(new Note(et.getText().toString()));

        updateList();
    }

    public void updateList()
    {
        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, io.getNoteRows(notes));
        ListView lv = findViewById(R.id.myListView);
        lv.setAdapter(itemsAdapter);
    }

    public void onClean(View v){
        notes.clear();
        Toast.makeText(MainActivity.this, "All data cleaned", Toast.LENGTH_LONG).show();
    }
}
