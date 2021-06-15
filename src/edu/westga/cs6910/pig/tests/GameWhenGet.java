package edu.westga.cs6910.pig.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.Game;
import edu.westga.cs6910.pig.model.HumanPlayer;

/**
 * Tests getter methods in Game class.
 * 
 * @author Kimberly Marroquin
 * @version Jun 15, 2021
 */
public class GameWhenGet {

	/**
	 * Test method for getting the human player.
	 */
	@Test
	public void testGetHumanPlayer() {
		HumanPlayer human = new HumanPlayer("human player");
		ComputerPlayer computer = new ComputerPlayer();
		Game testGame = new Game(human, computer);
		assertEquals("human player", testGame.getHumanPlayer().getName());
	}

	/**
	 * Test method for getting the computer player.
	 */
	@Test
	public void testGetComputerPlayer() {
		HumanPlayer human = new HumanPlayer("human player");
		ComputerPlayer computer = new ComputerPlayer();
		Game testGame = new Game(human, computer);
		assertEquals("Simple computer", testGame.getComputerPlayer().getName());
	}

	/**
	 * Test method for getting the dice pair.
	 */
	@Test
	public void testGetDicePair() {
		HumanPlayer human = new HumanPlayer("human player");
		ComputerPlayer computer = new ComputerPlayer();
		Game testGame = new Game(human, computer);
		assertEquals("pips: 1, pips: 1", testGame.getDicePair().toString());
	}

}
