package com.example.covid_19;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.covid_19.helper.sliderAdapter;
import com.google.android.material.slider.Slider;

public class Introduce_users extends AppCompatActivity {
    Slider slider;
ViewPager viewPager;
LinearLayout dotsLayout;
TextView[] dots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduce_users);
        viewPager = findViewById(R.id.slider);
        dotsLayout = findViewById(R.id.dots);
//        call the adapter
        sliderAdapter sliderAdapter = new sliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);
        addDotsIndicator(0);
        viewPager.addOnPageChangeListener(viewListener);
    }
    private void addDotsIndicator(int position){
        dots = new TextView[3];
        dotsLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText("•");
            dots[i].setTextSize(35);
            dotsLayout.addView(dots[i]);
        }
        if (dots.length > 0){
            dots[position].setTextColor(getResources().getColor(R.color.black));
        }
    }
    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDotsIndicator(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}