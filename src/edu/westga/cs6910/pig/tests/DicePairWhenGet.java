package edu.westga.cs6910.pig.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.DicePair;

/**
 * Tests getter methods in DicePair class.
 * 
 * @author Kimberly Marroquin
 * @version Jun 15, 2021
 */
public class DicePairWhenGet {

	/**
	 * Test method for getting the first die value.
	 */
	@Test
	public void testGetDie1Value() {
		DicePair testDicePair = new DicePair();
		assertEquals(1, testDicePair.getDie1Value());
	}

	/**
	 * Test method for getting the second die value.
	 */
	@Test
	public void testGetDie2Value() {
		DicePair testDicePair = new DicePair();
		assertEquals(1, testDicePair.getDie2Value());
	}

}
