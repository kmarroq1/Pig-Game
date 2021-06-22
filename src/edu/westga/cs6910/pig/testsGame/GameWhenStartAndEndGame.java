package edu.westga.cs6910.pig.testsGame;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.Game;
import edu.westga.cs6910.pig.model.HumanPlayer;
import edu.westga.cs6910.pig.model.strategies.CautiousStrategy;

/**
 * Tests the methods used for starting a game and determining if the game is
 * over in the Game class.
 * 
 * @author Kimberly Marroquin
 * @version Jun 15, 2021
 */
public class GameWhenStartAndEndGame {

	/**
	 * Test method for starting a new game. Should be able to get the name of the
	 * current player.
	 */
	@Test
	public void testStartNewGame() {
		CautiousStrategy strategy = new CautiousStrategy();
		HumanPlayer human = new HumanPlayer("human player");
		ComputerPlayer computer = new ComputerPlayer(strategy);
		Game testGame = new Game(human, computer);
		testGame.startNewGame(human);
		assertEquals("human player", testGame.getCurrentPlayer().getName());
	}

	/**
	 * Test method for seeing if game is over. Gives human player 24 points and the
	 * computer 6 points, so should return true.
	 */
	@Test
	public void testGameIsOver() {
		CautiousStrategy strategy = new CautiousStrategy();
		HumanPlayer human = new HumanPlayer("human player");
		ComputerPlayer computer = new ComputerPlayer(strategy);
		Game testGame = new Game(human, computer);
		testGame.startNewGame(human);
		testGame.getHumanPlayer().addTotal(6, 6);
		testGame.getHumanPlayer().addTotal(6, 6);
		testGame.getComputerPlayer().addTotal(3, 3);
		assertEquals(true, testGame.isGameOver());
	}

	/**
	 * Test method for seeing if game is over. Gives neither player any points, so
	 * should return false.
	 */
	@Test
	public void testGameIsNotOver() {
		CautiousStrategy strategy = new CautiousStrategy();
		HumanPlayer human = new HumanPlayer("human player");
		ComputerPlayer computer = new ComputerPlayer(strategy);
		Game testGame = new Game(human, computer);
		testGame.startNewGame(human);
		assertEquals(false, testGame.isGameOver());
	}
}
