package com.example.medilife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.widget.Spinner;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.view.View;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;

public class activity_add_reminder extends AppCompatActivity{

    private String[] hygiene_suggestions;
    private String[] exercise_suggestions;
    private String[] custom_suggestions;
    private ArrayAdapter<String> hygieneAdapter;
    private ArrayAdapter<String> exerciseAdapter;
    private ArrayAdapter<String> customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_reminder);



        String[] reminder_types = {"Hygiene", "Exercise", "Custom"};
        hygiene_suggestions = new String[]{"Brush teeth", "Floss teeth", "Take a shower", "Apply Deodorant", "Do skin routine"};
        exercise_suggestions =  new String[]{"Stretch", "Do sit-ups", "Do push-ups", "Lift weights", "Go for a run"};
        custom_suggestions  = new String[]{"Eat Breakfast", "Drink water", "Take a nap", "Have a healthy snack"};
        hygieneAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, hygiene_suggestions);
        exerciseAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, exercise_suggestions);
        customAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, custom_suggestions);

        Spinner typeSpinner = (Spinner) findViewById(R.id.typeSpinner);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, reminder_types);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeSpinner.setAdapter(adapter1);

        hygieneAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exerciseAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        customAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner suggestionSpinner = (Spinner) findViewById(R.id.suggestionSpinner);
        suggestionSpinner.setAdapter(hygieneAdapter);
        typeSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // On selecting a spinner item
                String item = parent.getItemAtPosition(position).toString();
                Spinner tempSpinner = (Spinner) findViewById(R.id.suggestionSpinner);
                if(item.equals("Hygiene"))
                {
                    tempSpinner.setAdapter(hygieneAdapter);
                }
                else if(item.equals("Exercise"))
                {
                    tempSpinner.setAdapter(exerciseAdapter);
                }
                else if(item.equals("Custom"))
                {
                    tempSpinner.setAdapter((customAdapter));
                }
            }

            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Button addReminderBtn = (Button) findViewById(R.id.createButton);
        addReminderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editTaskBox = (EditText) findViewById(R.id.editTask);
                EditText editHourBox = (EditText) findViewById(R.id.editHour);
                EditText editMinuteBox = (EditText) findViewById(R.id.editMinute);
                String task = editTaskBox.getText().toString();
                int hr = Integer.parseInt(editHourBox.getText().toString());
                int min = Integer.parseInt(editMinuteBox.getText().toString());

                CustomReminder newReminder = new CustomReminder(task, hr, min);
                dataLayer.getList().get(dataLayer.getDay()).addReminder(newReminder);
                Intent startIntentReminder = new Intent(getApplicationContext(), activity_reminder.class);
                startActivity(startIntentReminder);
            }
        });
    }


}
