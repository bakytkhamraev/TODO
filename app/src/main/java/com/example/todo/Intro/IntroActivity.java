package com.example.todo.Intro;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.example.todo.MainActivity;
import com.example.todo.R;
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator;

public class IntroActivity extends AppCompatActivity {

    private Button SkipButton, NextButton;
    private ViewPager viewPager;
    private int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        SkipButton = findViewById(R.id.skip);
        NextButton = findViewById(R.id.next);
        viewPager = findViewById(R.id.view_Pager);

        SectionPagerAdapter adapter = new SectionPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        WormDotsIndicator wormDotsIndicator = findViewById(R.id.worm_dots_indicator);
        wormDotsIndicator.setViewPager(viewPager);


        NextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(getItem(+1), true);
            }
        });

        SkipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(IntroActivity.this, MainActivity.class));
                finish();

            }
        });


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                pos = position;
                if (pos < 2) {
                    SkipButton.setVisibility(View.VISIBLE);
                    NextButton.setVisibility(View.VISIBLE);
                } else {
                    SkipButton.setVisibility(View.INVISIBLE);
                    NextButton.setVisibility(View.VISIBLE);
                    NextButton.setText("Start");
                    NextButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            SharedPreferences preferences = getSharedPreferences("setting", MODE_PRIVATE);
                            preferences.edit().putBoolean("isShown", true).apply();
                            skipClick(v);
                        }
                    });
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }


    private void skipClick(View view) {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }


    private int getItem(int i) {
        return viewPager.getCurrentItem() + i;
    }


    public class SectionPagerAdapter extends FragmentPagerAdapter {

        public SectionPagerAdapter(@NonNull FragmentManager fm) {
            super(fm, SectionPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            IntroFragment fragment = new IntroFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("pos", position);
            fragment.setArguments(bundle);
            return fragment;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
