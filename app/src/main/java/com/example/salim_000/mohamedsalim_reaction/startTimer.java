package com.example.salim_000.mohamedsalim_reaction;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by salim_000 on 2015-09-29.
 */
public class startTimer {

    long totalTime = new Random().nextLong() * 10000;
    Timer timer = new Timer();

    private String status = "not done";

    public startTimer() {
    }

    public void startCountDown() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                status = "done!";
            }
        }, 5000);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String text) {status = text;}

}
