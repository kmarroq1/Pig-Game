package edu.westga.cs6910.pig.model;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 * Game represents a Pig game.
 * 
 * @author CS6910, Kimberly Marroquin
 * @version Summer 2021
 */
public class Game implements Observable {
	/**
	 * The goal score for the game
	 */
	private int goalScore;

	private ObjectProperty<Player> currentPlayerObject;
	private HumanPlayer theHuman;
	private ComputerPlayer theComputer;
	private Player firstPlayer;
	private DicePair thePair;

	/**
	 * Creates a Pig Game with the specified Players and a pair of dice.
	 * 
	 * @param theComputer the automated player
	 * @param theHuman    the human player
	 * 
	 * @require theHuman != null && theComputer != null
	 * 
	 * @ensure humanPlayer().equals(theHuman) && computerPlayer.equals(theComputer)
	 */
	public Game(HumanPlayer theHuman, ComputerPlayer theComputer) {
		if (theHuman == null) {
			throw new IllegalArgumentException("Invalid human player");
		}
		if (theComputer == null) {
			throw new IllegalArgumentException("Invalid computer player");
		}
		this.theHuman = theHuman;
		this.theComputer = theComputer;
		this.setGoalScore(20);
		this.currentPlayerObject = new SimpleObjectProperty<Player>();

		this.thePair = new DicePair();
	}

	/**
	 * Initializes the game for play.
	 * 
	 * @param firstPlayer the Player who takes the first turn
	 * 
	 * @require firstPlayer != null && !firstPlayer.equals(secondPlayer)
	 * 
	 * @ensures whoseTurn().equals(firstPlayer) && firstPlayer.getTotal() == 0
	 */
	public void startNewGame(Player firstPlayer) {
		if (firstPlayer == null) {
			throw new IllegalArgumentException("Invalid player");
		}
		this.currentPlayerObject.setValue(firstPlayer);
		this.firstPlayer = firstPlayer;
		this.thePair = new DicePair();
	}

	/**
	 * Conducts a move in the game, allowing the appropriate Player to take a turn.
	 * Has no effect if the game is over.
	 * 
	 * @requires !isGameOver()
	 * 
	 * @ensures !whoseTurn().equals(whoseTurn()@prev)
	 */
	public void play() {
		Player currentPlayer = this.currentPlayerObject.getValue();
		this.currentPlayerObject.getValue().takeTurn(this);

		this.currentPlayerObject.setValue(null);
		this.currentPlayerObject.setValue(currentPlayer);

		if (!this.currentPlayerObject.getValue().getIsMyTurn()) {
			this.hold();
			this.currentPlayerObject.getValue().resetTurnTotal();
		}
	}

	/**
	 * Resets the game.
	 * 
	 * @requires !isGameOver()
	 * 
	 * @ensures all scores are reset
	 */
	public void playAgain() {
		this.theComputer.resetTotalScores();
		this.theHuman.resetTotalScores();
		this.currentPlayerObject.setValue(null);
		this.startNewGame(this.firstPlayer);
	}

	/**
	 * Notifies the game that the player is holding
	 * 
	 * @requires !isGameOver()
	 * 
	 * @ensures !whoseTurn().equals(whoseTurn()@prev)
	 */
	public void hold() {
		if (!this.isGameOver()) {
			this.swapWhoseTurn();
		}
	}

	/**
	 * Returns the human Player object.
	 * 
	 * @return the human Player
	 */
	public HumanPlayer getHumanPlayer() {
		return this.theHuman;
	}

	/**
	 * Returns the computer Player object.
	 * 
	 * @return the computer Player
	 */
	public ComputerPlayer getComputerPlayer() {
		return this.theComputer;
	}

	/**
	 * Returns a random Player object.
	 * 
	 * @return a random Player
	 */
	public Player getRandomPlayer() {
		int max = 2;
		int min = 1;
		if (Math.floor(Math.random() * (max - min + 1) + min) == 1) {
			return this.theHuman;
		}
		return this.theComputer;
	}
	
	/**
	 * Returns the Player whose turn it is.
	 * 
	 * @return the current Player
	 */
	public Player getCurrentPlayer() {
		return this.currentPlayerObject.getValue();
	}

	/**
	 * Return whether the game is over.
	 * 
	 * @return true iff currentPlayer.getTotal() >= GOAL_SCORE
	 */
	public boolean isGameOver() {
		if (this.currentPlayerObject.getValue() == null) {
			return true;
		}

		if (this.theHuman.getTotal() >= this.getGoalScore() || this.theComputer.getTotal() >= this.getGoalScore()) {
			return true;
		}
		return false;
	}

	/**
	 * Returns the pair of dice being used in the game
	 * 
	 * @return the pair of dice
	 */
	public DicePair getDicePair() {
		return this.thePair;
	}

	/**
	 * Returns a String showing the goal score, or, if the game is over, the name of
	 * the winner.
	 * 
	 * @return a String representation of this Game
	 */
	public String toString() {
		String result = "Goal Score: " + this.getGoalScore();
		result += System.getProperty("line.separator") + this.theHuman.getName() + ": " + this.theHuman.getTotal();
		result += System.getProperty("line.separator") + this.theComputer.getName() + ": "
				+ this.theComputer.getTotal();

		if (this.theHuman.getTotal() >= this.getGoalScore()) {
			return result + System.getProperty("line.separator") + "Game over! Winner: " + this.theHuman.getName();
		} else if (this.theComputer.getTotal() >= this.getGoalScore()) {
			return result + System.getProperty("line.separator") + "Game over! Winner: " + this.theComputer.getName();
		} else {
			return result;
		}
	}

	/**
	 * Swaps the players so that the other player becomes the current player.
	 */
	private void swapWhoseTurn() {
		Player currentPlayer = this.currentPlayerObject.getValue();
		if (currentPlayer == this.theHuman) {
			this.currentPlayerObject.setValue(this.theComputer);
		} else if (currentPlayer == this.theComputer) {
			this.currentPlayerObject.setValue(this.theHuman);
		}
		currentPlayer.resetTurnTotal();
	}

	@Override
	public void addListener(InvalidationListener theListener) {
		this.currentPlayerObject.addListener(theListener);
	}

	@Override
	public void removeListener(InvalidationListener theListener) {
		this.currentPlayerObject.removeListener(theListener);
	}

	/**
	 * Gets goal score.
	 * 
	 * @return the goalScore
	 */
	public int getGoalScore() {
		return this.goalScore;
	}

	/**
	 * Sets goal score.
	 * 
	 * @param goalScore the goalScore to set
	 */
	public void setGoalScore(int goalScore) {
		this.goalScore = goalScore;
	}

}
