package com.example.medilife;

import com.example.medilife.Reminder;

public class ExerciseReminder extends Reminder
{
    private String[] recommendedList = {"Stretch", "Do sit-ups", "Do push-ups", "Lift weights", "Go for a run"};
    public ExerciseReminder()
    {
        super();
    }
    public ExerciseReminder(String toDo,  int hour, int minute)
    {
        super(toDo, hour, minute);
    }

    public String[] getList()
    {
        return recommendedList;
    }
}
