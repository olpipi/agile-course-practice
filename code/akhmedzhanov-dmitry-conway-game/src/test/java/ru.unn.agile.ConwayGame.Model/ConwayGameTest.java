package ru.unn.agile.ConwayGame.Model;

import org.junit.Test;
import static org.junit.Assert.*;

public class ConwayGameTest {

    @Test
    public void canCreateGameInstance() {
        ConwayGame game = new ConwayGame(4, 8);

        assertNotNull(game);
    }

    @Test
    public void canGetRowsNumber() {
        ConwayGame game = new ConwayGame(7, 4);

        assertEquals(7, game.getPlaygroundRowsNumber());
    }

    @Test
    public void canGetColumnsNumber() {
        ConwayGame game = new ConwayGame(3, 5);

        assertEquals(5, game.getPlaygroundColumnsNumber());
    }

    @Test
    public void canGetGivenGeneration() {
        ConwayGame game = new ConwayGame(2, 3);

        game.readGeneration("..**..");

        assertEquals("..*\n*..\n", game.getCurrentGeneration());
    }

    @Test
    public void canWorkWithIncorrectInput() {
        ConwayGame game = new ConwayGame(-2, 3);

        assertEquals(2, game.getPlaygroundRowsNumber());
    }

    @Test
    public void canGetNextGeneration() {
        ConwayGame game = new ConwayGame(4, 8);

        game.readGeneration("............*......**...........");
        game.moveToNextGeneration();

        assertEquals("........\n...**...\n...**...\n........\n", game.getNextGeneration());
    }

    @Test
    public void canGetNextGeneration2() {
        ConwayGame game = new ConwayGame(1, 1);

        game.readGeneration("*");
        game.moveToNextGeneration();

        assertEquals(".\n", game.getNextGeneration());
    }

    @Test
    public void canGetNextGeneration3() {
        ConwayGame game = new ConwayGame(2, 2);

        game.readGeneration("****");
        game.moveToNextGeneration();

        assertEquals("**\n**\n", game.getNextGeneration());
    }
}
