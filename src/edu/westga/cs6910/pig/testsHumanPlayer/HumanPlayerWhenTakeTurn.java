package edu.westga.cs6910.pig.testsHumanPlayer;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.HumanPlayer;

/**
 * Tests takeTurn method in HumanPlayer class.
 * 
 * @author Kimberly Marroquin
 * @version Jun 15, 2021
 */
public class HumanPlayerWhenTakeTurn {

	/**
	 * Test method for taking a turn. Should never be human's turn when a die pip
	 * equals 1.
	 */
	@Test
	public void testTakeTurn() {
		HumanPlayer testPlayer = new HumanPlayer("test");
		for (int count = 0; count < 10000; count++) {
			testPlayer.takeTurn();
			if (testPlayer.getIsMyTurn()
					&& (testPlayer.getThePair().getDie1Value() == 1 || testPlayer.getThePair().getDie2Value() == 1)) {
				fail("Should not be this player's turn");
			}
		}
	}

}
