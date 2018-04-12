package com.example.student.myfirstapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class InputOutput
{
    public String[] getNoteRows(ArrayList<Note> notes)
    {
        String[] noteRows = new String[notes.size()];

        for(int i = 0; i < noteRows.length; i++)
        {
            noteRows[i] = notes.get(i).getString();
        }

        return noteRows;
    }

    public void saveFile(ArrayList<Note> notes, MainActivity ma)
    {
        try
        {
            FileOutputStream fOut = ma.openFileOutput("myfile", Context.MODE_PRIVATE);
            ObjectOutputStream out = new ObjectOutputStream(fOut);
            out.writeObject(notes);
            out.close();
            fOut.close();
        }
        catch(Exception e)
        {
            System.out.println("ERROR: file could not be saved: " + e.getMessage());
        }
    }

    public ArrayList<Note> loadFile(MainActivity ma)
    {
        ArrayList<Note> notes = new ArrayList();

        try
        {
            FileInputStream fIn = ma.openFileInput("myfile");
            ObjectInputStream in = new ObjectInputStream(fIn);
            notes = (ArrayList<Note>) in.readObject();
            in.close();
            fIn.close();
        }
        catch(Exception e)
        {
            System.out.println("ERROR: file could not be loaded: " + e.getMessage());
        }

        return notes;
    }
}
