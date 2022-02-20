package classes;

import java.util.concurrent.ThreadLocalRandom;

public class Goblin {
    private int xCoordinate;
    private int yCoordinate;
    private static String tokenRep="[G]";

    public void spawnGoblin(Land land,int excludedX,int excludedY)
    {
        int randomAcross=-1;
        int randomVertical=-1;
        while(randomAcross==-1 || (randomAcross==excludedX && randomVertical==excludedY))
        {
            randomAcross = ThreadLocalRandom.current().nextInt(0, land.getAcrossLength());
            randomVertical = ThreadLocalRandom.current().nextInt(0, land.getVerticalLength());
        }
        xCoordinate=randomAcross;
        yCoordinate=randomVertical;
        land.getXYCoordinates().get(xCoordinate).set(yCoordinate, tokenRep);
    }

    //method to confirm a goblin spawn in a certain spot for testing purposes
    public void spawnGoblin(Land land)
    {
        land.getXYCoordinates().get(xCoordinate).set(yCoordinate, tokenRep);
    }

    public Goblin() {

    }

    public Goblin(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
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
        Goblin.tokenRep = tokenRep;
    }

    @Override
    public String toString() {
        return "Goblin{" +
                "xCoordinate=" + xCoordinate +
                ", yCoordinate=" + yCoordinate +
                '}';
    }
}
