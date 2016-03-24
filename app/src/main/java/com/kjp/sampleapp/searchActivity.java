package com.kjp.sampleapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;

public class searchActivity extends AppCompatActivity {
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

        gridView = (GridView) findViewById(R.id.usage_example_gridview);
        gridAdapter = new ImageListAdapter(mContext,eatFoodyImages);

        gridView.setAdapter(gridAdapter);

        sliderShow = (SliderLayout) findViewById(R.id.slider);

        DefaultSliderView textSliderView = new DefaultSliderView(this);


        textSliderView.image( "http://i.imgur.com/vceTRaG.jpg")
                .setScaleType(BaseSliderView.ScaleType.FitCenterCrop);

        DefaultSliderView textSliderView1 = new DefaultSliderView(this);
        textSliderView1.image("http://i.imgur.com/vRhi9mt.jpg").setScaleType(BaseSliderView.ScaleType.FitCenterCrop);


        sliderShow.addSlider(textSliderView);
        sliderShow.addSlider(textSliderView1);



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

}
