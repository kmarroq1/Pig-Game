package edu.westga.cs6910.pig.testsGame;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.Game;
import edu.westga.cs6910.pig.model.HumanPlayer;
import edu.westga.cs6910.pig.model.strategies.CautiousStrategy;

/**
 * Tests toString method in Game class.
 * 
 * @author Kimberly Marroquin
 * @version Jun 8, 2021
 */
class GameWhenCreateGame {

	/**
	 * Test method for creating a Game object.
	 */
	@Test
	void testToString() {
		CautiousStrategy strategy = new CautiousStrategy();
		HumanPlayer testHumanPlayer = new HumanPlayer("test human");
		ComputerPlayer testComputerPlayer = new ComputerPlayer(strategy);
		Game testGame = new Game(testHumanPlayer, testComputerPlayer);
		assertEquals("Goal Score: 20\r\n" + "test human: 0\r\n" + "Simple computer: 0", testGame.toString());
	}

}
