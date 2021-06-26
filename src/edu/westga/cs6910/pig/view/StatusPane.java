package edu.westga.cs6910.pig.view;

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
 * Defines the pane that lets the user tell the computer player to take its turn
 * and that displays the die values the computer player took on its turn.
 * 
 * @author CS6910
 * @version Summer 2021
 */
public class StatusPane extends GridPane implements InvalidationListener {
	private Game theGame;
	private Label lblStatus;
	private Button playAgain;

	/**
	 * Creates a new status pane that observes the specified game.
	 * 
	 * @param theGame the model object from which this pane gets its data
	 * 
	 * @requires theGame != null
	 */
	public StatusPane(Game theGame) {
		this.theGame = theGame;

		this.theGame.addListener(this);

		this.buildPane();
	}

	private void buildPane() {
		HBox topBox = new HBox();
		topBox.getStyleClass().add("box-center");
		topBox.getStyleClass().add("box-padding");
		topBox.getChildren().add(new Label("~~ Game Info ~~"));
		this.add(topBox, 0, 0);

		HBox middleBox = new HBox();
		middleBox.getStyleClass().add("box-padding");
		this.lblStatus = new Label(this.theGame.toString());
		middleBox.getChildren().add(this.lblStatus);
		this.add(middleBox, 0, 1);

		HBox buttonBox = new HBox();
		this.playAgain = new Button("Play Again");
		this.playAgain.setOnAction(new PlayAgainListener());
		buttonBox.getChildren().add(this.playAgain);
		this.add(buttonBox, 0, 2);
	}

	@Override
	public void invalidated(Observable observable) {
		this.lblStatus.setText(this.theGame.toString());

		if (this.theGame.isGameOver()) {
			this.playAgain.setDisable(false);
		} else {
			this.playAgain.setDisable(true);
		}
	}

	/**
	 * Defines the listener for playAgain button.
	 */
	private class PlayAgainListener implements EventHandler<ActionEvent> {

		/**
		 * Tells the Game to reset.
		 * 
		 * @see javafx.event.EventHandler#handle(T extends javafx.event.Event)
		 */
		@Override
		public void handle(ActionEvent arg0) {
			if (!StatusPane.this.theGame.isGameOver() || StatusPane.this.theGame.getCurrentPlayer() == null) {
				return;
			} else {
				StatusPane.this.theGame.playAgain();
			}
		}
	}
}
