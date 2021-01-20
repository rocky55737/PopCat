package com.example.popcat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView cat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cat = findViewById(R.id.Cat);


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean ret =false;
        switch (event.getActionMasked()){
            case MotionEvent.ACTION_DOWN:
                cat.setImageResource(R.drawable.popcat1);
                ret = true;
                break;
            case MotionEvent.ACTION_UP:
                cat.setImageResource(R.drawable.popcat2);
                ret =true;
                break;
        }

        return ret;
    }
}
