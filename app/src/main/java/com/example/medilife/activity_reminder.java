package com.example.medilife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class activity_reminder extends AppCompatActivity {

    String task;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);

        TextView dayDisplay = (TextView) findViewById(R.id.dayView);
        String[] days = {"Sunday","Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        dayDisplay.setText(days[dataLayer.getDay()]);

        final ListView list = (ListView) findViewById(R.id.reminderView);
        ArrayAdapter reminders = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,
                dataLayer.getList().get(dataLayer.getDay()).getListReminders());
        //This retrieves the list of reminders from a specific day stored in the dataLayer arrayList.
        reminders.setNotifyOnChange(true);
        list.setAdapter(reminders);

        Spinner taskSpinner = (Spinner) findViewById(R.id.taskSpinner);
        ArrayAdapter tasksToComplete = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,
                dataLayer.getList().get(dataLayer.getDay()).getListReminders());
        tasksToComplete.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        taskSpinner.setAdapter(tasksToComplete);

        taskSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // On selecting a spinner item
                task = parent.getItemAtPosition(position).toString();
            }

            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Button backBtn = (Button) findViewById(R.id.homeButtonReminder);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntentReminder = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(startIntentReminder);
            }
        });

        Button completeButton= (Button) findViewById(R.id.taskButton);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataLayer.getList().get(dataLayer.getDay()).completeReminder(task);
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
