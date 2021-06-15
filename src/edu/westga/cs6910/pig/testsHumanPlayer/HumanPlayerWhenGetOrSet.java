package edu.westga.cs6910.pig.testsHumanPlayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.HumanPlayer;

/**
 * @author Kimberly Marroquin
 * @version Jun 15, 2021
 */
class HumanPlayerWhenGetOrSet {

	/**
	 * Test method for getting the dice pair.
	 */
	@Test
	public void testGetThePair() {
		HumanPlayer testPlayer = new HumanPlayer("test");
		assertEquals("pips: 1, pips: 1", testPlayer.getThePair().toString());
	}

	/**
	 * Test method for setting turn. Should equal false.
	 */
	@Test
	public void testGetIsMyTurn() {
		HumanPlayer testPlayer = new HumanPlayer("test");
		assertEquals(false, testPlayer.getIsMyTurn());
	}

	/**
	 * Test method for setting turn. Should equal true.
	 */
	@Test
	public void testSetIsMyTurn() {
		HumanPlayer testPlayer = new HumanPlayer("test");
		testPlayer.setIsMyTurn(true);
		assertEquals(true, testPlayer.getIsMyTurn());
	}

	/**
	 * Test method for getting the turn total. Default value zero.
	 */
	@Test
	public void testGetTurnTotal() {
		HumanPlayer testPlayer = new HumanPlayer("test");
		assertEquals(0, testPlayer.getTurnTotal());
	}

	/**
	 * Test method for getting the computer name.
	 */
	@Test
	public void testGetName() {
		HumanPlayer testPlayer = new HumanPlayer("test");
		assertEquals("test", testPlayer.getName());
	}

	/**
	 * Test method for getting the dice values.
	 */
	@Test
	public void testGetDiceValues() {
		HumanPlayer testPlayer = new HumanPlayer("test");
		assertEquals("1, 1", testPlayer.getDiceValues());
	}

	/**
	 * Test method for getting the total. Default value zero.
	 */
	@Test
	public void testGetTotal() {
		HumanPlayer testPlayer = new HumanPlayer("test");
		assertEquals(0, testPlayer.getTotal());
	}

}
