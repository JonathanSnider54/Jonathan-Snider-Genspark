import classes.Goblin;
import classes.Human;
import classes.Land;
import exceptions.InvalidMoveException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HumansVSGoblinsTest {

    public Human testPlayer;
    public Land testLand;
    public Goblin testGoblin;
    @BeforeEach
    void createTestObjects() {
       testPlayer=new Human();
       testLand=new Land(3,3);
       testGoblin=new Goblin(0,1);
    }
    @Test
    public void HumanInvalidMoveTest()
    {
        Exception exception = assertThrows(InvalidMoveException.class, () -> testPlayer.makeMove("z",testLand));
        assertEquals("invalid move: you did not enter a proper movement command (z), the approved commands are as follows: "+ Human.getApprovedMoves(), exception.getMessage());
    }
    @Test
    public void HumanMoveTest() throws InvalidMoveException
    {
        testPlayer.setxCoordinate(1);
        testPlayer.setyCoordinate(1);
        testPlayer.spawnHuman(testLand);
        testPlayer.makeMove("n",testLand);
        assertEquals(testPlayer.getxCoordinate(),1);
        assertEquals(testPlayer.getyCoordinate(),0);
        assertEquals(testLand.getXYCoordinates().get(0).get(1),Human.getTokenRep());
    }
    @Test
    public void FightGoblinTest() throws InvalidMoveException {
        testPlayer.setxCoordinate(1);
        testPlayer.setyCoordinate(1);
        testPlayer.spawnHuman(testLand);
        testGoblin.spawnGoblin(testLand);
        testPlayer.makeMove("n",testLand);
        System.out.println(testPlayer.isAlive());
        System.out.println(testPlayer.getGoblinsSlain());
        //was the goblin slain or did the player die?
        assertTrue(testPlayer.getGoblinsSlain()==1 || !testPlayer.isAlive());
    }
}
