package com.example.medilife;

import java.util.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

     profile myProfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // new code adding in TimerTest logic
        final ArrayList<day> DaysOfTheWeek = new ArrayList<>(); // ArrayList of 7 Day objects for the week. 0 index is monday.
        for (int i = 0; i < 7; i++)
        {
            day temp = new day();
            HygieneReminder remindTest = new HygieneReminder("brush teeth test",20,2);
            temp.addReminder(remindTest);
            DaysOfTheWeek.add(temp);
        }

        final ListView list = (ListView) findViewById(R.id.theList);
        Calendar tempCal = Calendar.getInstance();
        day tempCurrentDay = DaysOfTheWeek.get(tempCal.get(Calendar.DAY_OF_WEEK) - 1); // grabs current day from the list of days
        ArrayAdapter<Reminder> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,tempCurrentDay.getIncompleteList());
        adapter.setNotifyOnChange(true);
        list.setAdapter(adapter);

        Timer timeCheck = new Timer();
        TimerTask tt = new TimerTask() {
            @Override
            public void run()
            {
                Calendar cal = Calendar.getInstance();
                int currentDay = cal.get(Calendar.DAY_OF_WEEK) - 1; // 1 is monday, 7 is sunday. subtracted 1 for correct list indexing
                int currentHour = cal.get(Calendar.HOUR_OF_DAY); // get the hour number of the day, from 0 to 23
                int currentMinute = cal.get(Calendar.MINUTE);

                // for each reminder in today's list of reminders
                for (int i = 0; i < DaysOfTheWeek.get(currentDay).getListReminders().size(); i++)
                {
                    Reminder currentReminder = DaysOfTheWeek.get(currentDay).getListReminders().get(i);
                    int[] time = currentReminder.getTime();
                    int reminderHour = time[0];
                    int reminderMinute = time[1];

                    if (currentHour == reminderHour) {
                        if (currentMinute == reminderMinute || currentMinute > reminderMinute) //correct minute or passed the correct minute
                        {
                            if (!currentReminder.getCompleted() && !currentReminder.getOnScreen()) //not completed, not on screen yet
                            {
                                //System.out.println(currentReminder.getTask());
                                DaysOfTheWeek.get(currentDay).addIncompleteReminder(currentReminder);
                                currentReminder.setOnScreen(true);
                            }
                        }
                    } else if (currentHour > reminderHour) // didn't output reminder at correct earlier hour
                    {
                        if (!currentReminder.getCompleted() && !currentReminder.getOnScreen()) //not completed, not on screen yet
                        {
                            //System.out.println(currentReminder.getTask());
                            DaysOfTheWeek.get(currentDay).addIncompleteReminder(currentReminder);
                            currentReminder.setOnScreen(true);
                        }
                    }
                }
            }
        };
        timeCheck.schedule(tt, 0, 1000 * 10); // run tt every second.

        Button toReminderBtn = (Button) findViewById(R.id.goToReminder);
        toReminderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntentReminder = new Intent(getApplicationContext(),activity_reminder.class);
                startActivity(startIntentReminder);
            }
        });

        Button toProfileBtn = (Button)findViewById(R.id.goToProfile);
        toProfileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntentProfile = new Intent(getApplicationContext(), activity_profile.class);
                startIntentProfile.putExtra("userProfile", (Parcelable) myProfile);
                startActivity(startIntentProfile);
            }
        });

    }


}
