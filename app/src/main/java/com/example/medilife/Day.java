package com.example.medilife;

import java.util.*;

public class day {
    private static final ArrayList<Reminder> reminders = new ArrayList<Reminder>();
    private day() {}

    private static final day DAY = new day();

    public static day getInstance() {return DAY;}
    public static ArrayList<Reminder> getList(){return DAY.reminders;}
    public void addReminder(Reminder newReminder) {
        int[] newTime;
        int[] currentTime;
        newTime = newReminder.getTime();
        if (this.reminders.size() != 0) // reminders is not empty
        {
            for (int i = 0; i < this.reminders.size(); i++)
            {
                currentTime = this.reminders.get(i).getTime();
                if (newTime[0] < currentTime[0]) // new hour is before the current reminder hour
                {
                    this.reminders.add(i, newReminder); //place it before current one
                    break; //stop the for loop
                }
                else if (newTime[0] == currentTime[0]) //same hour
                {
                    if (newTime[1] < currentTime[1]) // new minute is before current minute
                    {
                        this.reminders.add(i, newReminder); // place before current one
                        break; // stop for loop
                    }
                    else // new minute is greater than current minute
                    {
                        if (i == this.reminders.size() - 1) // at the end of the array list, no next loop
                        {
                            this.reminders.add(newReminder); // put on the end of the list
                            break; // stop for loop
                        }
                        else
                            continue; // go to next loop
                    }
                }
                else // new hour is after reminder hour
                {
                    if (i == this.reminders.size() - 1) // at the end of the array list, no next loop
                    {
                        this.reminders.add(newReminder); // put on the end of the list
                        break; // stop for loop
                    }
                    else // check the next loop
                        continue;
                }
            }
        }
        else // the reminder list is empty
        {
            this.reminders.add(newReminder);
        }
    }

    public ArrayList<Reminder> getListReminders() {
        return this.reminders;
    }

    public void removeReminder(String task) {
        int index = -1;
        for(int i = 0; i < this.reminders.size(); i++) {
            if(this.reminders.get(i).getTask() == task) {
                index = i;
                break;
            }
        }
        if(index != -1) {
            this.reminders.remove(index);
        }
        else{
            System.out.println("Reminder doesn't exist.");
        }
    }

    public String ToString() {
        String remindersList = "";
        for(int i = 0; i < this.reminders.size(); i++) {
            remindersList += (this.reminders.get(i).getTask() + this.reminders.get(i).getTime());
        }
        return remindersList;
    }
}