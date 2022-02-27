package main;

import classes.Goblin;
import classes.Human;
import classes.JFrameController;
import classes.Land;
import exceptions.InvalidMoveException;
import exceptions.InvalidResponseException;

public class HumansVSGoblins {
    public static void main(String args[]) {


        //initializing game board

        Human player=new Human(1,1,0);
        Land playLand=new Land(3,3);
        player.spawnHuman(playLand);
        Goblin goblin=new Goblin();
        goblin.spawnGoblin(playLand, player.getxCoordinate(), player.getyCoordinate());
        //playing game
        JFrameController controller=new JFrameController(playLand, player, goblin);
        controller.createGUI();





    }
}
