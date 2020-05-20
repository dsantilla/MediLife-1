package com.example.medilife;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class dataLayer {
    private static final ArrayList reminderLists = createList();
    private static int currentDay = 1;

    public static ArrayList<day> createList()
    {
        ArrayList<day> tempList = new ArrayList<day>();
        for (int i = 0; i < 7; i++) {
            day temp = new day();
            HygieneReminder remindTest = new HygieneReminder("brush teeth test", 5, 2);
            temp.addReminder(remindTest);
            tempList.add(temp);
        }
        return tempList;
    }

    public static ArrayList<day> getList()
    {
        return reminderLists;
    }

    public static void changeDay(int day)
    {
        currentDay = day;
    }

    public static int getDay()
    {
        return currentDay;
    }
}