package edu.westga.cs6910.pig.model.strategies;

/**
 * Defines the player strategies in the game Pig.
 * 
 * @author Kimberly Marroquin
 * @version Jun 21, 2021
 */
public interface PigStrategy {

	/**
	 * Returns whether or not the player should roll again.
	 * 
	 * @param rollsTaken       Number of rolls already taken this turn
	 * @param currentTurnTotal Number of points rolled so far this turn
	 * @param pointsUntilGoal  The difference between the total points so far and
	 *                         goal score
	 * @return true if the player should roll again, false otherwise
	 */
	boolean rollAgain(int rollsTaken, int currentTurnTotal, int pointsUntilGoal);
}
