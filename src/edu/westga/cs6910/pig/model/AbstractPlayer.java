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
		this.name = name;
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
		this.total += die1Value + die2Value;
	}

	/**
	 * Adds die values to total score for just the turn.
	 * 
	 * @param die1Value first die value
	 * @param die2Value second die value
	 */
	public void addTurnTotal(int die1Value, int die2Value) {
		this.turnTotal += die1Value + die2Value;
	}

	@Override
	/**
	 * @see Player#resetTurnTotal()
	 */
	public void resetTurnTotal() {
		this.turnTotal = 0;
	}

	@Override
	/**
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
	 * @see Player#getIsMyTurn()
	 */
	public boolean getIsMyTurn() {
		return this.isMyTurn;
	}

	@Override
	/**
	 * @see Player#getTurnTotal()
	 */
	public int getTurnTotal() {
		return this.turnTotal;
	}

	@Override
	/**
	 * @see Player#getName()
	 */
	public String getName() {
		return this.name;
	}

	@Override
	/**
	 * @see Player#getDiceValues()
	 */
	public String getDiceValues() {
		return this.thePair.getDie1Value() + ", " + this.thePair.getDie2Value();
	}

	@Override
	/**
	 * @see Player#getTotal()
	 */
	public int getTotal() {
		return this.total;
	}
}
