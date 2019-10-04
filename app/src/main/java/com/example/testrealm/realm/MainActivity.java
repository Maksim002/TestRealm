package com.example.testrealm.realm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.animation.ArgbEvaluator;
import android.os.Bundle;
import android.os.Parcelable;

import com.example.testrealm.R;
import com.example.testrealm.realm.Adaptor;
import com.example.testrealm.realm.Model;
import com.example.testrealm.realm.ResourceManager;
import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private String SAMPLES = "question_set.json";
    private Integer[] colors = null;
    private  Adaptor adaptor;
    private ArgbEvaluator argbEvaluator = new ArgbEvaluator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        readFileFromAssets();

        viewPager = findViewById(R.id.viewKlass);
        adaptor = new Adaptor();
        viewPager.setAdapter(adaptor);
        viewPager.setPadding(130, 0, 130, 0);

        Integer[] colors_temp = {
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
        };

        colors = colors_temp;

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position < (adaptor.getCount() - 1) && position < (colors.length - 1)){
                    viewPager.setBackgroundColor((Integer) argbEvaluator.evaluate(positionOffset, colors[position],colors[position + 1]));
                }else {
                    viewPager.setBackgroundColor(colors[colors.length - 1]);
                }

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    private void readFileFromAssets() {

        String json = ResourceManager.readFileFromAssets(getApplicationContext(), SAMPLES);
        Model homeModels = new Gson().fromJson(json, Model.class);
        adaptor.notify(homeModels.questionnaires());
    }

}
