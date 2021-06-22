package edu.westga.cs6910.pig.testsStrategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.strategies.CautiousStrategy;

/**
 * Tests creating a cautious strategy class.
 * 
 * @author Kimberly Marroquin
 * @version Jun 21, 2021
 */
public class CautiousStrategyWhenCreateCautiousStrategy {

	/**
	 * Test method for toString method.
	 */
	@Test
	public void testToString() {
		CautiousStrategy test = new CautiousStrategy();
		assertEquals("Created catious strategy", test.toString());
	}

}
