package edu.westga.cs6910.pig.testsStrategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.strategies.RandomStrategy;

/**
 * Tests creating random strategy class instance.
 * 
 * @author Kimberly Marroquin
 * @version Jun 21, 2021
 */
public class RandomStrategyWhenCreateRandomStrategy {

	/**
	 * Test method for creating random strategy class.
	 */
	@Test
	public void testToString() {
		RandomStrategy test = new RandomStrategy();
		assertEquals("Created random strategy class", test.toString());
	}

}
