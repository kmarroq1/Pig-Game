package edu.westga.cs6910.pig.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.Game;
import edu.westga.cs6910.pig.model.HumanPlayer;

/**
 * Tests hold method from Game class. Play method makes use of hold method, but
 * is more dynamic so is not tested.
 * 
 * @author Kimberly Marroquin
 * @version Jun 15, 2021
 */
public class GameWhenHold {

	/**
	 * Test method for hold method in Game class. Should swap computer player to
	 * human player.
	 */
	@Test
	public void testHold() {
		HumanPlayer human = new HumanPlayer("human player");
		ComputerPlayer computer = new ComputerPlayer();
		Game testGame = new Game(human, computer);
		testGame.startNewGame(computer);
		testGame.hold();
		assertEquals("human player", testGame.getCurrentPlayer().getName());
	}

}
