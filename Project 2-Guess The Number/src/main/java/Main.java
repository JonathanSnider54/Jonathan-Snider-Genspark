import java.util.Scanner;
import java.util.Random;
public class Main {


    public static void main(String[] args) {

        Scanner response = new Scanner(System.in);
        int min=1;
        int max=20;
        int randomAnswer;
        int guessesSoFar=0;
        int guessedNumber=-1;
        boolean stillPlaying=true;
        Random random = new Random();
        System.out.println("Hello! what is your name?");
        String playerName=response.nextLine();
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
                guessedNumber =Integer.parseInt(response.nextLine());
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
            if(response.nextLine().equals("n"))
            {
                break;
            }
            else
            {
                guessesSoFar=0;
            }



        }

    }
}