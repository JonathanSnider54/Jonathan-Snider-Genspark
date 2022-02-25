package Main;


import exceptions.InvalidResponseException;
import exceptions.NotAcceptableAnswerException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static exceptions.NotAcceptableAnswerException.NotAcceptableAnswerReason;

public class HangManStreamAndFile {
    public static void main(String[] args) throws NotAcceptableAnswerException, InvalidResponseException, IOException {

        String wordToGuess = "leaner";
        Scanner response = new Scanner(System.in);
        List<Character> lettersInWord = wordToGuess.chars().mapToObj(n -> (char) n).collect(Collectors.toList());
        List<Character> lettersAndEmptySpaces = new ArrayList<Character>(Collections.nCopies(lettersInWord.size(), '_'));

        List<Character> IncorrectLetters = new ArrayList<Character>();
        System.out.println(lettersInWord);
        System.out.println(lettersAndEmptySpaces);
        String currentAnswer = "";
        String playerName = "";
        int currentBadGuessCount = 0;
        List<List<String>> hangmanPictures = getHangmanFile("src/main/resources/hangManPictures.txt");
        System.out.println("H A N G M A N (guess letters and try to find out my " + wordToGuess.length() + " letter word)");
        System.out.println("Your score will be how many letters your word is plus how well you guessed letters (7 minus how many bad guesses you made)");
        System.out.println("Please enter your name for the High Score Screen: ");
        try {
            playerName = response.nextLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (playerName.isBlank()) {
            throw new InvalidResponseException("don't leave that blank!");
        }
        hangmanPictures.get(currentBadGuessCount).stream().forEach(line -> System.out.println(line));
        System.out.println("Missed Letters: ");
        letterPrinter(IncorrectLetters);
        letterPrinter(lettersAndEmptySpaces);

        while (true) {
            System.out.println("Guess a letter");
            try {
                currentAnswer = response.nextLine().toLowerCase(Locale.ROOT);

            } catch (Exception e) {
                e.printStackTrace();
                response.close();
                break;
            }
            if (!currentAnswer.matches("[a-zA-Z]+") || currentAnswer.length() > 1) {
                throw new NotAcceptableAnswerException(NotAcceptableAnswerReason(currentAnswer));
            }
            //checking if letter has already been guessed in either the correct guesses made so far or the incorrect letters
            char charAnswer = currentAnswer.charAt(0);
            if (lettersAndEmptySpaces.contains(charAnswer) || IncorrectLetters.contains(charAnswer)) {
                System.out.println("You already guessed that letter!");
                continue;
            }
            if (lettersInWord.contains(charAnswer)) {


                List<Character> finalLettersInWord = lettersInWord;
                lettersInWord = lettersInWord.stream().map(
                        charToCheck -> {
                            if (charToCheck == charAnswer) {
                                lettersAndEmptySpaces.set(finalLettersInWord.indexOf(charToCheck), charAnswer);
                                finalLettersInWord.set(finalLettersInWord.indexOf(charToCheck), '_');
                                return '_';
                            } else {
                                return charToCheck;
                            }


                        }).collect(Collectors.toList());


                //checking if all letters have been guessed
                if (!lettersAndEmptySpaces.contains('_')) {
                    System.out.println("congratulations! you guessed my word " + wordToGuess + ". would you like to play again?(y or n)");

                    try {
                        currentAnswer = (response.nextLine().toLowerCase());
                    } catch (Exception e) {
                        e.printStackTrace();
                        break;
                    } finally {
                        response.close();
                    }
                    if (!currentAnswer.equals("y") && !currentAnswer.equals("n")) {
                        throw new InvalidResponseException("not a valid response! next time please type 'y' or 'n'");
                    }
                    if (currentAnswer.equals("n")) {
                        highScoreReader(7-currentBadGuessCount, wordToGuess.length(), playerName);
                        break;
                    } else {
                        IncorrectLetters.clear();
                        lettersInWord = wordToGuess.chars().mapToObj(n -> (char) n).collect(Collectors.toList());
                        for (int i = 0; i < lettersAndEmptySpaces.size(); i++) {

                            lettersAndEmptySpaces.set(i, '_');
                        }
                        currentBadGuessCount = 0;
                    }
                }
                //printing out current game situation
                hangmanPictures.get(currentBadGuessCount).stream().forEach(line -> System.out.println(line));
                System.out.println("Missed Letters: ");
                letterPrinter(IncorrectLetters);
                letterPrinter(lettersAndEmptySpaces);
            } else {
                currentBadGuessCount++;
                hangmanPictures.get(currentBadGuessCount).stream().forEach(line -> System.out.println(line));
                //did the player run out of guesses?
                if (currentBadGuessCount == 7) {
                    System.out.println("sorry but it looks like you lose, would you like to play again?(y or n)");

                    try {
                        currentAnswer = (response.nextLine().toLowerCase());
                    } catch (Exception e) {
                        e.printStackTrace();
                        break;
                    } finally {
                        response.close();
                    }
                    if (!currentAnswer.equals("y") && !currentAnswer.equals("n")) {
                        throw new InvalidResponseException("not a valid response! next time please type 'y' or 'n'");
                    }
                    if (currentAnswer.equals("n")) {

                        break;
                    } else {
                        IncorrectLetters.clear();
                        lettersInWord = wordToGuess.chars().mapToObj(n -> (char) n).collect(Collectors.toList());
                        Collections.fill(lettersAndEmptySpaces, '_');
                        currentBadGuessCount = 0;
                    }
                } else {
                    IncorrectLetters.add(charAnswer);
                    System.out.println("Missed Letters: ");
                    letterPrinter(IncorrectLetters);
                    letterPrinter(lettersAndEmptySpaces);
                }
            }
        }


    }


    public static void highScoreReader(int badGuessesDifference, int wordLength, String name) throws IOException {
        Stream<String> fileStream = null;
        int playerScore=badGuessesDifference+wordLength;
        int currentHighestScore=0;
        List<Integer> listOfScores = new ArrayList<>();
        List<String> listOfPlayers=new ArrayList<>();


        try
        {

            fileStream = Files.lines(Paths.get("src/main/resources/highScores.txt"));
            //list of lists, each inner list has a name at spot 0 and a score at spot 1
            listOfPlayers= fileStream.collect(Collectors.toList());
            listOfScores=listOfPlayers.stream().mapToInt(line -> Integer.parseInt(Arrays.asList(line.split(",")).get(1))).boxed().collect(Collectors.toList());
            Collections.sort(listOfScores);
            System.out.println(listOfPlayers);
            System.out.println(listOfScores);
            System.out.println("player score:"+playerScore);

        } catch (IOException e)
        {
            e.printStackTrace();
        } finally
        {
            fileStream.close();
        }

        if(playerScore>listOfScores.get(listOfScores.size()-1)) {
            System.out.println("Congratulations! you got the new high score.");
            FileWriter fileWriter = new FileWriter("src/main/resources/highScores.txt");
            fileWriter.write(name+","+playerScore);
            fileWriter.write("\n");
            listOfPlayers.stream().forEach(line-> {
                try {
                    fileWriter.write(line);
                    fileWriter.write("\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            fileWriter.close();
        }
        else
        {
            FileWriter fileWriter = new FileWriter("src/main/resources/highScores.txt");
            System.out.println("Unfortunately, your score didn't beat the high score.");
            listOfPlayers.stream().forEach(line-> {
                try {
                    fileWriter.write(line);
                    fileWriter.write("\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            fileWriter.write(name+","+playerScore);
            fileWriter.write("\n");
            fileWriter.close();
        }







    }

    public static List<List<String>> getHangmanFile(String filenameToGet) {
        Stream<String> fileStream = null;
        List<List<String>> listOfPictures = new ArrayList<>();
        try {
            AtomicInteger currentList = new AtomicInteger(-1);
            fileStream = Files.lines(Paths.get(filenameToGet));
            fileStream.forEach(
                    line -> {
                        if (line.matches("[0-9]")) {
                            listOfPictures.add(new ArrayList<>());
                            currentList.getAndIncrement();
                        } else {
                            listOfPictures.get(currentList.get()).add(line);
                        }
                    }
            );

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fileStream.close();
        }
        return listOfPictures;
    }

    public static void letterPrinter(List<Character> charactersToPrint) {

        charactersToPrint.stream().forEach(charToPrint -> System.out.print(charToPrint));
        System.out.println("");
    }
}


