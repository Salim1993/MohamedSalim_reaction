package com.example.salim_000.mohamedsalim_reaction;

import android.os.CountDownTimer;

import java.text.BreakIterator;
import java.util.Random;

/**
 * Created by salim_000 on 2015-09-29.
 */
public class startTimer {

    long totalTime = new Random().nextLong() * 10000;

    private String status = "not done";

    public startTimer() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String text) {status = text;}

    private CountDownTimer timer = new CountDownTimer(3000,1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            status = ("seconds remaining: " + ((int) millisUntilFinished / 1000));
        }

        @Override
        public void onFinish() {
            status = "done!";
        }
    };

    public void startCountDown() {
        timer.start();
    }
}
