package com.example.medilife;

import java.lang.reflect.Array;
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
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    profile myProfile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView level = (TextView) findViewById(R.id.levelViewMain);
        level.setText(profile.getInstance().displayLevelMain());

        Calendar tempCal = Calendar.getInstance();
        dataLayer.changeDay(  tempCal.get(tempCal.get(Calendar.DAY_OF_WEEK) - 1)  ); // update day in data layer

        day tempCurrentDay = dataLayer.getList().get(tempCal.get(Calendar.DAY_OF_WEEK) - 1); // grabs current day from the list of days

        final ListView list = (ListView) findViewById(R.id.theList);
        ArrayAdapter<Reminder> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,
                tempCurrentDay.getIncompleteList());
        //This retrieves the list of reminders from a specific day stored in the dataLayer arrayList.
        adapter.setNotifyOnChange(true);
        list.setAdapter(adapter);


        int curDay = tempCal.get(Calendar.DAY_OF_WEEK) - 1; // 1 is monday, 7 is sunday. subtracted 1 for correct list indexing
        dataLayer.changeDay(curDay);

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
                for (int i = 0; i < dataLayer.getList().get(currentDay).getListReminders().size(); i++)
                {
                    Reminder currentReminder = dataLayer.getList().get(currentDay).getListReminders().get(i);
                    int[] time = currentReminder.getTime();
                    int reminderHour = time[0];
                    int reminderMinute = time[1];

                    if (currentHour == reminderHour) {
                        if (currentMinute == reminderMinute || currentMinute > reminderMinute) //correct minute or passed the correct minute
                        {
                            if (!currentReminder.getCompleted() && !currentReminder.getOnScreen()) //not completed, not on screen yet
                            {
                                //System.out.println(currentReminder.getTask());
                                dataLayer.getList().get(currentDay).addIncompleteReminder(currentReminder);
                                currentReminder.setOnScreen(true);
                            }
                        }
                    } else if (currentHour > reminderHour) // didn't output reminder at correct earlier hour
                    {
                        if (!currentReminder.getCompleted() && !currentReminder.getOnScreen()) //not completed, not on screen yet
                        {
                            //System.out.println(currentReminder.getTask());
                            dataLayer.getList().get(currentDay).addIncompleteReminder(currentReminder);
                            currentReminder.setOnScreen(true);
                        }
                    }
                }
            }
        };
        timeCheck.schedule(tt, 0, 1000 * 1); // run tt every second.


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
                startActivity(startIntentProfile);
            }
        });

    }




}
