package edu.westga.cs6910.pig.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Tests getter method in die class.
 * 
 * @author Kimberly Marroquin
 * @version Jun 15, 2021
 */
public class TestWhenGetPips {

	/**
	 * Test method for {@link edu.westga.cs6910.pig.model.Die#getNumberOfPips()}.
	 */
	@Test
	public void testWithNewDieShouldHave1Pip() {
		Die newDie = new Die();
		assertEquals(1, newDie.getNumberOfPips());
	}

}