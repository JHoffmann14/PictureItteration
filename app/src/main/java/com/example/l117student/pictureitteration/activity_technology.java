package com.example.l117student.pictureitteration;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class activity_technology extends AppCompatActivity {

    protected int[] images = {R.drawable.phone, R.drawable.laptop, R.drawable.desktop};

    protected ImageView pics;
    protected int picNum=0;
    protected double xaxis = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_technology);
        pics = (ImageView)findViewById(R.id.picture);
    }
    @SuppressLint("ResourceType")
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater1 = getMenuInflater();
        inflater1.inflate(R.layout.menu, menu);
       // Log.v("josh","has a menu");
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.dogs:
                //Intent intent = new Intent(this, MainActivity.class);
                main();
                return true;
            case R.id.technology:
                //Intent intent1 = new Intent(this,Technology.class);

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
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

    public void main(){
        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);
    }
    public void bye(View view){
        Intent intent = new Intent(this, MoreFun.class);
        startActivity(intent);
    }
}
