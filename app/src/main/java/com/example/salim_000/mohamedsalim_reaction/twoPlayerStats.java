package com.example.salim_000.mohamedsalim_reaction;

/**
 * Created by salim_000 on 2015-10-02.
 */
public class twoPlayerStats {
    int twoPlayer = 0;
    int threePlayer = 0;
    int fourPlayer = 0;

    public twoPlayerStats(int threePlayer, int twoPlayer, int fourPlayer) {
        this.threePlayer = threePlayer;
        this.twoPlayer = twoPlayer;
        this.fourPlayer = fourPlayer;
    }

    public twoPlayerStats() {
    }

    public int getTwoPlayer() {
        return twoPlayer;
    }

    public void setTwoPlayer(int twoPlayer) {
        this.twoPlayer = twoPlayer;
    }

    public int getThreePlayer() {
        return threePlayer;
    }

    public void setThreePlayer(int threePlayer) {
        this.threePlayer = threePlayer;
    }

    public int getFourPlayer() {
        return fourPlayer;
    }

    public void setFourPlayer(int fourPlayer) {
        this.fourPlayer = fourPlayer;
    }

    public void addCountTwo(){
        setTwoPlayer(getTwoPlayer() + 1);
    }

    public void addCountThree() {
        setThreePlayer(getThreePlayer() + 1);
    }

    public void addCountFour() {
        setFourPlayer(getFourPlayer() + 1);
    }
}
