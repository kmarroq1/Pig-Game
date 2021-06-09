package edu.westga.cs6910.pig.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;

/**
 * @author Kimberly Marroquin
 * @version Jun 8, 2021
 */
class ComputerPlayerWhenGetOrSet {

	/**
	 * Test method for setting turn. Should equal true.
	 */
	@Test
	void testSetThenGetIsMyTurn() {
		ComputerPlayer testPlayer = new ComputerPlayer();
		testPlayer.setIsMyTurn(true);
		assertEquals(true, testPlayer.getIsMyTurn());
	}

	/**
	 * Test method for getting the turn total. Default value zero.
	 */
	@Test
	void testGetTurnTotal() {
		ComputerPlayer testPlayer = new ComputerPlayer();
		assertEquals(0, testPlayer.getTurnTotal());
	}

	/**
	 * Test method for getting the computer name.
	 */
	@Test
	void testGetName() {
		ComputerPlayer testPlayer = new ComputerPlayer();
		assertEquals("Simple computer", testPlayer.getName());
	}

	/**
	 * Test method for getting the dice values.
	 */
	@Test
	void testGetDiceValues() {
		ComputerPlayer testPlayer = new ComputerPlayer();
		assertEquals("1, 1", testPlayer.getDiceValues());
	}

	/**
	 * Test method for getting the total. Default value zero.
	 */
	@Test
	void testGetTotal() {
		ComputerPlayer testPlayer = new ComputerPlayer();
		assertEquals(0, testPlayer.getTotal());
	}

}
