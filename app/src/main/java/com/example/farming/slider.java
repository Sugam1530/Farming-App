package com.example.farming;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class slider extends AppCompatActivity {

    ViewPager viewPager;
    Button btnNext;
    int[] layouts;
    com.example.farming.adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);

        viewPager = findViewById(R.id.pager);
        btnNext = findViewById(R.id.nextBtn);

        layouts = new int[] {
                R.layout.slider1,
                R.layout.slider2,
                R.layout.slider3

        };

        adapter = new adapter(this, layouts);
        viewPager.setAdapter((PagerAdapter) adapter);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (viewPager.getCurrentItem() +1 < layouts.length){
                    viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                } else{
                    startActivity(new Intent(getApplicationContext(), Enter_mobile_number.class));

                }
            }
        });

        viewPager.addOnPageChangeListener(viewPagerChangeListner);
    }

    ViewPager.OnPageChangeListener viewPagerChangeListner = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int i) {

            if (i == layouts.length - 1){
                btnNext.setText("Continue");
            } else {
                btnNext.setText("Next");
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}