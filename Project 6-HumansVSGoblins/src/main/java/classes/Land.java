package classes;


import exceptions.InvalidMoveException;
import exceptions.InvalidResponseException;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Land {
    private int acrossLength;
    private int verticalLength;
    private ArrayList<ArrayList<String>> XYCoordinates;

    public Land(int acrossLength, int verticalLength)
    {
        this.acrossLength = acrossLength;
        this.verticalLength = verticalLength;
        this.XYCoordinates= new ArrayList<>(acrossLength);
        for(int i=0;i<acrossLength;i++)
        {
            ArrayList<String> listToAdd= new ArrayList<>();

            for(int j=0;j<verticalLength;j++)
            {
                listToAdd.add("[]");
            }
            this.XYCoordinates.add(listToAdd);
        }

    }


public void printLand()
{
    for(ArrayList<String> lineToPrint:XYCoordinates)
    {
        System.out.println(lineToPrint);
    }
}

    public Land()
    {

    }

    public int getAcrossLength() {
        return acrossLength;
    }

    public void setAcrossLength(int acrossLength) {
        this.acrossLength = acrossLength;
    }

    public int getVerticalLength() {
        return verticalLength;
    }

    public void setVerticalLength(int verticalLength) {
        this.verticalLength = verticalLength;
    }

    public ArrayList<ArrayList<String>> getXYCoordinates() {
        return XYCoordinates;
    }

    public void setXYCoordinates(ArrayList<ArrayList<String>> XYCoordinates) {
        this.XYCoordinates = XYCoordinates;
    }

    public void playGame(Human player,Land playBoard,Goblin goblin) throws InvalidMoveException, InvalidResponseException {
        Scanner response = new Scanner(System.in);
        String currentAnswer;
        System.out.println("let's slay some goblins (hopefully!)");
        playBoard.printLand();

        while(true)
        {
            System.out.println("enter a direction: "+Human.getApprovedMoves());
            try
            {
                currentAnswer = response.nextLine().toLowerCase(Locale.ROOT);
            }
            catch (Exception e)
            {
                e.printStackTrace();
                break;
            }
            player.makeMove(currentAnswer,playBoard);
            //player is alive due to goblin slaying
            if(player.isSlayedGoblin())
            {
                playBoard.printLand();
                player.setSlayedGoblin(false);
                System.out.println("You slayed a goblin! Your total goblins slain is now: "+player.getGoblinsSlain());
                goblin.spawnGoblin(playBoard, player.getxCoordinate(), player.getyCoordinate());
                System.out.println("let's see if you can do that again");
                playBoard.printLand();
            }
            //player is alive because space was empty
            else if(player.isAlive())
            {
                playBoard.printLand();
                System.out.println("your adventures continue for now");
            }
            else
            {
                playBoard.printLand();
                System.out.println("The goblin managed to beat you! your adventure is over with a score of: "+player.getGoblinsSlain());
                System.out.println("would you like to play again?(y or n)");
                try
                {
                    currentAnswer = (response.nextLine().toLowerCase());
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                    break;
                }
                if (!currentAnswer.equals("y") && !currentAnswer.equals("n"))
                {
                    throw new InvalidResponseException("not a valid response! next time please type 'y' or 'n'");
                }
                if (currentAnswer.equals("n"))
                {
                    break;
                }
                else
                {
                    player.setxCoordinate(1);
                    player.setyCoordinate(1);
                    player.setGoblinsSlain(0);
                    player.setAlive(true);
                    player.spawnHuman(playBoard);
                    playBoard.printLand();
                }
            }
        }
    }



    @Override
    public String toString() {
        return "Land{" +
                "acrossLength=" + acrossLength +
                ", verticalLength=" + verticalLength +
                ", XYCoordinates=" + XYCoordinates +
                '}';
    }
}
