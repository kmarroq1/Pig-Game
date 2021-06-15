package edu.westga.cs6910.pig.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.Die;

/**
 * Tests constructor in die class.
 * 
 * @author Kimberly Marroquin
 * @version Jun 14, 2021
 */
public class TestWhenDieIsCreated {

	/**
	 * Test method for die class constructor.
	 */
	@Test
	public void testShouldProduceDieWith1Pip() {
		Die newDie = new Die();
		assertEquals("pips: 1", newDie.toString());
	}

}
