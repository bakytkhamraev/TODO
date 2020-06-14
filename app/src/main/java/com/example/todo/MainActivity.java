package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import com.example.todo.Intro.IntroActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Preference();
    }

    private void Preference() {
        SharedPreferences preferences = getSharedPreferences("setting", MODE_PRIVATE);
        boolean isShown = preferences.getBoolean("isShown", false);
        if (!isShown) {
            startActivity(new Intent(this, IntroActivity.class));
            finish();
            return;
        }

    }

    public void IntroStart(View view) {
        startActivity(new Intent(this,IntroActivity.class ));
    }
}
