package edu.westga.cs6910.pig.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.DicePair;

/**
 * Tests DicePair constructor by calling toString method.
 * 
 * @author Kimberly Marroquin
 * @version Jun 15, 2021
 */
public class DicePairWhenCreateDicePair {

	/**
	 * Test method for DicePair constructor.
	 */
	@Test
	public void testToString() {
		DicePair testDicePair = new DicePair();
		assertEquals("pips: 1, pips: 1", testDicePair.toString());
	}

}
