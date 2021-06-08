package edu.westga.cs6910.pig.view;

import edu.westga.cs6910.pig.model.Game;
import edu.westga.cs6910.pig.model.Player;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

/**
 * Defines a GUI for the Pig game. This class was started by CS6910
 * 
 * @author Kimberly Marroquin
 * @version June 5, 2021
 */
public class PigPane extends BorderPane {
	private Game theGame;
	private BorderPane pnContent;
	private HumanPane pnHumanPlayer;
	private ComputerPane pnComputerPlayer;
	private StatusPane pnGameInfo;
	private Pane pnChooseFirstPlayer;

	/**
	 * Creates a pane object to provide the view for the specified Game model
	 * object.
	 * 
	 * @param theGame the domain model object representing the Pig game
	 * 
	 * @requires theGame != null
	 * @ensures the pane is displayed properly
	 */
	public PigPane(Game theGame) {
		if (theGame == null) {
			throw new IllegalArgumentException("Invalid game");
		}
		this.theGame = theGame;

		this.pnContent = new BorderPane();

		this.addFirstPlayerChooserPane();

		this.addHumanPlayerPane();

		this.addGameStatusPane();

		this.addComputerPlayerPane();

		this.setCenter(this.pnContent);
	}

	/**
	 * Sets up pane for choosing the first player.
	 * 
	 * @param theGame the current game session
	 */
	private void addFirstPlayerChooserPane() {
		HBox topBox = new HBox();
		topBox.getStyleClass().add("pane-border");
		this.pnChooseFirstPlayer = new NewGamePane(this.theGame);
		topBox.getChildren().add(this.pnChooseFirstPlayer);
		this.pnContent.setTop(topBox);
	}

	/**
	 * Sets up pane for viewing the human player status.
	 * 
	 * @param theGame the current game session
	 */
	private void addHumanPlayerPane() {
		HBox humanStatusBox = new HBox();
		humanStatusBox.getStyleClass().add("pane-border");
		this.pnHumanPlayer = new HumanPane(this.theGame);
		humanStatusBox.getChildren().add(this.pnHumanPlayer);
		this.pnContent.setLeft(humanStatusBox);
	}

	/**
	 * Sets up pane for viewing the game information.
	 * 
	 * @param theGame the current game session
	 */
	private void addGameStatusPane() {
		HBox gameStatusBox = new HBox();
		gameStatusBox.getStyleClass().add("pane-border");
		this.pnGameInfo = new StatusPane(this.theGame);
		gameStatusBox.getChildren().add(this.pnGameInfo);
		this.pnContent.setCenter(gameStatusBox);
	}

	/**
	 * Sets up pane for viewing the computer player status.
	 * 
	 * @param theGame the current game session
	 */
	private void addComputerPlayerPane() {
		HBox computerStatusBox = new HBox();
		computerStatusBox.getStyleClass().add("pane-border");
		this.pnComputerPlayer = new ComputerPane(this.theGame);
		computerStatusBox.getChildren().add(this.pnComputerPlayer);
		this.pnContent.setRight(computerStatusBox);
	}

	/**
	 * Defines the panel in which the user selects which Player plays first.
	 */
	private final class NewGamePane extends GridPane {
		private RadioButton radHumanPlayer;
		private RadioButton radComputerPlayer;

		private Game theGame;
		private Player theHuman;
		private Player theComputer;

		private NewGamePane(Game theGame) {
			this.theGame = theGame;

			this.theHuman = this.theGame.getHumanPlayer();
			this.theComputer = this.theGame.getComputerPlayer();

			this.buildPane();
		}

		private void buildPane() {
			this.setHgap(20);

			this.radHumanPlayer = new RadioButton(this.theHuman.getName() + " first");
			this.radHumanPlayer.setOnAction(new HumanFirstListener());

			this.radComputerPlayer = new RadioButton(this.theComputer.getName() + " first");
			this.radComputerPlayer.setOnAction(new ComputerFirstListener());

			ToggleGroup buttonGroup = new ToggleGroup();
			buttonGroup.getToggles().addAll(this.radHumanPlayer, this.radComputerPlayer);

			HBox buttonsBox = new HBox(20, this.radHumanPlayer, this.radComputerPlayer);
			super.add(buttonsBox, 0, 0);
		}

		/**
		 * Defines the listener for computer player first button.
		 */
		private class ComputerFirstListener implements EventHandler<ActionEvent> {
			@Override
			/**
			 * Enables the ComputerPlayerPanel and starts a new game. Event handler for a
			 * click in the computerPlayerButton.
			 */
			public void handle(ActionEvent arg0) {
				PigPane.this.pnComputerPlayer.setDisable(false);
				PigPane.this.pnChooseFirstPlayer.setDisable(true);
				PigPane.this.theGame.startNewGame(NewGamePane.this.theComputer);
			}
		}

		/**
		 * Defines the listener for human player first button.
		 */
		private class HumanFirstListener implements EventHandler<ActionEvent> {
			/**
			 * Sets up user interface and starts a new game. Event handler for a click in
			 * the human player button.
			 */
			@Override
			public void handle(ActionEvent event) {
				PigPane.this.pnChooseFirstPlayer.setDisable(true);
				PigPane.this.pnHumanPlayer.setDisable(false);
				PigPane.this.theGame.startNewGame(NewGamePane.this.theHuman);
			}
		}
	}
}
