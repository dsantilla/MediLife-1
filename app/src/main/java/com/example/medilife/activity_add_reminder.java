package com.example.medilife;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Spinner;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class activity_add_reminder extends AppCompatActivity implements OnItemSelectedListener{

    private String[] hygiene_suggestions = {"Brush teeth", "Floss teeth", "Take a shower", "Apply Deodorant", "Do skin routine"};
    private String[] exercise_suggestions = {"Stretch", "Do sit-ups", "Do push-ups", "Lift weights", "Go for a run"};
    private String[] custom_suggestions = {"Eat Breakfast", "Drink water", "Take a nap", "Have a healthy snack"};
    private ArrayAdapter hygieneAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, hygiene_suggestions);
    private ArrayAdapter exerciseAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, exercise_suggestions);
    private ArrayAdapter customAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, custom_suggestions);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_reminder);
        String[] reminder_types = {"Hygiene", "Exercise", "Custom"};


        Spinner typeSpinner = (Spinner) findViewById(R.id.typeSpinner);
        ArrayAdapter adapter1 = new ArrayAdapter(this,android.R.layout.simple_list_item_1, reminder_types);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeSpinner.setAdapter(adapter1);

        hygieneAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exerciseAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        customAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner suggestionSpinner = (Spinner) findViewById(R.id.suggestionSpinner);
        suggestionSpinner.setAdapter(hygieneAdapter);
    }

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();
        Spinner tempSpinner = (Spinner) findViewById(position);
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
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
}
