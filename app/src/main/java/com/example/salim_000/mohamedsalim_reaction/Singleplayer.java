package com.example.salim_000.mohamedsalim_reaction;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.text.BreakIterator;
import java.util.logging.Handler;

public class Singleplayer extends AppCompatActivity {

    private Handler handler;
    private beforeReactionTime time = new beforeReactionTime();
    private startTimer timerStart = new startTimer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singleplayer);
        handler = new timeHandler();


        AlertDialog.Builder singleplayerBuilder = new AlertDialog.Builder(this);
        singleplayerBuilder.setMessage(R.string.dialogInstructions);
        singleplayerBuilder.setPositiveButton(R.string.okay, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                time.doInBackground();
            }
        });

        Dialog singleplayerDialog = singleplayerBuilder.create();
        singleplayerDialog.show();

        /*
        boolean tester = true;
        timerStart.startCountDown();
        while(timerStart.getStatus().equals("done!")){
            tester = false;
        }
        */
        if(time.getStats().equals("done!")) {
            changeButtonColor(findViewById(R.id.reactionButton));
        }


        //startTimer timer = new startTimer();
       // timer.startCountDown();
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

    public class beforeReactionTime extends AsyncTask<Void,Void,Void>{
        private startTimer timer = new startTimer();

        protected Void doInBackground(Void... params) {
            timer.startCountDown();
            while(timer.getStatus().equals("done!")){}
            return null;
        }


        public String getStats(){
            return timer.getStatus();
        }
    }
}


