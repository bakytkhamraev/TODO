package com.example.todo.presentation.intro;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.todo.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class IntroFragment extends Fragment {


    public IntroFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_intro, container, false);
        int pos = getArguments().getInt("pos");
        TextView textView = view.findViewById(R.id.textView);
        ImageView imageView = view.findViewById(R.id.imageView);

        switch (pos) {
            case 0:
                textView.setText(getString(R.string.Robert));
                imageView.setImageResource(R.drawable.robert);
                break;
            case 1:
                textView.setText(getString(R.string.Robert));
                imageView.setImageResource(R.drawable.robert);
                break;
            case 2:
                textView.setText(getString(R.string.Robert));
                imageView.setImageResource(R.drawable.robert);
                break;
        }
        return view;
    }
}
