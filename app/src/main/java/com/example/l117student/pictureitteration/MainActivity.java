package com.example.l117student.pictureitteration;

import android.content.Intent;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    protected int[] images = {R.drawable.wolf, R.drawable.siberian_husky, R.drawable.husky};
    protected ImageView pics;
    protected int picNum=0;
    protected double xaxis = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pics = (ImageView)findViewById(R.id.picture);
    }

    public void leftClicked(View view){
       leftSwipe();
    }
    private void leftSwipe() {
        picNum--;
        if(picNum < 0){
            picNum = images.length-1;
        }
        pics.setImageResource(images[picNum]);
    }

    public void rightCliced(View view) {
       rightSwipe();
    }
    private void rightSwipe(){
        picNum++;
        if(picNum > images.length-1){
            picNum = 0;
        }
        pics.setImageResource(images[picNum]);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        int action = MotionEventCompat.getActionMasked(event);
        switch(action) {
            case (MotionEvent.ACTION_DOWN) :
                xaxis = event.getRawX();

                return true;
            case (MotionEvent.ACTION_UP) :
                if(xaxis > event.getRawX())
                    leftSwipe();
                else
                    rightSwipe();
                return true;
            default :
                return super.onTouchEvent(event);
        }
    }

    public void bye(View view){
        Intent intent = new Intent(this, MoreFun.class);
        startActivity(intent);
    }
}
