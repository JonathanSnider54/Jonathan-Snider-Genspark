package main;

import exceptions.InvalidResponseException;
import exceptions.NotAcceptableAnswerException;

import java.util.*;
import java.util.stream.Collectors;

import static exceptions.NotAcceptableAnswerException.NotAcceptableAnswerReason;

public class Hangman {
    public static void main(String args[]) throws InvalidResponseException {
        String wordToGuess="fatter";
        Scanner response = new Scanner(System.in);
        List<Character> lettersInWord= wordToGuess.chars().mapToObj(n -> (char)n).collect(Collectors.toList());
        List<Character> lettersAndEmptySpaces = new ArrayList<Character>(Collections.nCopies(lettersInWord.size(), '_'));
        List<Character> IncorrectLetters=new ArrayList<Character>();
        System.out.println(lettersInWord);
        System.out.println(lettersAndEmptySpaces);
        String currentAnswer="";
        int currentBadGuessCount=0;
        boolean stillPlaying=true;

        System.out.println("H A N G M A N (guess letters and try to find out my "+wordToGuess.length()+" letter word)");
        hangManCounter(currentBadGuessCount);
        System.out.println("Missed Letters: ");
        letterPrinter(IncorrectLetters);
        letterPrinter(lettersAndEmptySpaces);


while(true)
{
    System.out.println("Guess a letter");
    try
    {
        currentAnswer = response.nextLine().toLowerCase(Locale.ROOT);
        if (!currentAnswer.matches("[a-zA-Z]+") || currentAnswer.length() > 1)
        {
            NotAcceptableAnswerReason(currentAnswer);
        }
    }
    catch (Exception e)
    {
        e.printStackTrace();
    }
    //checking if letter has already been guessed in either the correct guesses made so far or the incorrect letters
    char charAnswer=currentAnswer.charAt(0);
    if(lettersAndEmptySpaces.contains(charAnswer)|| IncorrectLetters.contains(charAnswer))
    {
        System.out.println("You already guessed that letter!");
        continue;
    }
    if (lettersInWord.contains(charAnswer))
    {
        //iterating through word to find all instances of the letter
        for(int i=0; i<lettersInWord.size();i++)
        {
            if (charAnswer==lettersInWord.get(i))
            {
                //replacing empty spaces in the displayed 'letters and empty spaces' list
                lettersAndEmptySpaces.set(i,lettersInWord.get(i));
                lettersInWord.set(i,'_');
            }

        }
        //checking if all letters have been guessed
        if(!lettersAndEmptySpaces.contains('_'))
        {
            System.out.println("congratulations! you guessed my word "+wordToGuess+". would you like to play again?(y or n)");

            try
            {
                currentAnswer = (response.nextLine().toLowerCase());
            }
            catch (Exception e)
            {
                System.out.println();
                e.printStackTrace();
            }
            if (!currentAnswer.equals("y") && !currentAnswer.equals("n"))
            {
                throw new InvalidResponseException("not a valid response! next time please type 'y' or 'n'");
            }
            if (currentAnswer.equals("n"))
            {
                //stillPlaying = false;
                break;
            }
            else
            {
                IncorrectLetters.clear();
                lettersInWord= wordToGuess.chars().mapToObj(n -> (char)n).collect(Collectors.toList());
                for(int i=0;i<lettersAndEmptySpaces.size();i++)
                {
                    lettersAndEmptySpaces.set(i,'_');
                }
                currentBadGuessCount = 0;
            }
        }
        //printing out current game situation
        hangManCounter(currentBadGuessCount);
        System.out.println("Missed Letters: ");
        letterPrinter(IncorrectLetters);
        letterPrinter(lettersAndEmptySpaces);
    }
    else
    {
        currentBadGuessCount++;
        hangManCounter(currentBadGuessCount);
        //did the player run out of guesses?
        if(currentBadGuessCount==7)
        {
            System.out.println("sorry but it looks like you lose, would you like to play again?(y or n)");

            try
            {
                currentAnswer = (response.nextLine().toLowerCase());
            }
            catch (Exception e)
            {
                System.out.println();
                e.printStackTrace();
            }
            if (!currentAnswer.equals("y") && !currentAnswer.equals("n"))
            {
                throw new InvalidResponseException("not a valid response! next time please type 'y' or 'n'");
            }
            if (currentAnswer.equals("n"))
            {
                //stillPlaying = false;
                break;
            }
            else
            {
                IncorrectLetters.clear();
                lettersInWord= wordToGuess.chars().mapToObj(n -> (char)n).collect(Collectors.toList());
                for(int i=0;i<lettersAndEmptySpaces.size();i++)
                {
                    lettersAndEmptySpaces.set(i,'_');
                }
                currentBadGuessCount = 0;
            }
        }
        else
        {
            IncorrectLetters.add(charAnswer);
            System.out.println("Missed Letters: ");
            letterPrinter(IncorrectLetters);
            letterPrinter(lettersAndEmptySpaces);
        }
    }
}
    }




    public static void hangManCounter(int badGuessCount)
    {
        switch (badGuessCount) {
            case 0:
                System.out.println("+--+");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("  ===");
                break;
            case 1:
                System.out.println("+--+");
                System.out.println("O   |");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("  ===");
                break;
            case 2:
                System.out.println("+--+");
                System.out.println("O   |");
                System.out.println("|   |");
                System.out.println("   |");
                System.out.println("  ===");
                break;
            case 3:
                System.out.println("+--+");
                System.out.println("O   |");
                System.out.println("|   |");
                System.out.println("|   |");
                System.out.println("  ===");
                break;
            case 4:
                System.out.println("+--+");
                System.out.println("O   |");
                System.out.println("/|   |");
                System.out.println("|   |");
                System.out.println("  ===");
                break;
            case 5:
                System.out.println("+--+");
                System.out.println("O   |");
                System.out.println("/|\\  |");
                System.out.println("|   |");
                System.out.println("  ===");
                break;
            case 6:
                System.out.println("+--+");
                System.out.println("O   |");
                System.out.println("/|\\  |");
                System.out.println("|   |");
                System.out.println("/  ===");
                break;
            case 7:
                System.out.println("+--+");
                System.out.println("O   |");
                System.out.println("/|\\  |");
                System.out.println("|   |");
                System.out.println("/\\  ===");
                break;
        }
    }

    public static void letterPrinter(List<Character> charactersToPrint)
    {
        for(char charToPrint: charactersToPrint)
        {
            System.out.print(charToPrint);
        }
        System.out.println("");
    }
}
