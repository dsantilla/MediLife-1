package com.example.medilife;

public abstract class Reminder
{
    private boolean onScreen = false;
    private boolean completed = false;
    private String task;
    private int hr;
    private int min;
    private String timeType;
    private int listLength = 0;

    public Reminder()
    {
        task = "";
        hr = 12;
        min = 0;
        timeType = "AM";
    }
    public Reminder(String toDo,  int hour, int minute, String tt)
    {
        task = toDo;
        if (hour <= 12 && hour >= 1)
        {
            hr = hour;
        }

        if(minute <= 60 && minute >= 1)
        {
            min = minute % 60;
        }

        if(tt.equalsIgnoreCase("am") || tt.equalsIgnoreCase("pm"))
        {
            timeType = tt.toUpperCase();
        }

    }
    public void setTask(String toDo)
    {  task = toDo; }

    public void setTime(int hour, int minute)
    {
         hr = hour % 24;
         min = minute % 60;
    }

    public void setCompleted(boolean status)
    { completed = status; }

    public void setOnScreen(boolean status)
    { onScreen = status; }

    public String getTask()
    {  return task;    }

    public int[] getTime()
    {
        int[] time = {hr, min};
        return time;
    }

    public boolean getOnScreen()
    {  return onScreen;    }

    public boolean getCompleted()
    { return completed; }

    public abstract String[] getList();

    public String toString()
    {
        String temp;
        if(min < 10)
            temp = (task + " by " + hr + ":" + "0" + min + " " + timeType);
        else
            temp = (task + " by " + hr + ":" + min + " " + timeType);

        return temp;
    }

}