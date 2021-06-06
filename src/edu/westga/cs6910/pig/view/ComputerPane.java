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
import javafx.scene.layout.HBox;

/**
 * Defines the pane that lets the user either roll or hold during
 * 	their turn
 * This class was started by CS6910
 * 
 * @author Kimberly Marroquin
 * @version June 5, 2021
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
		this.theGame.addListener(this);
		this.theComputer = this.theGame.getComputerPlayer();
		
		this.buildPane();
	}
	
	/**
	 * Adds elements to construct computer pane.
	 */
	private void buildPane() {
		// TODO: Using the other pane classes as a model, build this pane.
		HBox topBox = new HBox();
		topBox.getStyleClass().add("box-center");	
		topBox.getStyleClass().add("box-padding");
		topBox.getChildren().add(new Label("~~ " + this.theComputer.getName() + " ~~"));
		this.add(topBox, 0, 0, 2, 1);
		
		HBox middleBox = new HBox();
		middleBox.getStyleClass().add("box-padding");		
		middleBox.getChildren().add(new Label("Dice Values: "));
		this.lblDiceValues = new Label("-, -");
		middleBox.getChildren().add(this.lblDiceValues);
		this.add(middleBox, 0, 1);

		HBox buttonBox = new HBox();
		buttonBox.getStyleClass().add("box-padding");
		this.btnTakeTurn = new Button("Take Turn");
		this.btnTakeTurn.setOnAction(new TakeTurnListener());
		buttonBox.getChildren().add(this.btnTakeTurn);
		
		HBox bottomBox = new HBox();
		bottomBox.getStyleClass().add("box-padding");
		bottomBox.getChildren().add(new Label("Turn Total: "));
		this.lblTurnTotal = new Label("0");
		bottomBox.getChildren().add(this.lblTurnTotal);
		this.add(bottomBox, 0, 3);
	}

	/**
	 * Sets UI to show when it is the computer's turn in the game.
	 */
	@Override
	public void invalidated(Observable theObservable) {
		boolean myTurn = this.theGame.getCurrentPlayer() == this.theComputer;
		
		if (!myTurn) {
			// TODO: Set the user interface to show the results
			// of the computer rolling the dice
			int turnTotal = this.theComputer.getTurnTotal();
			String result = this.theComputer.getDiceValues();
			this.lblDiceValues.setText(result);
			this.lblTurnTotal.setText("" + turnTotal);
		} 
		// TODO: Disable this Pane if it is no longer the computer's turn, enable it if
		// it is the computer's turn
		this.setDisable(!myTurn);
		
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
