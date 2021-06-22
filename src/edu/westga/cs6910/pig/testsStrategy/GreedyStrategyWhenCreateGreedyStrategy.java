package edu.westga.cs6910.pig.testsStrategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.strategies.GreedyStrategy;

/**
 * Tests creating a greedy strategy class.
 * 
 * @author Kimberly Marroquin
 * @version Jun 22, 2021
 */
public class GreedyStrategyWhenCreateGreedyStrategy {

	/**
	 * Test method for creating a greedy strategy class.
	 */
	@Test
	public void testToString() {
		GreedyStrategy test = new GreedyStrategy();
		assertEquals("Greedy strategy class was created. Player has taken 0 turns.", test.toString());
	}

}
