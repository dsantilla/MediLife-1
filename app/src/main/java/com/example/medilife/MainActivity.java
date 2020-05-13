package com.example.medilife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
