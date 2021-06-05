package edu.westga.cs6910.pig.view;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.Game;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 * Defines the pane that lets the user either roll or hold during
 * 	their turn
 * This class was started by CS6910
 * 
 */
public class ComputerPane extends GridPane implements InvalidationListener {
	private Label lblDiceValues;
	private Label lblTurnTotal;
	private Button btnTakeTurn;
	
	private ComputerPlayer theComputer;
	private Game theGame;

	/**
	 * Creates a new ComputerPane that observes the specified game. 
	 * 
	 * @param theGame	the model object from which this pane gets its data
	 * 
	 * @requires 	theGame != null
	 */
	public ComputerPane(Game theGame) {
		this.theGame = theGame;
		
		// TODO: Add this object as an listener of the Game.
		
		this.theComputer = this.theGame.getComputerPlayer();
		
		this.buildPane();
	}
	
	private void buildPane() {
		// TODO: Using the other pane classes as a model, build this pane.

	}

	@Override
	public void invalidated(Observable theObservable) {
		boolean myTurn = this.theGame.getCurrentPlayer() == this.theComputer;
		
		if (!myTurn) {
			// TODO: Set the user interface to show the results
			// of the computer rolling the dice

		} 
		// TODO: Disable this Pane if it is no longer the computer's turn, enable it if
		// it is the computer's turn

		if (this.theGame.isGameOver()) {
			this.setDisable(true);
			return;
		}
	}

	/** 
	 * Defines the listener for takeTurnButton.
	 */
	private class TakeTurnListener implements EventHandler<ActionEvent> {

		/** 
		 * Tells the Game to have its current player (i.e., the computer player)
		 * take its turn.	
		 * 
		 * @see javafx.event.EventHandler#handle(T-extends-javafx.event.Event)
		 */
		@Override
		public void handle(ActionEvent arg0) {
			// TODO: if the game isn't finished: 
			//		 - Set the maximum number of rolls
			//		 - Tell theGame to play a move.

		}
	}
}
