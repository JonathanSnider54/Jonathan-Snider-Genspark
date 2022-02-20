import exceptions.InvalidResponseException;
import exceptions.NotAcceptableAnswerException;
import main.Hangman;
import org.junit.jupiter.api.Test;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HangmanTest {
    @Test
    public void testHangManNotALetter() throws Throwable
    {
        String userInput = String.format("6",
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);
        String[] lines = baos.toString().split(System.lineSeparator());
        Exception exception = assertThrows(NotAcceptableAnswerException.class, () -> Hangman.main(null));
        assertEquals("this answer was the correct length but the character was a non-letter item", exception.getMessage());
    }
    @Test
    public void testHangManResponseTooLong() throws Throwable
    {
        String userInput = String.format("cat",
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);
        String[] lines = baos.toString().split(System.lineSeparator());
        Exception exception = assertThrows(NotAcceptableAnswerException.class, () -> Hangman.main(null));
        assertEquals("this answer was longer than one character", exception.getMessage());
    }
    @Test
    public void testHangManResponseTooLongAndHasNonLetter() throws Throwable
    {
        String userInput = String.format("657",
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);
        String[] lines = baos.toString().split(System.lineSeparator());
        Exception exception = assertThrows(NotAcceptableAnswerException.class, () -> Hangman.main(null));
        assertEquals("this answer was longer than one character AND it contains non-letter items", exception.getMessage());
    }
    @Test
    public void testHangManResponsePlayAgainIncorrect() throws Throwable
    {
        String userInput = String.format("F%sA%sT%sE%sR%sZ",
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
        Exception exception = assertThrows(InvalidResponseException.class, () -> Hangman.main(null));
        assertEquals("not a valid response! next time please type 'y' or 'n'", exception.getMessage());
    }
}
