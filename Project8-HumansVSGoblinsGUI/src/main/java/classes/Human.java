package classes;




import java.util.ArrayList;
import java.util.List;

public class Human {
    private int xCoordinate;
    private int yCoordinate;
    private int goblinsSlain;
    private static String tokenRep="[H]";
    private static ArrayList<String> approvedMoves= new ArrayList<>(List.of("n","e","s","w"));
    private boolean isAlive=true;
    private boolean slayedGoblin=false;




    public void spawnHuman(Land land)
    {
        land.getXYCoordinates().get(xCoordinate).set(yCoordinate, tokenRep);
    }

    public boolean fightGoblin()
    {
        if (Math.random() > 0.5)
        {
            //beat the goblin!
            return true;
        }
        else
        {
            //lost to the goblin...
            return false;
        }
    }

    public Human() {
    }

    public Human(int xCoordinate, int yCoordinate, int goblinsSlain) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.goblinsSlain = goblinsSlain;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public static String getTokenRep() {
        return tokenRep;
    }

    public static void setTokenRep(String tokenRep) {
        Human.tokenRep = tokenRep;
    }

    public int getGoblinsSlain() {
        return goblinsSlain;
    }

    public void setGoblinsSlain(int goblinsSlain) {
        this.goblinsSlain = goblinsSlain;
    }

    public static ArrayList<String> getApprovedMoves() {
        return approvedMoves;
    }

    public static void setApprovedMoves(ArrayList<String> approvedMoves) {
        Human.approvedMoves = approvedMoves;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public boolean isSlayedGoblin() {
        return slayedGoblin;
    }

    public void setSlayedGoblin(boolean slayedGoblin) {
        this.slayedGoblin = slayedGoblin;
    }

    @Override
    public String toString() {
        return "Human{" +
                "xCoordinate=" + xCoordinate +
                ", yCoordinate=" + yCoordinate +
                ", goblinsSlain=" + goblinsSlain +
                ", isAlive=" + isAlive +
                ", slayedGoblin=" + slayedGoblin +
                '}';
    }
}
