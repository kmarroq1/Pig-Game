package edu.westga.cs6910.pig.model.strategies;

/**
 * Game play strategy that returns true until the computer has taken three
 * turns.
 * 
 * @author Kimberly Marroquin
 * @version Jun 21, 2021
 */
public class GreedyStrategy implements PigStrategy {
	private int rollsTakenInTurn;

	/**
	 * Constructor for initializing instance variable.
	 */
	public GreedyStrategy() {
		this.rollsTakenInTurn = 0;
	}

	@Override
	public boolean rollAgain(int rollsTaken, int currentTurnTotal, int pointsUntilGoal) {
		if (rollsTaken < 0 || currentTurnTotal < 0) {
			throw new IllegalArgumentException("Invalid values");
		}
		this.rollsTakenInTurn = rollsTaken;
		if (this.rollsTakenInTurn < 3 && pointsUntilGoal > 0) {
			return true;
		}
		return false;
	}

	/**
	 * Returns string confirming that class was created.
	 * 
	 * @return returns string describing class state
	 */
	public String toString() {
		return "Greedy strategy class was created. Player has taken " + this.rollsTakenInTurn + " turns.";
	}
}
