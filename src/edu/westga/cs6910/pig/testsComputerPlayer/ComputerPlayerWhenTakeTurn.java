package edu.westga.cs6910.pig.testsComputerPlayer;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.Game;
import edu.westga.cs6910.pig.model.HumanPlayer;
import edu.westga.cs6910.pig.model.strategies.CautiousStrategy;

/**
 * Tests takeTurn method in ComputerPlayer class.
 * 
 * @author Kimberly Marroquin
 * @version Jun 15, 2021
 */
public class ComputerPlayerWhenTakeTurn {

	/**
	 * Test method for the computer player taking a turn. It should never be the
	 * simple computer's turn after taking a turn.
	 */
	@Test
	public void testTakeTurn() {
		CautiousStrategy strategy = new CautiousStrategy();
		ComputerPlayer testPlayer = new ComputerPlayer(strategy);
		HumanPlayer human = new HumanPlayer("bob");
		Game theGame = new Game(human, testPlayer);
		for (int count = 0; count < 10000; count++) {
			testPlayer.takeTurn(theGame);
			if (testPlayer.getIsMyTurn()) {
				fail("Should not be this player's turn");
			}
		}
	}

}
