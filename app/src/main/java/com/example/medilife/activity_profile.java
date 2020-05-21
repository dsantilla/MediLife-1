package com.example.medilife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class activity_profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        TextView BMI = (TextView) findViewById(R.id.textView_BMI);
        TextView level = (TextView) findViewById(R.id.levelView);
        final EditText name = (EditText) findViewById(R.id.editText_name);
        final EditText age = (EditText) findViewById(R.id.editText_age);
        final EditText height = (EditText) findViewById(R.id.editText_height);
        final EditText weight = (EditText) findViewById(R.id.editText_weight);

        Calendar tempCal = Calendar.getInstance();
        int curDay = tempCal.get(Calendar.DAY_OF_WEEK) - 1; // 1 is monday, 7 is sunday. subtracted 1 for correct list indexing
        final TextView tasks = (TextView) findViewById(R.id.unfinished3);
        tasks.setText(Integer.toString(dataLayer.getList().get(curDay).getListSize()));

        level.setText(profile.getInstance().displayLevel());
        BMI.setText(profile.getInstance().calculateBMI());
        name.setText(profile.getInstance().getName());
        age.setText(Integer.toString(profile.getInstance().getAge()));
        height.setText(Double.toString(profile.getInstance().getHeight()));
        weight.setText(Double.toString(profile.getInstance().getWeight()));

        Button backBtn = (Button) findViewById(R.id.homeButtonProfile);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String message = name.getText().toString();
                    profile.getInstance().setName(message);

                    message = age.getText().toString();
                    int num = Integer.parseInt(message);
                    profile.getInstance().setAge(num);

                message = height.getText().toString();
                double dub = Double.parseDouble(message);
                profile.getInstance().setHeight(dub);

                message = weight.getText().toString();
                dub = Double.parseDouble(message);
                profile.getInstance().setWeight(dub);

                    Intent startIntentReminder = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(startIntentReminder);
                    }




        });
    }
}
