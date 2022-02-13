package main;


import exceptions.IncorrectNumberException;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IncorrectNumberException {
        int pathTaken=0;
        Scanner scanner=new Scanner(System.in);

        System.out.println("You are in a land full of dragons. In front of you, you see two caves. In one cave, the dragon is friendly and will share his treasure with you. The other dragon is greedy and hungry and will eat you on sight. Which cave will you go into? (1 or 2)");
        try {
            pathTaken = Integer.parseInt(scanner.nextLine());

        } catch (NumberFormatException e) {

            scanner.close();
            System.out.println("THAT WAS NOT A NUMBER");
            e.printStackTrace();
        }


        if (pathTaken != 1 && pathTaken != 2) {
            throw new IncorrectNumberException("not a valid number!");
        }

        if (pathTaken== 1)
        {
            System.out.println("You approach the cave... It is dark and spooky... A large dragon jumps out in front of you! He opens his jaws and... Gobbles you down in one bite!");
        }
        else
        {
            System.out.println("You approach the cave... It is dark and spooky... A large dragon jumps out in front of you! He opens his hands and... Showers you with gold!");
        }
    }
}
