package com.example.salim_000.mohamedsalim_reaction;

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

    public void setStatus(int stat1, int stat2, int stat3, int stat4) {
        //need to update stats from save file, may implement arrays
    }

    public void saveStatus(){
        //figure out how to save status of players to file
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
}
