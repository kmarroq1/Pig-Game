package edu.westga.cs6910.pig.model;

/**
 * Implement the shared code and define abstract methods for methods without
 * duplicate code.
 * 
 * @author Kimberly Marroquin
 * @version Jun 8, 2021
 */
public abstract class AbstractPlayer implements Player {
	private String name;
	private DicePair thePair;
	private boolean isMyTurn;
	private int total;
	private int turnTotal;

	/**
	 * Creates a new ComputerPlayer with the specified name.
	 * 
	 * @param name this Player's name
	 * 
	 * @requires name != null
	 * @ensure name().equals(name) && getTotal() == 0
	 */
	public AbstractPlayer(String name) {
		if (name == null) {
			throw new IllegalArgumentException("Invalid name");
		}
		this.name = name;
		this.total = 0;
		this.thePair = new DicePair();
	}

	/**
	 * Returns the pair of dice.
	 * 
	 * @return dice pair
	 */
	public DicePair getThePair() {
		return this.thePair;
	}

	/**
	 * This method allows you to set whether or not it is the player's turn. Should
	 * be set to true if it is the player's turn.
	 * 
	 * @param isPlayersTurn true if it is the player's turn
	 */
	public void setIsMyTurn(boolean isPlayersTurn) {
		this.isMyTurn = isPlayersTurn;
	}

	/**
	 * Subtracts the turn total points from the total score.
	 */
	public void subtractingFromTotal() {
		this.total -= this.turnTotal;
	}

	/**
	 * Adds die values to total score.
	 * 
	 * @param die1Value first die value
	 * @param die2Value second die value
	 */
	public void addTotal(int die1Value, int die2Value) {
		if (die1Value <= 0 || die2Value <= 0) {
			throw new IllegalArgumentException("Die value must be greater or equal to 0");
		}
		this.total += die1Value + die2Value;
	}

	/**
	 * Adds die values to total score for just the turn.
	 * 
	 * @param die1Value first die value
	 * @param die2Value second die value
	 */
	public void addTurnTotal(int die1Value, int die2Value) {
		if (die1Value <= 0 || die2Value <= 0) {
			throw new IllegalArgumentException("Die value must be greater or equal to 0");
		}
		this.turnTotal += die1Value + die2Value;
	}

	@Override
	/**
	 * Resets the turn total to zero.
	 * 
	 * @see Player#resetTurnTotal()
	 */
	public void resetTurnTotal() {
		this.turnTotal = 0;
	}

	@Override
	/**
	 * Resets all scores to zero.
	 * 
	 * @see Player#resetTurnTotal()
	 */
	public void resetTotalScores() {
		this.turnTotal = 0;
		this.total = 0;
	}
	
	@Override
	/**
	 * Allows the current layer to roll the die.
	 * 
	 * @see Player#takeTurn()
	 */
	public void takeTurn() {
		this.thePair.rollDice();

		int die1Value = this.thePair.getDie1Value();
		int die2Value = this.thePair.getDie2Value();
		if (die1Value == 1 || die2Value == 1) {
			this.total -= this.turnTotal;
			this.isMyTurn = false;
		} else {
			this.turnTotal += die1Value + die2Value;
			this.total += die1Value + die2Value;
			this.isMyTurn = true;
		}
	}

	@Override
	/**
	 * Returns true if it is your turn.
	 * 
	 * @see Player#getIsMyTurn()
	 */
	public boolean getIsMyTurn() {
		return this.isMyTurn;
	}

	@Override
	/**
	 * Returns the turn total.
	 * 
	 * @see Player#getTurnTotal()
	 */
	public int getTurnTotal() {
		return this.turnTotal;
	}

	@Override
	/**
	 * Returns the player name.
	 * 
	 * @see Player#getName()
	 */
	public String getName() {
		return this.name;
	}

	@Override
	/**
	 * Returns the value of both dice.
	 * 
	 * @see Player#getDiceValues()
	 */
	public String getDiceValues() {
		return this.thePair.getDie1Value() + ", " + this.thePair.getDie2Value();
	}

	@Override
	/**
	 * Returns the total score of the player.
	 * 
	 * @see Player#getTotal()
	 */
	public int getTotal() {
		return this.total;
	}
}
