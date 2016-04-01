package com.kjp.sampleapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;

import java.util.HashMap;

public class searchActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener {
    Context mContext;
    GridView gridView;
    ImageListAdapter gridAdapter;

    SliderLayout sliderShow;
    private int previousPosition = 0;
    private final int SLIDER_COUNT = 2;

    public static String[] eatFoodyImages = {
            "http://i.imgur.com/Ozr2z1O.jpg",
            "http://i.imgur.com/dIqtHMO.jpg",
            "http://i.imgur.com/oKKDKTH.jpg",
            "http://i.imgur.com/aBDFGz1.jpg",
            "http://i.imgur.com/o0RresZ.jpg",
            "http://i.imgur.com/p02ccXJ.jpg",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        mContext = this;

        HashMap<String,String> url_maps = new HashMap<String, String>();
        url_maps.put("eaton", "http://i.imgur.com/v5atgRl.jpg");
        url_maps.put("lawrence", "http://i.imgur.com/9FPlKfE.jpg");
//        url_maps.put("House of Cards", "http://cdn3.nflximg.net/images/3093/2043093.jpg");
//        url_maps.put("Game of Thrones", "http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg");

        gridView = (GridView) findViewById(R.id.usage_example_gridview);
        gridAdapter = new ImageListAdapter(mContext,eatFoodyImages);

        gridView.setAdapter(gridAdapter);

        sliderShow = (SliderLayout) findViewById(R.id.slider);
        for(String name : url_maps.keySet()){
            DefaultSliderView textSliderView = new DefaultSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    .image(url_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);

            sliderShow.addSlider(textSliderView);
        }

        sliderShow.stopAutoCycle();
    }

    @Override
    public void onBackPressed()
    {

        new AlertDialog.Builder(this)
                    .setTitle("Exit")
                    .setMessage("Are you sure you want to close?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }

                    })
                    .setNegativeButton("No", null)
                    .show();

    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
       //Log.e("Search", "slider clicked");
        String course_name = slider.getBundle().get("extra").toString();
       // Toast.makeText(this, course_name + "", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(searchActivity.this, CourseActivity.class);
        i.putExtra("dateName", course_name);
        startActivity(i);
    }
}
