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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    protected int[] images = {R.drawable.wolf, R.drawable.siberian_husky, R.drawable.husky};
    protected ImageView pics;
    protected int picNum=0;
    protected double xaxis = 0;

    @SuppressLint("ResourceType")
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.layout.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.dogs:
                //Intent intent = new Intent(this, MainActivity.class);

                return true;
            case R.id.technology:
                //Intent intent1 = new Intent(this,Technology.class);
                technology();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pics = (ImageView)findViewById(R.id.picture);

        //Spinner
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        List<String> dogs = new ArrayList<String>();
        dogs.add("wolf");
        dogs.add("siberian_huskey");
        dogs.add("huskey");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, dogs);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        String item = adapterView.getItemAtPosition(position).toString();
       // Toast.makeText(adapterView.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
        pics.setImageResource(images[position]);
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

    public void rightClicked(View view) {
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

    public void technology(){
        Intent intent = new Intent(this, activity_technology.class);

        startActivity(intent);
    }
    public void bye(View view){
        Intent intent = new Intent(this, MoreFun.class);
        startActivity(intent);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
