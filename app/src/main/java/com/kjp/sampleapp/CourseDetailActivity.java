package com.kjp.sampleapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CourseDetailActivity extends AppCompatActivity {
    String dateName, courseDetailName;
    TextView headerText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail);

        Intent intent = getIntent();
        dateName = intent.getExtras().getString("dateName");  //ex) eaton, lawrence
        courseDetailName = intent.getExtras().getString("courseDetailName"); //ex) Don Don Izakaya

        headerText = (TextView)findViewById(R.id.headerText);
        headerText.setText(courseDetailName);


    }
}
