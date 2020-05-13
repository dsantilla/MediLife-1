import java.util.*;
public class TimerTest {
    public static void main(String[] Args)
    {
        ArrayList<Day> DaysOfTheWeek = new ArrayList<>(); // ArrayList of 7 Day objects for the week
        for (int i = 0; i < 7; i++)
        {
            Day temp = new Day();
            // test code
            Reminder testReminder = new CustomReminder("just DO IT, day " + i, 17, 36);
            temp.addReminder(testReminder);
            // end test code
            DaysOfTheWeek.add(temp);
        }

        //maybe add default reminders to each day here? This is the main/runtime class now?

        Timer timeCheck = new Timer();
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                Calendar cal = Calendar.getInstance();
                int currentDay = cal.get(Calendar.DAY_OF_WEEK);
                int currentHour = cal.get(Calendar.HOUR_OF_DAY); // get the hour number of the day, from 0 to 23
                int currentMinute = cal.get(Calendar.MINUTE);

                // for each reminder in today's list of reminders
                for (int i = 0; i < DaysOfTheWeek.get(currentDay).getListReminders().size(); i++) {
                    Reminder currentReminder = DaysOfTheWeek.get(currentDay).getListReminders().get(i);
                    int[] time = currentReminder.getTime();
                    int reminderHour = time[0];
                    int reminderMinute = time[1];

                    //test code
                    System.out.println(currentDay + " " + currentHour + " " + reminderHour + " " + currentMinute + " " + reminderMinute);

                    if (currentHour == reminderHour) {
                        if (currentMinute == reminderMinute || currentMinute > reminderMinute) //correct minute or passed the correct minute
                        {
                            if (!currentReminder.getCompleted() && !currentReminder.getOnScreen()) //not completed, not on screen yet
                            {
                                System.out.println(currentReminder.getTask());
                                currentReminder.setOnScreen(true);
                            }
                        }
                    } else if (currentHour > reminderHour) // didn't output reminder at correct earlier hour
                    {
                        if (!currentReminder.getCompleted() && !currentReminder.getOnScreen()) //not completed, not on screen yet
                        {
                            System.out.println(currentReminder.getTask());
                            currentReminder.setOnScreen(true);
                        }
                    }
                }
            }
        };
        Calendar newCalendar = Calendar.getInstance();
        timeCheck.schedule(tt, 0, 1000*60); //run every 60 seconds
    }
}

