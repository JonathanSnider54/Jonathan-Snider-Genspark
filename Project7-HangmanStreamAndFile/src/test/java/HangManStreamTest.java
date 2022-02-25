import Main.HangManStreamAndFile;
import exceptions.InvalidResponseException;
import exceptions.NotAcceptableAnswerException;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class HangManStreamTest {
    @Test
public void testHangManStreamNotALetter()
    {
        String userInput = String.format("testName%s6",
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);
        String[] lines = baos.toString().split(System.lineSeparator());
        Exception exception = assertThrows(NotAcceptableAnswerException.class, () -> HangManStreamAndFile.main(null));
        assertEquals("this answer was the correct length but the character was a non-letter item", exception.getMessage());
    }
    @Test
    public void testHangManStreamResponseTooLong() throws Throwable
    {
        String userInput = String.format("testName%scat",
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);
        String[] lines = baos.toString().split(System.lineSeparator());
        Exception exception = assertThrows(NotAcceptableAnswerException.class, () -> HangManStreamAndFile.main(null));
        assertEquals("this answer was longer than one character", exception.getMessage());
    }
    @Test
    public void testHangManStreamResponseTooLongAndHasNonLetter() throws Throwable
    {
        String userInput = String.format("testName%s657",
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);
        String[] lines = baos.toString().split(System.lineSeparator());
        Exception exception = assertThrows(NotAcceptableAnswerException.class, () -> HangManStreamAndFile.main(null));
        assertEquals("this answer was longer than one character AND it contains non-letter items", exception.getMessage());
    }

    @Test
    public void testHangManStreamnResponsePlayAgainIncorrect() throws Throwable
    {
        String userInput = String.format("testName%sL%sE%sN%sA%sR%sZ",
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);
        String[] lines = baos.toString().split(System.lineSeparator());
        Exception exception = assertThrows(InvalidResponseException.class, () -> HangManStreamAndFile.main(null));
        assertEquals("not a valid response! next time please type 'y' or 'n'", exception.getMessage());
    }

    @Test
    public void testHangManStreamBlankName() throws Throwable
    {
        String userInput = String.format(" ",
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);
        String[] lines = baos.toString().split(System.lineSeparator());
        Exception exception = assertThrows(InvalidResponseException.class, () -> HangManStreamAndFile.main(null));
        assertEquals("don't leave that blank!", exception.getMessage());
    }

    @Test
    public void highScoreTestNewHighScore() throws IOException {
        String name="testName";
        int testDifference=7;
        int testWordLength=6;
        List<String> testListOfPlayers;
        List<String> newTestListOfPlayers;
        Stream<String> testFileStream = Files.lines(Paths.get("src/main/resources/highScores.txt"));
        testListOfPlayers= testFileStream.collect(Collectors.toList());
        String topScoreString=testListOfPlayers.get(0);
        HangManStreamAndFile.highScoreReader(testDifference,testWordLength,name);
        Stream<String> newTestFileStream = Files.lines(Paths.get("src/main/resources/highScores.txt"));
        newTestListOfPlayers= newTestFileStream.collect(Collectors.toList());
        String newTopScoreString=newTestListOfPlayers.get(0);
        assertFalse(topScoreString.equals(newTopScoreString));
    }
@Test
    public void highScoreTestNoNewHighScore() throws IOException {
        String name="testName";
        int testDifference=1;
        int testWordLength=6;
        List<String> testListOfPlayers;
        List<String> newTestListOfPlayers;
        Stream<String> testFileStream = Files.lines(Paths.get("src/main/resources/highScores.txt"));
        testListOfPlayers= testFileStream.collect(Collectors.toList());
        String topScoreString=testListOfPlayers.get(0);
        HangManStreamAndFile.highScoreReader(testDifference,testWordLength,name);
        Stream<String> newTestFileStream = Files.lines(Paths.get("src/main/resources/highScores.txt"));
        newTestListOfPlayers= newTestFileStream.collect(Collectors.toList());
        String newTopScoreString=newTestListOfPlayers.get(0);
        assertTrue(topScoreString.equals(newTopScoreString));
    }



}
