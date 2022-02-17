package classes;






import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


import exceptions.IncorrectNumberException;
import main.DragonCave;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DragonCaveTest{

    @Test
    public void testDragonCaveBadPath() throws Throwable {
        String userInput = String.format("1",
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
        String expected = "You approach the cave... It is dark and spooky... A large dragon jumps out in front of you! He opens his jaws and... Gobbles you down in one bite!";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);
        DragonCave.main(null);
        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[lines.length-1];
        assertEquals(expected,actual);
    }

    @Test
    public void testDragonCaveGoodPath() throws Throwable {
        String userInput = String.format("2",
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
        String expected = "You approach the cave... It is dark and spooky... A large dragon jumps out in front of you! He opens his hands and... Showers you with gold!";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);
        DragonCave.main(null);
        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[lines.length-1];
        assertEquals(expected,actual);
    }
    @Test
    public void testDragonCaveBadNumber() throws Throwable
    {
        String userInput = String.format("3",
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);
        //Main.main(null);
        String[] lines = baos.toString().split(System.lineSeparator());
        Exception exception = assertThrows(IncorrectNumberException.class, () -> DragonCave.main(null));
        assertEquals("not a valid number!", exception.getMessage());
    }


}