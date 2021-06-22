package edu.westga.cs6910.pig.model.strategies;

/**
 * Defines a conservative game strategy that never chooses to roll again.
 * 
 * @author Kimberly Marroquin
 * @version Jun 21, 2021
 */
public class CautiousStrategy implements PigStrategy {

	/**
	 * This strategy always returns false.
	 */
	@Override
	public boolean rollAgain(int rollsTaken, int currentTurnTotal, int pointsUntilGoal) {
		if (rollsTaken < 0 || currentTurnTotal < 0) {
			throw new IllegalArgumentException("Invalid values");
		}
		return false;
	}
	
	/**
	 * Returns string confirming that class was created.
	 * 
	 * @return returns string describing class state
	 */
	public String toString() {
		return "Created catious strategy";
	}

}
