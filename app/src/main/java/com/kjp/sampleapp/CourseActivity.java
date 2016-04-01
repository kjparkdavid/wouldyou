package com.kjp.sampleapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.LinkedHashMap;
import java.util.Map;

public class CourseActivity extends AppCompatActivity {
    String dateName;
    LinkedHashMap<Integer,String> course_map;
    int course_size;
    LinearLayout course_layout;
    private LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
        course_layout = (LinearLayout)findViewById(R.id.course_layout);
        inflater = LayoutInflater.from(this);

        //set up data
        Intent intent = getIntent();
        dateName = intent.getExtras().getString("dateName");  //eaton, lawrence

        DateCourseFactory factory = new DateCourseFactory();
        course_map = factory.getCourse(dateName); //ex) course_map =   course_map.put( DateCourseFactory.SHOP, "Eaton Center");
        course_size = course_map.size();

        int counter = 0; //indicate if last item in HashMap
        //create dp values used for starpath
        final float scale = this.getResources().getDisplayMetrics().density;
        int widthDP = (int) (40 * scale + 0.5f);
        int heightDP = (int) (80 * scale + 0.5f);
        //loop through the data
        for(Map.Entry<Integer, String> entry : course_map.entrySet()) {
            int key = entry.getKey();
            String value = entry.getValue();
            counter++;
            //load course item layout
            LinearLayout newItem = (LinearLayout) inflater.inflate(R.layout.course_overview_item,null);
            if(counter != course_size){ //add starpath
                //ImageView Setup
                ImageView imageView = new ImageView(this);
                //setting image resource
                imageView.setImageResource(R.drawable.starpath);

                //setting image position
                LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(widthDP, heightDP);
                layoutParams.gravity= Gravity.CENTER;
                imageView.setLayoutParams(layoutParams);

                //adding view to layout
                newItem.addView(imageView);
            }
            TextView item_txt = (TextView) newItem.findViewById(R.id.item_txt);
            ImageView item_img = (ImageView) newItem.findViewById(R.id.item_img);
            //set image
             Glide
                    .with(this)
                    .load(DateCourseFactory.iconURL[key - 1])
                    .placeholder(R.drawable.rounded_bg)
                    .error(R.drawable.roundedtopbackground)
                     .fitCenter()
                     .into(item_img);

            //set text
            item_txt.setText(value);
            //add the layout to screen
            course_layout.addView(newItem);
        }
    }
}
