package main;

import classes.Goblin;
import classes.Human;
import classes.Land;
import exceptions.InvalidMoveException;
import exceptions.InvalidResponseException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class HumansVSGoblins {
    public static void main(String args[]) throws InvalidMoveException, InvalidResponseException {


        //initializing game board
        Land playBoard=new Land(3,3);
        Human player=new Human(1,1,0);
        Goblin goblin=new Goblin();
        player.spawnHuman(playBoard);
        goblin.spawnGoblin(playBoard, player.getxCoordinate(), player.getyCoordinate());
        playBoard.playGame(player,playBoard,goblin);




    }
}
