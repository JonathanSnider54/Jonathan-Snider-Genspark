import classes.Goblin;
import classes.Human;
import classes.JFrameController;
import classes.Land;
import exceptions.InvalidMoveException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.awt.*;
import java.awt.event.InputEvent;

import static org.junit.jupiter.api.Assertions.*;

public class HumansVSGoblinsTest {

    public Human testPlayer;
    public Land testLand;
    public Goblin testGoblin;
    public JFrameController testController;
    @BeforeEach
    void createTestObjects() {
       testPlayer=new Human();
       testLand=new Land(3,3);
       testGoblin=new Goblin(0,1);
       testController=new JFrameController(testLand,testPlayer,testGoblin);
    }

    @Test
    public void HumanMoveTest() throws AWTException {

        Robot bot = new Robot();
        testController.createGUI();
        testPlayer.setxCoordinate(1);
        testPlayer.setyCoordinate(1);
        testPlayer.spawnHuman(testLand);
        bot.mouseMove(350,800);
        try {Thread.sleep(250);} catch (InterruptedException ex) {}
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(250);}catch(InterruptedException e){}
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        assertEquals(testPlayer.getxCoordinate(),1);
        assertEquals(testPlayer.getyCoordinate(),0);
        assertEquals(testLand.getXYCoordinates().get(0).get(1),Human.getTokenRep());
    }
    @Test
    public void FightGoblinTest() throws AWTException {
        Robot bot = new Robot();
        testController.createGUI();
        testPlayer.setxCoordinate(1);
        testPlayer.setyCoordinate(1);
        testPlayer.spawnHuman(testLand);
        testGoblin.spawnGoblin(testLand);
        bot.mouseMove(350,800);
        try {Thread.sleep(250);}catch (InterruptedException ex) {}
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        try{Thread.sleep(250);}catch(InterruptedException e){}
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        assertEquals(testPlayer.getxCoordinate(),1);
        assertEquals(testPlayer.getyCoordinate(),0);
        assertTrue(testPlayer.getGoblinsSlain()==1 || !testPlayer.isAlive());
    }
}
