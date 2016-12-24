package com.example.android.bballscorecounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int homeScore = 0;
    int homeTimeOuts = 6;
    int awayScore = 0;
    int awayTimeOuts = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.refresh_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.refresh_button) {
            homeScore = 0;
            awayScore = 0;
            homeTimeOuts = 6;
            awayTimeOuts = 6;
            displayHomeScore(homeScore);
            displayAwayScore(awayScore);
            displayHomeTO(homeTimeOuts);
            displayAwayTO(awayTimeOuts);
        }

        return super.onOptionsItemSelected(item);
    }

    //home score
    public void homeThree(View v){
        homeScore = homeScore + 3;
        displayHomeScore(homeScore);
    }
    public void homeTwo(View v){
        homeScore = homeScore + 2;
        displayHomeScore(homeScore);
    }
    public void homeSubtract(View v){
        if(homeScore > 0) {
            homeScore = homeScore - 1;
            displayHomeScore(homeScore);
        }else{
            displayHomeScore(0);
        }
    }
    public void homeAdd(View v){
        homeScore = homeScore + 1;
        displayHomeScore(homeScore);
    }
    public void homeTimeoutsClick(View v){
        if(homeTimeOuts <= 6 && homeTimeOuts > 0){
            homeTimeOuts = homeTimeOuts - 1;
            displayHomeTO(homeTimeOuts);
        }else if(homeTimeOuts == 0){
            homeTimeOuts = 6;
            displayHomeTO(homeTimeOuts);
        }
    }

    //away score
    public void awayThree(View v){
        awayScore = awayScore + 3;
        displayAwayScore(awayScore);
    }
    public void awayTwo(View v){
        awayScore = awayScore + 2;
        displayAwayScore(awayScore);
    }
    public void awaySubtract(View v){
        if(awayScore > 0){
            awayScore = awayScore - 1;
            displayAwayScore(awayScore);
        }else{
            displayAwayScore(0);
        }
    }
    public void awayAdd(View v){
        awayScore = awayScore + 1;
        displayAwayScore(awayScore);
    }
    public void awayTimeoutsClick(View v){
        if(awayTimeOuts <= 6 && awayTimeOuts > 0){
            awayTimeOuts = awayTimeOuts - 1;
            displayAwayTO(awayTimeOuts);
        }else if(awayTimeOuts == 0){
            awayTimeOuts = 6;
            displayAwayTO(awayTimeOuts);
        }
    }

    //displaying scores
    public void displayHomeScore(int hs){
        TextView hsTV = (TextView)findViewById(R.id.home_score);
        hsTV.setText(String.valueOf(hs));
    }
    public void displayAwayScore(int as){
        TextView asTV = (TextView)findViewById(R.id.away_score);
        asTV.setText(String.valueOf(as));
    }
    public void displayHomeTO(int hto){
        TextView htotv = (TextView)findViewById(R.id.home_timeouts);
        htotv.setText(String.valueOf(hto));
    }
    public void displayAwayTO(int ato){
        TextView atotv = (TextView)findViewById(R.id.away_timeouts);
        atotv.setText(String.valueOf(ato));
    }
}
