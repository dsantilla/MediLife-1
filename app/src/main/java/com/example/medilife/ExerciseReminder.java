package com.example.medilife;

import com.example.medilife.Reminder;

public class ExerciseReminder extends Reminder
{
    private String[] recommendedList = {"Stretch", "Do sit-ups", "Do push-ups", "Lift weights", "Go for a run"};
    public ExerciseReminder()
    {
        super();
    }
    public ExerciseReminder(String toDo,  int hour, int minute,String timeT)
    {
        super(toDo, hour, minute,timeT);
    }

    public String[] getList()
    {
        return recommendedList;
    }
}
