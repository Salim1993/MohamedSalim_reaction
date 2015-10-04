package com.example.salim_000.mohamedsalim_reaction;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by salim_000 on 2015-10-02.
 */
public class reactionManager {
    private ArrayList<Integer> reactionList = new ArrayList<>();

    public reactionManager(ArrayList<Integer> reactionList) {
        this.reactionList = reactionList;
    }

    public reactionManager() {
    }

    void addTime(Integer time){
        reactionList.add(time);
    }

    Integer calculateTime(Date date1, Date date2){
        Integer result = (int) (date1.getTime() - date2.getTime());
        return result;
    }

    Integer getMedian (){
        int size = reactionList.size();
        int mode = size/2; // might need to check if integer rounds up or down.
        return reactionList.get(mode);
    }

    Integer getMean() {
        //need to implememnt for each loop, then calc average.
        return 1;
    }

    Integer getMax (){
        //for each loop to calculate the highest value.
        return 1;
    }

    Integer getMin() {
        return 1;
    }
}
