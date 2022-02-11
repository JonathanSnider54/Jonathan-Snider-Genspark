package classes;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DragonCaveTest{
    DragonCave dg;
    Scanner newAdventurer;
    int testInt;
    @BeforeEach
    void Setup()
    {
        testInt=6;
        dg=new DragonCave();
        newAdventurer=new Scanner(System.in);
    }
    @AfterEach
    void TearDown()
    {
        newAdventurer.close();
    }
    @Test
public void testDragonCave() throws Throwable
{System.out.println(testInt);
    System.out.print(dg.toString());
    String input = "1";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
dg.beginAdventure(newAdventurer);


assertEquals(1,dg.answer);
}

}