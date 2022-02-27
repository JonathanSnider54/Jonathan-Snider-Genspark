package classes;

import exceptions.InvalidMoveException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class JFrameController  implements ActionListener {

    private Land playLand;
    private Human player;
    private Goblin goblin;
    private JFrame gameFrame;
    private JLabel mapLabel;
    private JLabel statusLabel;
    private JLabel goblinsSlayedLabel;
    private ArrayList directionButtons;

    public JFrameController() {
    }

    public JFrameController(Land playLand, Human player, Goblin goblin) {
        this.playLand = playLand;
        this.player = player;
        this.goblin = goblin;
    }

    public String printLandLabel()
    {
        String endString = "<html><body>";
        ArrayList<ArrayList<String>> landToPrint=playLand.getXYCoordinates();
        for(ArrayList<String> lineToPrint:landToPrint)
        {
            endString=endString+lineToPrint+"<br>";
        }
        endString=endString.substring(0, endString.length() - 4);
        endString=endString+"</body></html>";
        return endString;
    }


    public JFrame getGameFrame() {
        return gameFrame;
    }

    public void setGameFrame(JFrame gameFrame) {
        this.gameFrame = gameFrame;
    }

    public JLabel getMapLabel() {
        return mapLabel;
    }

    public void setMapLabel(JLabel mapLabel) {
        this.mapLabel = mapLabel;
    }

    public JLabel getStatusLabel() {
        return statusLabel;
    }

    public void setStatusLabel(JLabel statusLabel) {
        this.statusLabel = statusLabel;
    }

    public JLabel getGoblinsSlayedLabel() {
        return goblinsSlayedLabel;
    }

    public void setGoblinsSlayedLabel(JLabel goblinsSlayedLabel) {
        this.goblinsSlayedLabel = goblinsSlayedLabel;
    }

    public void createGUI()
    {
        directionButtons=new ArrayList<>();
        setGameFrame(new JFrame());
        setMapLabel(new JLabel());
        setStatusLabel(new JLabel());
        setGoblinsSlayedLabel(new JLabel());
        mapLabel.setText(printLandLabel());
        mapLabel.setBounds(300,300, 300,300);
        statusLabel.setText("let's slay some goblins!");
        statusLabel.setBounds(300,200, 400,300);
        goblinsSlayedLabel.setText("goblins slayed:0");
        goblinsSlayedLabel.setBounds(300,50, 100,100);

        JButton north=new JButton("n");
        north.setBounds(300,750,60, 40);

        JButton east=new JButton("e");
        east.setBounds(350,800,60, 40);

        JButton south=new JButton("s");
        south.setBounds(300,850,60, 40);

        JButton west=new JButton("w");
        west.setBounds(250,800,60, 40);

        north.addActionListener(this);
        east.addActionListener(this);
        south.addActionListener(this);
        west.addActionListener(this);
        directionButtons.add(north);
        directionButtons.add(east);
        directionButtons.add(south);
        directionButtons.add(west);
        gameFrame.add(north);
        gameFrame.add(east);
        gameFrame.add(south);
        gameFrame.add(west);
        gameFrame.add(mapLabel);
        gameFrame.add(statusLabel);
        gameFrame.add(goblinsSlayedLabel);
        gameFrame.setSize(1000,1000);
        gameFrame.setLayout(null);
        gameFrame.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {

            JButton buttonHit= (JButton) e.getSource();

            switch (buttonHit.getText())
            {
                case "n":
                    if (player.getyCoordinate() == 0) {
                        try {
                            statusLabel.setText("there is no more room up north!");
                            throw new InvalidMoveException("invalid move: there is no more room up north");
                        } catch (InvalidMoveException ex) {
                            ex.printStackTrace();
                        }
                    }
                    else {
                        //leaving previous space empty
                        playLand.getXYCoordinates().get(player.getyCoordinate()).set(player.getxCoordinate(), "[]");
                        player.setyCoordinate(player.getyCoordinate() - 1);
                        //if the spot to travel to contains a goblin, fight it out
                        if (playLand.getXYCoordinates().get(player.getyCoordinate()).get(player.getxCoordinate()).equals(Goblin.getTokenRep()))
                        {
                            boolean result = player.fightGoblin();
                            //alive from goblin slaying
                            if (result == true)
                            {
                                player.setSlayedGoblin(true);
                                player.setGoblinsSlain(player.getGoblinsSlain() + 1);
                                playLand.getXYCoordinates().get(player.getyCoordinate()).set(player.getxCoordinate(), Human.getTokenRep());
                            }
                            //dead
                            else
                            {

                                player.setAlive(false);
                                playLand.getXYCoordinates().get(player.getyCoordinate()).set(player.getxCoordinate(), Goblin.getTokenRep());
                            }
                        }
                        else
                        {
                            //alive from space being empty
                            playLand.getXYCoordinates().get(player.getyCoordinate()).set(player.getxCoordinate(), Human.getTokenRep());
                        }
                    }
                    break;
                case "e":
                    if (player.getxCoordinate() == playLand.getAcrossLength() - 1)
                    {
                        try {
                            statusLabel.setText("there is no more room up east!");
                            throw new InvalidMoveException("invalid move: there is no more room farther east");
                        } catch (InvalidMoveException ex) {
                            ex.printStackTrace();
                        }
                    }
                    else
                    {
                        //leaving previous space empty
                        playLand.getXYCoordinates().get(player.getyCoordinate()).set(player.getxCoordinate(), "[]");
                        player.setxCoordinate(player.getxCoordinate()+1);
                        if (playLand.getXYCoordinates().get(player.getyCoordinate()).get(player.getxCoordinate()).equals(Goblin.getTokenRep()))
                        {
                            boolean result = player.fightGoblin();
                            //alive from goblin slaying
                            if (result == true)
                            {
                                player.setSlayedGoblin(true);
                                player.setGoblinsSlain(player.getGoblinsSlain() + 1);
                                playLand.getXYCoordinates().get(player.getyCoordinate()).set(player.getxCoordinate(), Human.getTokenRep());
                            }
                            //dead
                            else
                            {

                                player.setAlive(false);
                                playLand.getXYCoordinates().get(player.getyCoordinate()).set(player.getxCoordinate(), Goblin.getTokenRep());
                            }
                        }
                        else
                        {
                            //alive from space being empty
                            playLand.getXYCoordinates().get(player.getyCoordinate()).set(player.getxCoordinate(), Human.getTokenRep());
                        }
                    }
                    break;
                case "s":
                    if (player.getyCoordinate() == playLand.getVerticalLength() - 1) {
                        try {
                            statusLabel.setText("there is no more room down south!");
                            throw new InvalidMoveException("invalid move: there is no more room down south");
                        } catch (InvalidMoveException ex) {
                            ex.printStackTrace();
                        }
                    }
                    else
                    {
                        //leaving previous space empty
                        playLand.getXYCoordinates().get(player.getyCoordinate()).set(player.getxCoordinate(), "[]");
                        player.setyCoordinate(player.getyCoordinate()+1);
                        if (playLand.getXYCoordinates().get(player.getyCoordinate()).get(player.getxCoordinate()).equals(Goblin.getTokenRep()))
                        {
                            boolean result = player.fightGoblin();
                            //alive from goblin slaying
                            if (result == true)
                            {
                                player.setSlayedGoblin(true);
                                player.setGoblinsSlain(player.getGoblinsSlain() + 1);
                                playLand.getXYCoordinates().get(player.getyCoordinate()).set(player.getxCoordinate(), Human.getTokenRep());
                            }
                            //dead
                            else
                            {

                                player.setAlive(false);
                                playLand.getXYCoordinates().get(player.getyCoordinate()).set(player.getxCoordinate(), Goblin.getTokenRep());
                            }
                        }
                        else
                        {
                            //alive from space being empty
                            playLand.getXYCoordinates().get(player.getyCoordinate()).set(player.getxCoordinate(), Human.getTokenRep());
                        }
                    }
                    break;
                case "w":
                    if (player.getxCoordinate() == 0) {
                        try {
                            throw new InvalidMoveException("invalid move: there is no more room farther west");
                        } catch (InvalidMoveException ex) {
                            ex.printStackTrace();
                        }
                    }
                    else
                    {
                        //leaving previous space empty
                        playLand.getXYCoordinates().get(player.getyCoordinate()).set(player.getxCoordinate(), "[]");
                        player.setxCoordinate(player.getxCoordinate()-1);
                        if (playLand.getXYCoordinates().get(player.getyCoordinate()).get(player.getxCoordinate()).equals(Goblin.getTokenRep()))
                        {
                            boolean result = player.fightGoblin();
                            //alive from goblin slaying
                            if (result == true)
                            {
                                player.setSlayedGoblin(true);
                                player.setGoblinsSlain(player.getGoblinsSlain() + 1);
                                playLand.getXYCoordinates().get(player.getyCoordinate()).set(player.getxCoordinate(), Human.getTokenRep());
                            }
                            //dead
                            else
                            {

                                player.setAlive(false);
                                playLand.getXYCoordinates().get(player.getyCoordinate()).set(player.getxCoordinate(), Goblin.getTokenRep());
                            }
                        }
                        else
                        {
                            //alive from space being empty

                            playLand.getXYCoordinates().get(player.getyCoordinate()).set(player.getxCoordinate(), Human.getTokenRep());
                        }
                    }
                    break;
                case "end":
                {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    System.exit(1);
                }
            }
            //END OF SWITCH
        //if player is dead
        if(player.isSlayedGoblin())
        {
            player.setSlayedGoblin(false);
            statusLabel.setText("you've slayed a goblin! See if you can get some more.");
            goblinsSlayedLabel.setText("goblins slayed: "+player.getGoblinsSlain());
            goblin.spawnGoblin(playLand, player.getxCoordinate(), player.getyCoordinate());
            mapLabel.setText(printLandLabel());
        }
        else if(player.isAlive())
        {
            statusLabel.setText("your adventures continue...");
            mapLabel.setText(printLandLabel());
        }
        else
        {

            statusLabel.setText("The goblin managed to beat you! your adventure is over...");
            mapLabel.setText(printLandLabel());
            for(Object buttonToRemove:directionButtons)
            {
                gameFrame.remove((Component) buttonToRemove);
            }

            JButton end=new JButton("end");
            end.addActionListener(this);
            gameFrame.add(end);
            end.setBounds(300,800,60, 40);
            gameFrame.getContentPane().revalidate();
            gameFrame.repaint();
        }

        }
}
