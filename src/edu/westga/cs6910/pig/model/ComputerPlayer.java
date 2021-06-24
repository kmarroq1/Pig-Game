package edu.westga.cs6910.pig.model;

import edu.westga.cs6910.pig.model.strategies.PigStrategy;

/**
 * ComputerPlayer represents a very simple automated player in the game Pig. It
 * rolls exactly 1 time and then holds.
 * 
 * @author CS6910, Kimberly Marroquin
 * @version Summer 2021
 */
public class ComputerPlayer extends AbstractPlayer {
	private static final String NAME = "Simple computer";
	private int maximumRolls;
	private PigStrategy strategy;

	/**
	 * Creates a new ComputerPlayer with the specified name.
	 * 
	 * @param newStrategy the type of strategy to implement
	 * 
	 */
	public ComputerPlayer(PigStrategy newStrategy) {
		super(NAME);
		if (newStrategy == null) {
			throw new IllegalArgumentException("Invalid strategy");
		}
		this.setStrategy(newStrategy);
	}

	/**
	 * Implements Player's setMaximumRolls, but is not normally called by client
	 * objects. Instead, clients usually call the 0-parameter version
	 * 
	 * @param maximumRolls The maximum number of times the computer will roll before
	 *                     holding
	 */
	public void setMaximumRolls(int maximumRolls) {
		this.maximumRolls = maximumRolls;
	}

	/**
	 * Implements Player's setMaximumRolls() to set the maximum number of rolls to 1
	 * 
	 */
	public void setMaximumRolls() {
		this.maximumRolls = 1;
	}

	/**
	 * Returns the maximum rolls.
	 * 
	 * @return maximum rolls
	 * 
	 */
	public int getMaximumRolls() {
		return this.maximumRolls;
	}

	@Override
	/**
	 * @see Computer#takeTurn()
	 */
	public void takeTurn() {
		int numberOfRolls = 0;
		do {
			numberOfRolls++;
			super.getThePair().rollDice();
			int die1Value = super.getThePair().getDie1Value();
			int die2Value = super.getThePair().getDie2Value();
			if (die1Value == 1 || die2Value == 1) {
				super.subtractingFromTotal();
				super.resetTurnTotal();
				super.setIsMyTurn(false);
				return;
			} else {
				super.addTurnTotal(die1Value, die2Value);
				super.addTotal(die1Value, die2Value);
			}
		} while (this.strategy.rollAgain(numberOfRolls, getTurnTotal(), Game.GOAL_SCORE - getTotal()));
	}

	/**
	 * Gets game strategy.
	 * 
	 * @return the strategy
	 */
	public PigStrategy getStrategy() {
		return this.strategy;
	}

	/**
	 * Sets game strategy.
	 * 
	 * @param newStrategy the strategy to set
	 * 
	 *                    Precondition: newSrategy != null
	 * 
	 *                    Postcondition: the specified strategy will determine how
	 *                    the player will play
	 */
	public void setStrategy(PigStrategy newStrategy) {
		if (newStrategy == null) {
			throw new IllegalArgumentException("Invalid strategy");
		}
		this.strategy = newStrategy;
	}

}
