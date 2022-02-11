package classes;

import exceptions.IncorrectNumberException;

import java.util.Scanner;

public class DragonCave {
    public int answer = -1;

    @Override
    public String toString() {
        return "DragonCave{" +
                "answer=" + answer +
                ", death=" + death +
                '}';
    }

    public boolean death=false;
    public void beginAdventure(Scanner adventurer) throws IncorrectNumberException {

        System.out.println("You are in a land full of dragons. In front of you," + "\n"
                + "you see two caves. In one cave, the dragon is friendly" + "\n"
                + "and will share his treasure with you. The other dragon" + "\n"
                + "is greedy and hungry and will eat you on sight." + "\n"
                + "Which cave will you go into? (1 or 2)");
        try {
            answer = Integer.parseInt(adventurer.nextLine());

        } catch (NumberFormatException e) {

            adventurer.close();
            System.out.println("THAT WAS NOT A NUMBER");
            e.printStackTrace();
        }
        adventurer.close();
        endAdventure(answer);
    }

    public void endAdventure(int pathTaken) throws IncorrectNumberException {

        if (pathTaken != 1 && pathTaken != 2) {
            throw new IncorrectNumberException("not a valid number!");
        }

        if (pathTaken== 1)
        {
            System.out.println("You approach the cave..." + "\n"
                    + "It is dark and spooky..." + "\n"
                    + "A large dragon jumps out in front of you! He opens his jaws and..." + "\n"
                    + "Gobbles you down in one bite!");
        }
        else
        {
            death=true;
            System.out.println("You approach the cave..." + "\n"
                    + "It is dark and spooky..." + "\n"
                    + "A large dragon jumps out in front of you! He opens his hands and..." + "\n"
                    + "Showers you with gold!");
        }
    }
}

