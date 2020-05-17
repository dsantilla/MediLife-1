package com.example.medilife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

     profile myProfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list = (ListView) findViewById(R.id.theList);
        HygieneReminder remindTest = new HygieneReminder("brush teeth",8,1,"AM");
        day.getInstance().addReminder(remindTest);
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,day.getList());
        list.setAdapter(adapter);

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
