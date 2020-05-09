package com.example.medilife;

public abstract class Reminder
{

    private boolean status = false;
    private String task;
    private float time;
    private String[] recommendedList = new String[5];
    private int listLength = 0;

    public Reminder()
    {
        task = "";
        time = 0;
    }
    public Reminder(String toDo, float timeToDo)
    {
        task = toDo;
        time = timeToDo;
    }
    public void setTask(String toDo)
    {  task = toDo; }

    public void setTime(float timeToDo)
    {  time = timeToDo; }

    public void setStatus(boolean completed)
    { status = completed; }

    public String getTask()
    {  return task;    }

    public float getTime()
    { return time; }

    public boolean getStatus()
    { return status; }

    public String[] getList()
    { return recommendedList; }

    public void addToList(String task)
    {
        if(listLength == recommendedList.length)
        {
            recommendedList = lengthenList(recommendedList);
        }
        recommendedList[listLength] = task;
        listLength++;
    }

    public String[] lengthenList(String[] oldList)
    {
        String[] newList = new String[oldList.length * 2];
        for (int i = 0; i < oldList.length; i++)
        {
            newList[i] = oldList[i];
        }
        return newList;
    }
}