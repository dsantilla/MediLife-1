/**
 * Day.java
 * A day class written for the MediLife app daily reminders screen
 * Written By Omri Or
 */

import java.util.*;

public class Day {
    private ArrayList<Reminder> reminders = new ArrayList<Reminder>();
    public Day() {}

    public void addReminder(Reminder newReminder) {
        int newTime[] = new int[2];
        int currentTime[] = new int[2];
        newTime = newReminder.getTime();
        for(int i = 0; i < this.reminders.size(); i++) {
            currentTime = this.reminders.get(i).getTime();
            if(newTime[0] < currentTime[0] && newTime[1] < currentTime[1]) {
                continue;
            }
            else {
                this.reminders.add(i+1, newReminder);
            }
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
