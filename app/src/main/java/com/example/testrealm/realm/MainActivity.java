package com.example.testrealm.realm;

import android.animation.ArgbEvaluator;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.testrealm.R;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private String SAMPLES = "question_set.json";
    private Integer[] colors = null;
    private ViewPagerAdapter adapter;
    private ArgbEvaluator argbEvaluator = new ArgbEvaluator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getPagerView();
        readFileFromAssets();
    }

    private void getPagerView() {

        viewPager = findViewById(R.id.viewKlass);
        adapter = new ViewPagerAdapter();
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130, 0, 130, 0);

        Integer[] colors_temp = {
                getResources().getColor(R.color.color1),
        };
        colors = colors_temp;

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position < (adapter.getCount() - 1) && position < (colors.length - 1)) {
                    viewPager.setBackgroundColor((Integer) argbEvaluator.evaluate(positionOffset, colors[position], colors[position + 1]));
                } else {
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
        adapter.notify(homeModels.getTitle());
    }
}
