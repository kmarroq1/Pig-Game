package edu.westga.cs6910.pig.tests;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.DicePair;

/**
 * Tests the DicePair rolling method.
 * 
 * @author Kimberly Marroquin
 * @version Jun 15, 2021
 */
public class DicePairWhenRollDice {

	/**
	 * Test method for rolling a pair of dice.
	 */
	@Test
	public void testRollDice() {
		DicePair testDicePair = new DicePair();
		for (int count = 0; count < 10000; count++) {
			testDicePair.rollDice();
			if (testDicePair.getDie1Value() < 1 || testDicePair.getDie1Value() > 6 || testDicePair.getDie2Value() < 1
					|| testDicePair.getDie2Value() > 6) {
				fail("Rolled a die with value: " + testDicePair.toString());
			}
		}
	}

}
