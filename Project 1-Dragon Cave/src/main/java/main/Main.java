package main;

import classes.DragonCave;
import exceptions.IncorrectNumberException;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IncorrectNumberException {

        DragonCave dg=new DragonCave();
        Scanner response = new Scanner(System.in);
        dg.beginAdventure(response);
    }
}
