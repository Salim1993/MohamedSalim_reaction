package com.example.salim_000.mohamedsalim_reaction;

/**
 * Created by salim_000 on 2015-10-02.
 */
public class threePlayerStats {
    int threePlayer = 0;
    int fourPlayer = 0;

    public threePlayerStats() {}

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

    public void addCountThree() {
        setThreePlayer(getThreePlayer() + 1);
    }

    public void addCountFour() {
        setFourPlayer(getFourPlayer() + 1);
    }

    public void clear() {
        setThreePlayer(0);
        setFourPlayer(0);
    }

    public void setAll(int threePlayer, int fourPlayer){
        this.threePlayer = threePlayer;
        this.fourPlayer = fourPlayer;
    }
}
