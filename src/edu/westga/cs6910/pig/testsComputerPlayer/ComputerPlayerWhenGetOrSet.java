package edu.westga.cs6910.pig.testsComputerPlayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.HumanPlayer;
import edu.westga.cs6910.pig.model.strategies.CautiousStrategy;

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
		CautiousStrategy strategy = new CautiousStrategy();
		ComputerPlayer testPlayer = new ComputerPlayer(strategy);
		assertEquals(0, testPlayer.getMaximumRolls());
	}

	/**
	 * Test method for setting the maximum rolls. Should equal 1.
	 */
	@Test
	public void testSetMaximumRolls() {
		CautiousStrategy strategy = new CautiousStrategy();
		ComputerPlayer testPlayer = new ComputerPlayer(strategy);
		testPlayer.setMaximumRolls();
		assertEquals(1, testPlayer.getMaximumRolls());
	}

	/**
	 * Test method for getting the dice pair.
	 */
	@Test
	public void testGetThePair() {
		CautiousStrategy strategy = new CautiousStrategy();
		ComputerPlayer testPlayer = new ComputerPlayer(strategy);
		assertEquals("pips: 1, pips: 1", testPlayer.getThePair().toString());
	}

	/**
	 * Test method for setting turn. Should equal false.
	 */
	@Test
	public void testGetIsMyTurn() {
		CautiousStrategy strategy = new CautiousStrategy();
		ComputerPlayer testPlayer = new ComputerPlayer(strategy);
		assertEquals(false, testPlayer.getIsMyTurn());
	}

	/**
	 * Test method for setting turn. Should equal true.
	 */
	@Test
	public void testSetIsMyTurn() {
		CautiousStrategy strategy = new CautiousStrategy();
		ComputerPlayer testPlayer = new ComputerPlayer(strategy);
		testPlayer.setIsMyTurn(true);
		assertEquals(true, testPlayer.getIsMyTurn());
	}

	/**
	 * Test method for getting the turn total. Default value zero.
	 */
	@Test
	public void testGetTurnTotal() {
		CautiousStrategy strategy = new CautiousStrategy();
		ComputerPlayer testPlayer = new ComputerPlayer(strategy);
		assertEquals(0, testPlayer.getTurnTotal());
	}

	/**
	 * Test method for getting the computer name.
	 */
	@Test
	public void testGetName() {
		CautiousStrategy strategy = new CautiousStrategy();
		ComputerPlayer testPlayer = new ComputerPlayer(strategy);
		assertEquals("Simple computer", testPlayer.getName());
	}

	/**
	 * Test method for getting the dice values.
	 */
	@Test
	public void testGetDiceValues() {
		CautiousStrategy strategy = new CautiousStrategy();
		ComputerPlayer testPlayer = new ComputerPlayer(strategy);
		assertEquals("1, 1", testPlayer.getDiceValues());
	}

	/**
	 * Test method for getting the total. Default value zero.
	 */
	@Test
	public void testGetTotal() {
		CautiousStrategy strategy = new CautiousStrategy();
		ComputerPlayer testPlayer = new ComputerPlayer(strategy);
		assertEquals(0, testPlayer.getTotal());
	}

	/**
	 * Test method for getting the strategy.
	 */
	@Test
	public void testGetStrategy() {
		CautiousStrategy strategy = new CautiousStrategy();
		ComputerPlayer testPlayer = new ComputerPlayer(strategy);
		assertEquals(strategy, testPlayer.getStrategy());
	}

	/**
	 * Test method for setting the strategy.
	 */
	@Test
	public void testSetStrategy() {
		CautiousStrategy strategy = new CautiousStrategy();
		ComputerPlayer testPlayer = new ComputerPlayer(strategy);
		CautiousStrategy otherStrategy = new CautiousStrategy();
		testPlayer.setStrategy(otherStrategy);
		assertEquals(otherStrategy, testPlayer.getStrategy());
	}

	/**
	 * Test method for resetting total score.
	 */
	@Test
	public void testResetTotalScoresTotal() {
		HumanPlayer testPlayer = new HumanPlayer("test");
		testPlayer.addTotal(3, 4);
		testPlayer.resetTotalScores();
		assertEquals(0, testPlayer.getTotal());
	}

	/**
	 * Test method for resetting turn total score.
	 */
	@Test
	public void testResetTotalScoresTurnTotal() {
		HumanPlayer testPlayer = new HumanPlayer("test");
		testPlayer.addTurnTotal(5, 6);
		testPlayer.resetTotalScores();
		assertEquals(0, testPlayer.getTurnTotal());
	}
}
