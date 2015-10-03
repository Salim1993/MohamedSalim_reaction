package com.example.salim_000.mohamedsalim_reaction;

/**
 * Created by salim_000 on 2015-10-02.
 */
public class fourPlayerStats {
    int fourPlayer = 0;

    public fourPlayerStats(int fourPlayer) {
        this.fourPlayer = fourPlayer;
    }

    public fourPlayerStats() {
    }

    public int getFourPlayer() {
        return fourPlayer;
    }

    public void setFourPlayer(int fourPlayer) {
        this.fourPlayer = fourPlayer;
    }

    public void addCountFour() {
        setFourPlayer(getFourPlayer() + 1);
    }
}
