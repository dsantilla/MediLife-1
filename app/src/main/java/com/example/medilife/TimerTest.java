import java.util.*;
public class TimerTest {
    public static void main(String[] Args)
    {

        //test values, should use values from Reminder class objects
        int reminderHour = 20;
        int reminderMinute = 31;

        Timer timeCheck = new Timer();
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                Calendar cal = Calendar.getInstance();
                int currentHour = cal.get(Calendar.HOUR_OF_DAY);//get the hour number of the day, from 0 to 23
                int currentMinute = cal.get(Calendar.MINUTE);

                // if (today is monday) grab the monday object's list of the day's reminders.
                // for each reminder in the current day:
                if (currentHour == reminderHour)
                {
                    if (currentMinute == reminderMinute || currentMinute > reminderMinute) //correct minute or passed the correct minute
                    {
                        System.out.println("its time"); // output the reminder if it has not yet been completed, and
                        // if the reminder is not already on screen. Use booleans
                        // Reminder.completed, Reminder.activeOnScreen ?
                    }
                }
                else if (currentHour > reminderHour) // didn't output reminder at correct earlier hour
                {
                    System.out.println("its time"); // output the reminder if it has not yet been completed
                }

            }
        };
        Calendar newCalendar = Calendar.getInstance();
        timeCheck.schedule(tt, 0, 1000*60); //run every 60 seconds
    }
}
