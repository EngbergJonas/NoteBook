package com.example.student.myfirstapp;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Note implements Serializable
{
    private String noteText;
    private Date date;

    public Note (String noteText)
    {
        this.noteText = noteText;
        date = new Date();
    }

    public String getNoteText()
    {
        return noteText;
    }

    public Date getDate()
    {
        return date;
    }

    public String getString()
    {
        SimpleDateFormat format = new SimpleDateFormat("hh:mm");
        String time = format.format((date));
        return time.toString() + ": " + noteText;
    }
}
