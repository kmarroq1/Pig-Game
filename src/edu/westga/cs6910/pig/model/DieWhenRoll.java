package edu.westga.cs6910.pig.model;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

/**
 * Tests die class roll method. 
 * 
 * @author Kimberly Marroquin
 * @version Jun 15, 2021
 */
public class DieWhenRoll {

	/**
	 * Test method for rolling a die. Ensures that die never rolls under 1 or over 7 pips.
	 */
	@Test
	public void testRoll() {
		Die testDie = new Die();
		for (int count = 0; count < 10000; count++) {
			testDie.roll();
			if (testDie.getNumberOfPips() < 1 || testDie.getNumberOfPips() > 6) {
				fail("Rolled a die with value: " + testDie.getNumberOfPips());
			}
		}
	}

}
