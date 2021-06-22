package edu.westga.cs6910.pig.testsStrategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.strategies.CautiousStrategy;

/**
 * Tests roll again method in cautious strategy class.
 * 
 * @author Kimberly Marroquin
 * @version Jun 21, 2021
 */
public class CautiousStrategyWhenRollAgain {

	/**
	 * Test method for roll again method.
	 */
	@Test
	public void testRollAgain() {
		CautiousStrategy test = new CautiousStrategy();
		assertEquals(false, test.rollAgain(1, 1, 1));
	}

}
