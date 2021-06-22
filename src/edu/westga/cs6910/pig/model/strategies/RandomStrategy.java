package edu.westga.cs6910.pig.model.strategies;

/**
 * Game play strategy with equal likelihood of returning true or false for
 * rolling again.
 * 
 * @author Kimberly Marroquin
 * @version Jun 21, 2021
 */
public class RandomStrategy implements PigStrategy {

	/**
	 * Randomized decision for rolling again. Returns true if the player will roll
	 * again, false otherwise.
	 * 
	 * @return true if will roll again
	 */
	@Override
	public boolean rollAgain(int rollsTaken, int currentTurnTotal, int pointsUntilGoal) {
		if (rollsTaken < 0 || currentTurnTotal < 0) {
			throw new IllegalArgumentException("Invalid values");
		}
		int max = 2;
		int min = 1;
		if (Math.floor(Math.random() * (max - min + 1) + min) == 1 && pointsUntilGoal > 0) {
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
		return "Created random strategy class";
	}

}
