package com.kjp.sampleapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPref;
    String selected_language;
    TextView koreanBtn,englishBtn,chineseBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPref = this.getSharedPreferences("lang_pref", Context.MODE_PRIVATE);
        selected_language = sharedPref.getString("language", "none");
        //if language was selected before
        if(selected_language.equalsIgnoreCase("none")){
            setContentView(R.layout.activity_main);
            koreanBtn = (TextView)findViewById(R.id.koreanBtn);
            koreanBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    selected_language = "korean";
                    //save chosen language
                    saveChosenLanguage(selected_language);
                }
            });

            englishBtn = (TextView)findViewById(R.id.englishBtn);
            englishBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    selected_language = "english";
                    //save chosen language
                    saveChosenLanguage(selected_language);
                }
            });

            TextView txt = (TextView) findViewById(R.id.custom_font);
            Typeface font = Typeface.createFromAsset(getAssets(), "orange_juice.ttf");
            txt.setTypeface(font);

        }else{
            Intent i = new Intent(MainActivity.this, searchActivity.class);
            startActivity(i);
            MainActivity.this.finish();
        }

    }

    private void saveChosenLanguage(String lang) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("language", lang);
        editor.commit();
//        Intent intent = getIntent();
//        finish();
//        startActivity(intent);
        Intent i = new Intent(MainActivity.this, searchActivity.class);
        startActivity(i);
        MainActivity.this.finish();
    }

}
