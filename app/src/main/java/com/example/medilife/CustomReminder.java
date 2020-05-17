package com.example.medilife;
import com.example.medilife.Reminder;

public class CustomReminder extends Reminder {
    private String[] recommendedList = {"Eat Breakfast", "Drink water", "Take a nap", "Have a healthy snack"};
    public CustomReminder()
    {
        super();
    }
    public CustomReminder(String toDo,  int hour, int minute,String timeT)
    {
        super(toDo, hour, minute,timeT);
    }

    public String[] getList()
    {
        return recommendedList;
    }
}
