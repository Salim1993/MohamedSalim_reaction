package com.example.salim_000.mohamedsalim_reaction;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import java.util.Date;
import android.os.Handler;
import android.widget.Toast;

public class Singleplayer extends AppCompatActivity {

    Handler timeHandler;
    String reactionStart = "not done!";
    reactionManager currentReactions = new reactionManager();
    Date startTime;
    Date clickTime;
    Boolean startStatus = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singleplayer);
        changeButtonColor(findViewById(R.id.reactionButton), 0xFFD5D6D6);

        AlertDialog.Builder singleplayerBuilder = new AlertDialog.Builder(this);
        singleplayerBuilder.setMessage(R.string.dialogInstructions);
        singleplayerBuilder.setPositiveButton(R.string.okay, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                startStatus = true;
                onResume();
            }
        });

        Dialog singleplayerDialog = singleplayerBuilder.create();
        singleplayerDialog.show();
    }

    @Override
    protected void onResume(){
        super.onResume();

        final View.OnClickListener buttonListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // create text alert and send calculate
                clickTime = new Date();
                currentReactions.addTime(currentReactions.calculateTime(clickTime, startTime));
                System.out.println("the time is");
                System.out.println(currentReactions.calculateTime(clickTime, startTime));

                AlertDialog.Builder endBuilder = new AlertDialog.Builder(Singleplayer.this);
                endBuilder.setMessage("Your time was " + currentReactions.calculateTime(clickTime, startTime).toString() + " ms");
                endBuilder.setPositiveButton(R.string.okay, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        onResume();
                    }
                });
                Dialog endDialog = endBuilder.create();
                endDialog.show();
            }
        };

        changeButtonColor(findViewById(R.id.reactionButton),0xFFD5D6D6);


        timeHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                reactionStart = (String) msg.obj;
                startTime = new Date();
                System.out.println(startTime.toString());
                changeButtonColor(findViewById(R.id.reactionButton),0xFF00FF00);
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

    public void changeButtonColor (View button, int color){
        button.setBackgroundColor(color);
        button.invalidate();
    }

    class timeThread implements Runnable {

        startTimer timerStart = new startTimer();
        @Override
        public void run() {
            timerStart.startCountDown();
            while((!timerStart.getStatus().equals("done!")) && startStatus){}
            Message msg = Message.obtain();
            msg.obj = timerStart.getStatus();

            timeHandler.sendMessage(msg);
        }
    }

}


