package classes;



import javax.swing.*;
import java.util.ArrayList;

public class Land {
    private int acrossLength;
    private int verticalLength;
    private ArrayList<ArrayList<String>> XYCoordinates;
    private JFrame playFrame;

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

    public JFrame getPlayFrame() {
        return playFrame;
    }

    public void setPlayFrame(JFrame playFrame) {
        this.playFrame = playFrame;
    }









}


