package com.example.salim_000.mohamedsalim_reaction;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.CountDownTimer;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.text.BreakIterator;
import java.util.Date;
import android.os.Handler;

public class Singleplayer extends AppCompatActivity {

    Handler timeHandler;
    String reactionStart = "not done!";
    reactionManager currentReactions = new reactionManager();
    Date startTime;
    Date clickTime;



    View.OnClickListener buttonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // create text alert and send calculate
            clickTime = new Date();
            currentReactions.addTime(currentReactions.calculateTime(clickTime,startTime));
            System.out.println(currentReactions.calculateTime(clickTime,startTime));
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singleplayer);

        AlertDialog.Builder singleplayerBuilder = new AlertDialog.Builder(this);
        singleplayerBuilder.setMessage(R.string.dialogInstructions);
        singleplayerBuilder.setPositiveButton(R.string.okay, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            }
        });

        Dialog singleplayerDialog = singleplayerBuilder.create();
        singleplayerDialog.show();
        //startTimer timer = new startTimer();
       // timer.startCountDown();
    }

    @Override
    protected void onResume(){
        super.onResume();

        timeHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                reactionStart = (String) msg.obj;
                startTime = new Date();
                System.out.println(startTime.toString());
                changeButtonColor(findViewById(R.id.reactionButton));
                Button reactionButton = (Button) findViewById(R.id.reactionButton);
                reactionButton.setOnClickListener(buttonListener);
            }
        };
        Thread t = new Thread(new timeThread());
        t.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_singleplayer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void changeButtonColor (View button){
        button.setBackgroundColor(0xFF00FF00);
        button.invalidate();
    }

    class timeThread implements Runnable {

        startTimer timerStart = new startTimer();
        @Override
        public void run() {
            timerStart.startCountDown();
            while(!timerStart.getStatus().equals("done!")){}
            Message msg = Message.obtain();
            msg.obj = timerStart.getStatus();

            timeHandler.sendMessage(msg);
        }
    }

}


