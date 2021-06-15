package edu.westga.cs6910.pig.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.Die;

/**
 * Tests getter method in die class.
 * 
 * @author Kimberly Marroquin
 * @version Jun 15, 2021
 */
public class DieWhenGetPips {

	/**
	 * Test method for getting die pips
	 */
	@Test
	public void testWithNewDieShouldHave1Pip() {
		Die newDie = new Die();
		assertEquals(1, newDie.getNumberOfPips());
	}

}
