package com.example.medilife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class activity_reminder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);

        Button backBtn = (Button) findViewById(R.id.homeButtonReminder);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntentReminder = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(startIntentReminder);
            }
        });
    }
}
