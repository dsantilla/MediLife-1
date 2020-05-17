package com.example.medilife;

import com.example.medilife.Reminder;

public class HygieneReminder extends Reminder {
    private String[] recommendedList = {"Brush teeth", "Floss teeth", "Take a shower", "Apply Deodorant", "Do skin routine"};
    public HygieneReminder()
    {
        super();
    }
    public HygieneReminder(String toDo,  int hour, int minute,String timeT)
    {
        super(toDo, hour, minute,timeT);
    }

    public String[] getList()
    {
        return recommendedList;
    }
}
