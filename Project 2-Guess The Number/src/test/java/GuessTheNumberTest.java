import exceptions.IncorrectNumberException;
import exceptions.InvalidResponseException;
import main.Main;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GuessTheNumberTest {
    public void testDragonCaveBadPath() throws Throwable {
        String userInput = String.format("Jonathan%sVega%sdanvega@gmail.com",
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
        String expected = "hey";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);
        Main.main(null);
        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[lines.length-1];
        assertEquals(expected,actual);
    }
    @Test
    public void testGuessTheNumberBlankNumber() throws Throwable
    {
        String userInput = String.format("",
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);
        String[] lines = baos.toString().split(System.lineSeparator());
        Exception exception = assertThrows(InvalidResponseException.class, () -> Main.main(null));
        assertEquals("don't leave that blank!", exception.getMessage());
    }
}
