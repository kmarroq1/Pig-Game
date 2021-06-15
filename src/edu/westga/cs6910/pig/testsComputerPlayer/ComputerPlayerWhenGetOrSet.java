package edu.westga.cs6910.pig.testsComputerPlayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;

/**
 * Tests getter and setter methods in ComputerPlayer class.
 * 
 * @author Kimberly Marroquin
 * @version Jun 8, 2021
 */
public class ComputerPlayerWhenGetOrSet {

	/**
	 * Test method for getting the maximum rolls. Should equal zero initially.
	 */
	@Test
	public void testGetMaximumRolls() {
		ComputerPlayer testPlayer = new ComputerPlayer();
		assertEquals(0, testPlayer.getMaximumRolls());
	}

	/**
	 * Test method for setting the maximum rolls. Should equal 1.
	 */
	@Test
	public void testSetMaximumRolls() {
		ComputerPlayer testPlayer = new ComputerPlayer();
		testPlayer.setMaximumRolls();
		assertEquals(1, testPlayer.getMaximumRolls());
	}

	/**
	 * Test method for getting the dice pair.
	 */
	@Test
	public void testGetThePair() {
		ComputerPlayer testPlayer = new ComputerPlayer();
		assertEquals("pips: 1, pips: 1", testPlayer.getThePair().toString());
	}

	/**
	 * Test method for setting turn. Should equal false.
	 */
	@Test
	public void testGetIsMyTurn() {
		ComputerPlayer testPlayer = new ComputerPlayer();
		assertEquals(false, testPlayer.getIsMyTurn());
	}

	/**
	 * Test method for setting turn. Should equal true.
	 */
	@Test
	public void testSetIsMyTurn() {
		ComputerPlayer testPlayer = new ComputerPlayer();
		testPlayer.setIsMyTurn(true);
		assertEquals(true, testPlayer.getIsMyTurn());
	}

	/**
	 * Test method for getting the turn total. Default value zero.
	 */
	@Test
	public void testGetTurnTotal() {
		ComputerPlayer testPlayer = new ComputerPlayer();
		assertEquals(0, testPlayer.getTurnTotal());
	}

	/**
	 * Test method for getting the computer name.
	 */
	@Test
	public void testGetName() {
		ComputerPlayer testPlayer = new ComputerPlayer();
		assertEquals("Simple computer", testPlayer.getName());
	}

	/**
	 * Test method for getting the dice values.
	 */
	@Test
	public void testGetDiceValues() {
		ComputerPlayer testPlayer = new ComputerPlayer();
		assertEquals("1, 1", testPlayer.getDiceValues());
	}

	/**
	 * Test method for getting the total. Default value zero.
	 */
	@Test
	public void testGetTotal() {
		ComputerPlayer testPlayer = new ComputerPlayer();
		assertEquals(0, testPlayer.getTotal());
	}

}
