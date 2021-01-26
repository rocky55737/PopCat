package com.example.popcat;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView cat[] = new ImageView[3];
    ImageView pop;
    TextView counter;
    ImageButton store;

    int pop_count;
    int index=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cat[0] = findViewById(R.id.Cat1);
        cat[1] = findViewById(R.id.Cat2);
        cat[2] = findViewById(R.id.Cat3);
        pop = findViewById(R.id.pop);
        counter = findViewById(R.id.counter);
        store = findViewById(R.id.store);

        store.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, StoreActivity.class);
            intent.putExtra("popcount", pop_count);
            startActivityForResult(intent, 1001);
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean ret =false;
        switch (event.getActionMasked()){
            case MotionEvent.ACTION_DOWN:
                for(int i=0; i<=index; i++){
                    cat[i].setImageResource(R.drawable.popcat1);
                }
                ret = true;
                break;
            case MotionEvent.ACTION_UP:
                for(int i=0; i<=index; i++){
                    cat[i].setImageResource(R.drawable.popcat2);
                    pop_count+=1;
                }
                counter.setText("POP : "+pop_count);
                pop.getLayoutParams().width=(int)(pop_count*10);
                pop.getLayoutParams().height=(int)(pop_count*10);
                pop.requestLayout();
                ret =true;
                break;
        }


        return ret;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==1001){
            if(resultCode==2001){
                int temp = data.getIntExtra("result", 0);
                if(temp<pop_count){
                    cat[++index].setVisibility(View.VISIBLE);
                }
                pop_count = temp;
                counter.setText("POP : "+pop_count);
            }
        }
    }
}
