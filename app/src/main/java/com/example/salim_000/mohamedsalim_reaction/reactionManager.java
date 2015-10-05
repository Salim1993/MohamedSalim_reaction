package com.example.salim_000.mohamedsalim_reaction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

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

    public ArrayList<Integer> getReactionList() {
        return reactionList;
    }

    public void setReactionList(ArrayList<Integer> reactionList) {
        this.reactionList = reactionList;
    }

    void addTime(Integer time){
        reactionList.add(time);
    }

    Integer calculateTime(Date date1, Date date2){
        Integer result = (int) (date1.getTime() - date2.getTime());
        return result;
    }

    Integer getMedian100(){
        if(reactionList.size() == 0){return 0;}
        int size = reactionList.size();
        Collections.sort(reactionList);
        int mode = size/2; // might need to check if integer rounds up or down.
        return reactionList.get(mode);
    }

    int getMean100() {
        if(reactionList.size() == 0){return 0;}
        Integer sum = 0;
        if(!reactionList.isEmpty()) {
            for (Integer reaction : reactionList) {
                sum += reaction;
            }
            return (int) (sum.doubleValue() / reactionList.size());
        }
        return sum;
    }

    Integer getMax100(){
        //for each loop to calculate the highest value.
        if(reactionList.size() == 0){return 0;}
        return Collections.max(reactionList);
    }

    Integer getMin100() {
        if(reactionList.size() == 0){return 0;}
        return Collections.min(reactionList);
    }

    Integer getMedian10(){
        if(reactionList.size() == 0){return 0;}
        if (reactionList.size() < 10){
            int size = reactionList.size();
            Collections.sort(reactionList);
            int mode = size/2; // might need to check if integer rounds up or down.
            return reactionList.get(mode);
        }else {
            ArrayList<Integer> smallReactionList = (ArrayList) reactionList.subList(0, 10);
            int size = smallReactionList.size();
            Collections.sort(smallReactionList);
            int mode = size / 2; // might need to check if integer rounds up or down.
            return smallReactionList.get(mode);
        }
    }

    int getMean10() {
        if(reactionList.size() == 0){return 0;}
        if (reactionList.size() < 10){
            List<Integer> smallReactionList =  reactionList.subList(0, 10);
            int size = smallReactionList.size();
            Collections.sort(smallReactionList);
            int mode = size/2; // might need to check if integer rounds up or down.
            return smallReactionList.get(mode);
        }else {
            List<Integer> smallReactionList =  reactionList.subList(0, 10);
            Integer sum = 0;
            if (!smallReactionList.isEmpty()) {
                for (Integer reaction : smallReactionList) {
                    sum += reaction;
                }
                return (int) (sum.doubleValue() / smallReactionList.size());
            }
            return sum;
        }
    }

    Integer getMax10(){
        if(reactionList.size() == 0){return 0;}
        //for each loop to calculate the highest value.
        if(reactionList.size() < 10){
            return Collections.max(reactionList);
        }else {
            List<Integer> smallReactionList = reactionList.subList(0, 10);
            return Collections.max(smallReactionList);
        }
    }

    Integer getMin10() {
        if(reactionList.size() == 0){return 0;}
        if(reactionList.size() < 10){
            return Collections.min(reactionList);
        }else {
            List<Integer> smallReactionList = reactionList.subList(0, 10);
            return Collections.min(smallReactionList);
        }
    }
}
