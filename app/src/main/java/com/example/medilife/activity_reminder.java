package com.example.medilife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class activity_reminder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);

        final ListView list = (ListView) findViewById(R.id.reminderView);
        ArrayAdapter reminders = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,
                dataLayer.getList().get(dataLayer.getDay()).getListReminders());
        //This retrieves the list of reminders from a specific day stored in the dataLayer arrayList.
        reminders.setNotifyOnChange(true);
        list.setAdapter(reminders);


        Button backBtn = (Button) findViewById(R.id.homeButtonReminder);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntentReminder = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(startIntentReminder);
            }
        });

        Button addReminderBtn = (Button) findViewById(R.id.goToAddReminder);
        addReminderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntentAdd = new Intent(activity_reminder.this,activity_add_reminder.class);
                startActivity(startIntentAdd);
            }
        });
    }

}
