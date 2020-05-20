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

            if (i == 0)
            {
                HygieneReminder reminder1 = new HygieneReminder("Brush your teeth!", 7, 30);
                ExerciseReminder reminder2 = new ExerciseReminder("Go for a walk outside.", 12, 30);
                CustomReminder reminder3 = new CustomReminder("Drink a glass of water.", 17, 15);
                temp.addReminder(reminder1);
                temp.addReminder(reminder2);
                temp.addReminder(reminder3);
            }
            else if (i == 1)
            {
                HygieneReminder reminder1 = new HygieneReminder("Don't forget to floss!", 7, 30);
                ExerciseReminder reminder2 = new ExerciseReminder("Do 10 minutes of push-ups and sit-ups", 12, 0);
                CustomReminder reminder3 = new CustomReminder("Take a relaxing bath.", 20, 0);
                temp.addReminder(reminder1);
                temp.addReminder(reminder2);
                temp.addReminder(reminder3);
            }
            else if (i == 2)
            {
                HygieneReminder reminder1 = new HygieneReminder("Comb your hair.", 7, 15);
                ExerciseReminder reminder2 = new ExerciseReminder("Go for a quick jog!", 12, 0);
                CustomReminder reminder3 = new CustomReminder("Clean your room.", 15, 0);
                temp.addReminder(reminder1);
                temp.addReminder(reminder2);
                temp.addReminder(reminder3);
            }
            else if (i == 3)
            { // eat a healthy meal
                HygieneReminder reminder1 = new HygieneReminder("Brush your teeth!", 7, 30);
                ExerciseReminder reminder2 = new ExerciseReminder("Go for a walk outside.", 12, 30);
                CustomReminder reminder3 = new CustomReminder("Drink a glass of water.", 17, 15);
                temp.addReminder(reminder1);
                temp.addReminder(reminder2);
                temp.addReminder(reminder3);
            }
            else if (i == 4)
            {
                HygieneReminder reminder1 = new HygieneReminder("Don't forget to floss!", 7, 30);
                ExerciseReminder reminder2 = new ExerciseReminder("Do 10 minutes of push-ups and sit-ups", 12, 0);
                CustomReminder reminder3 = new CustomReminder("Take a relaxing bath.", 20, 0);
                temp.addReminder(reminder1);
                temp.addReminder(reminder2);
                temp.addReminder(reminder3);
            }
            else if (i == 5)
            {
                HygieneReminder reminder1 = new HygieneReminder("Comb your hair.", 7, 15);
                ExerciseReminder reminder2 = new ExerciseReminder("Go for a quick jog!", 12, 0);
                CustomReminder reminder3 = new CustomReminder("Clean your room.", 15, 0);
                temp.addReminder(reminder1);
                temp.addReminder(reminder2);
                temp.addReminder(reminder3);
            }
            else if (i == 6)
            {
                HygieneReminder reminder1 = new HygieneReminder("Brush your teeth!", 7, 30);
                ExerciseReminder reminder2 = new ExerciseReminder("Go for a walk outside.", 12, 30);
                CustomReminder reminder3 = new CustomReminder("Drink a glass of water.", 17, 15);
                temp.addReminder(reminder1);
                temp.addReminder(reminder2);
                temp.addReminder(reminder3);
            }
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