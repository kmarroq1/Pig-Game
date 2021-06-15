package edu.westga.cs6910.pig.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;

/**
 * Tests adding and subtracting methods in ComputerPlayer super class.
 * 
 * @author Kimberly Marroquin
 * @version Jun 15, 2021
 */
public class ComputerPlayerWhenAddOrSubtract {

	/**
	 * Test method for subtraction method.
	 */
	@Test
	public void testSubtractingFromTotal() {
		ComputerPlayer testPlayer = new ComputerPlayer();
		testPlayer.subtractingFromTotal();
		assertEquals(0, testPlayer.getTotal());
	}

	/**
	 * Test method for adding the total score, where the initial score was 0.
	 */
	@Test
	public void testAddTotal() {
		ComputerPlayer testPlayer = new ComputerPlayer();
		testPlayer.addTotal(1, 1);
		assertEquals(2, testPlayer.getTotal());
	}
	
	/**
	 * Test method for resetting the turn total.
	 */
	@Test
	public void testResetTurnTotal() {
		ComputerPlayer testPlayer = new ComputerPlayer();
		testPlayer.addTotal(1, 1);
		testPlayer.resetTurnTotal();
		assertEquals(0, testPlayer.getTurnTotal());
	}

	/**
	 * Test method for adding the turn total where the turn amounts to 2 points.
	 */
	@Test
	public void testAddTurnTotal() {
		ComputerPlayer testPlayer = new ComputerPlayer();
		testPlayer.addTurnTotal(1, 1);
		assertEquals(2, testPlayer.getTurnTotal());
	}

}
