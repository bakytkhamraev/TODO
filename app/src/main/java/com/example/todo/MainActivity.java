package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /*
        - Создать пустой проект и запушить на гитхаб (ссылку мне в личку)
        - Добавить IntroActivity и прописать как стартовую
        - Добавить ViewPager в IntroActivity с тремя фрагментами
        - В IntroActivity две кнопки next и skip при клике на next перелистывать страницу ViewPager-a,
          на последнем экране ViewPager-a кнопку skip прятать и заменять текст кнопки next на start,
          кнопка start запускает MainActivity (при свайпе на предыдущие страницы состояние кнопок восстанавливать)
        - В IntroActivity кнопка skip для старта MainActivity
        */
    }
}
