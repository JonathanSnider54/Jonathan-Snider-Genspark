package main;

import exceptions.IncorrectNumberException;
import exceptions.InvalidResponseException;

import java.util.Locale;
import java.util.Scanner;
import java.util.Random;
public class Main {


    public static void main(String[] args) throws IncorrectNumberException, InvalidResponseException {

        Scanner response = new Scanner(System.in);
        int min=1;
        int max=20;
        int randomAnswer;
        int guessesSoFar=0;
        int guessedNumber=-1;
        String playerName="";
        String continueAnswer="";
        boolean stillPlaying=true;
        Random random = new Random();
        System.out.println("Hello! what is your name?");
        try
        {
            playerName = response.nextLine();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        if(playerName.isBlank())
        {
            throw new InvalidResponseException("don't leave that blank!");
        }
        System.out.println("Well, "+playerName+", I am thinking of a number between 1 and 20");

        while(stillPlaying==true)
        {

            randomAnswer=random.nextInt(max - min) + min;
            System.out.println("The number is "+randomAnswer+" (but don't let them know that!)");

            while(guessedNumber!=randomAnswer)
            {
                if(guessesSoFar>=6)
                {
                    System.out.println("unfortunately, you took too many guesses, so you lose");
                    break;
                }
                System.out.println("Take a guess.");
                try
                {
                    guessedNumber = Integer.parseInt(response.nextLine());
                }
                catch(NumberFormatException e)
                {

                    System.out.println("THAT WAS NOT A NUMBER");
                    e.printStackTrace();
                }
                if(guessedNumber <0 || guessedNumber >20)
                {
                    throw new IncorrectNumberException("not a valid number!");
                }
                if (guessedNumber < randomAnswer)
                {
                    guessesSoFar++;
                    System.out.println("Your guess is too low.");

                }
                else if(guessedNumber > randomAnswer)
                {
                    guessesSoFar++;
                    System.out.println("Your guess is too high.");

                }
                else
                {
                    guessesSoFar++;
                    System.out.println("You guessed my number in "+guessesSoFar+" guess(es)!");
                }
            }
            System.out.println("would you like to play again? (y or n)");
            try
            {
                continueAnswer = (response.nextLine().toLowerCase());
            }
            catch(Exception e)
            {
                System.out.println();
                e.printStackTrace();
            }
            if(!continueAnswer.equals("y") && !continueAnswer.equals("n"))
            {
                throw new InvalidResponseException("not a valid response! next time please type 'y' or 'n'");
            }
            if(continueAnswer.equals("n"))
            {
                stillPlaying=false;
                break;
            }
            else
            {
                guessesSoFar=0;
            }



        }

    }
}