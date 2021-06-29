package edu.westga.cs6910.pig.testsGame;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.Game;
import edu.westga.cs6910.pig.model.HumanPlayer;
import edu.westga.cs6910.pig.model.strategies.CautiousStrategy;

/**
 * Tests getter methods in Game class.
 * 
 * @author Kimberly Marroquin
 * @version Jun 15, 2021
 */
public class GameWhenGetOrSet {

	/**
	 * Test method for getting the human player.
	 */
	@Test
	public void testGetHumanPlayer() {
		CautiousStrategy strategy = new CautiousStrategy();
		HumanPlayer human = new HumanPlayer("human player");
		ComputerPlayer computer = new ComputerPlayer(strategy);
		Game testGame = new Game(human, computer);
		assertEquals("human player", testGame.getHumanPlayer().getName());
	}

	/**
	 * Test method for getting the computer player.
	 */
	@Test
	public void testGetComputerPlayer() {
		CautiousStrategy strategy = new CautiousStrategy();
		HumanPlayer human = new HumanPlayer("human player");
		ComputerPlayer computer = new ComputerPlayer(strategy);
		Game testGame = new Game(human, computer);
		assertEquals("Simple computer", testGame.getComputerPlayer().getName());
	}

	/**
	 * Test method for getting the dice pair.
	 */
	@Test
	public void testGetDicePair() {
		CautiousStrategy strategy = new CautiousStrategy();
		HumanPlayer human = new HumanPlayer("human player");
		ComputerPlayer computer = new ComputerPlayer(strategy);
		Game testGame = new Game(human, computer);
		assertEquals("pips: 1, pips: 1", testGame.getDicePair().toString());
	}

	/**
	 * Test method for getting the goal score.
	 */
	@Test
	public void testGetGoalScore() {
		CautiousStrategy strategy = new CautiousStrategy();
		HumanPlayer human = new HumanPlayer("human player");
		ComputerPlayer computer = new ComputerPlayer(strategy);
		Game testGame = new Game(human, computer);
		assertEquals(20, testGame.getGoalScore());
	}

	/**
	 * Test method for setting the goal score.
	 */
	@Test
	public void testSetGoalScore() {
		CautiousStrategy strategy = new CautiousStrategy();
		HumanPlayer human = new HumanPlayer("human player");
		ComputerPlayer computer = new ComputerPlayer(strategy);
		Game testGame = new Game(human, computer);
		testGame.setGoalScore(40);
		assertEquals(40, testGame.getGoalScore());
	}

}
