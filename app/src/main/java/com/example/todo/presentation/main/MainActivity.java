package com.example.todo.presentation.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.todo.data.PreferenceHelper;
import com.example.todo.presentation.intro.IntroActivity;
import com.example.todo.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boolean isShown=PreferenceHelper.getInstance(this).isShown();


        if (!isShown){startActivity(new Intent(this, IntroActivity.class));
            finish();
            return;
        }

    }



    public void IntroStart(View view) {
        startActivity(new Intent(this, IntroActivity.class));
    }
}
