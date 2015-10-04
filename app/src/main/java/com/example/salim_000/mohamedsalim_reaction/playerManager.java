package com.example.salim_000.mohamedsalim_reaction;

import java.util.ArrayList;

/**
 * Created by salim_000 on 2015-10-03.
 */
public class playerManager {
    private twoPlayerStats player1 = new twoPlayerStats();
    private twoPlayerStats player2 = new twoPlayerStats();
    private threePlayerStats player3 = new threePlayerStats();
    private fourPlayerStats player4 = new fourPlayerStats();

    public playerManager() {
    }

    public void setStatus(ArrayList<Integer> countList) {
        if(countList.size() == 9) {
            player1.setAll(countList.get(0), countList.get(1), countList.get(2));
            player2.setAll(countList.get(3), countList.get(4), countList.get(5));
            player3.setAll(countList.get(6), countList.get(7));
            player4.setFourPlayer(countList.get(8));
        } else {
            System.out.println("Size is wrong it is " + countList.size());
        }
    }

    public ArrayList<Integer> getStatus(){
        ArrayList<Integer> getCount = new ArrayList<>();
        getCount.add(player1.getTwoPlayer());
        getCount.add(player1.getThreePlayer());
        getCount.add(player1.getFourPlayer());
        getCount.add(player2.getTwoPlayer());
        getCount.add(player2.getThreePlayer());
        getCount.add(player2.getFourPlayer());
        getCount.add(player3.getThreePlayer());
        getCount.add(player3.getFourPlayer());
        getCount.add(player4.getFourPlayer());
        return getCount;
    }

    public void updatePlayers(int player, int mode) {
        switch(player){
            case 1: switch(mode) {
                case 2:
                    player1.addCountTwo();
                    break;
                case 3:
                    player1.addCountThree();
                    break;
                case 4:
                    player1.addCountFour();
                    break;
                default:
                    break;

            }break;
            case 2: switch (mode){
                case 2:
                    player2.addCountTwo();
                    break;
                case 3:
                    player2.addCountThree();
                    break;
                case 4:
                    player2.addCountFour();
                    break;
                default:
                    break;

            }break;
            case 3: switch (mode){
                case 3:
                    player3.addCountThree();
                    break;
                case 4:
                    player3.addCountFour();
                    break;
                default:
                    break;
            }break;
            case 4: switch (mode){
                case 4:
                    player4.addCountFour();
                    break;
                default:
                    break;
            }break;
            default:break;
        }
    }

    public void clear(){
        player1.clear();
        player2.clear();
        player3.clear();
        player4.clear();
    }
}
