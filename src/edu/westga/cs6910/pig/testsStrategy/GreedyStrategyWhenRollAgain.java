package edu.westga.cs6910.pig.testsStrategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.strategies.GreedyStrategy;

/**
 * Tests true and false cases for rolling again in greedy strategy.
 * 
 * @author Kimberly Marroquin
 * @version Jun 22, 2021
 */
public class GreedyStrategyWhenRollAgain {

	/**
	 * Test method for true case of rolling again with zero rolls taken.
	 */
	@Test
	public void testRollAgainTrueZeroTurns() {
		GreedyStrategy test = new GreedyStrategy();
		assertEquals(true, test.rollAgain(0, 1, 1));
	}

	/**
	 * Test method for true case of rolling again with one roll taken.
	 */
	@Test
	public void testRollAgainTrueOneTurn() {
		GreedyStrategy test = new GreedyStrategy();
		assertEquals(true, test.rollAgain(1, 1, 1));
	}

	/**
	 * Test method for true case of rolling again with two rolls taken.
	 */
	@Test
	public void testRollAgainTrueTwoTurns() {
		GreedyStrategy test = new GreedyStrategy();
		assertEquals(true, test.rollAgain(2, 1, 1));
	}

	/**
	 * Test method for false case of rolling again with three rolls taken.
	 */
	@Test
	public void testRollAgainTrueThreeTurns() {
		GreedyStrategy test = new GreedyStrategy();
		assertEquals(false, test.rollAgain(3, 1, 1));
	}
}
