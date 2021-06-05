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
		this.theGame = theGame;

		this.pnContent = new BorderPane();

		this.addFirstPlayerChooserPane(theGame);

		// TODO: 1. Using the 'first player chooser pane' as a guide
		// Create an HBox with the appropriate style, then make a human
		// player pane and add it to the HBox. Finally add the HBox to the content pane
		this.addHumanPlayerPane(theGame);
		
		// TODO: 2. Using the other panes as a guide, create and add a status pane
		this.addGameStatusPane(theGame);

		// TODO: 3. Using the other panes as a guide, create and add a computer pane
		this.addComputerPlayerPane(theGame);
		
		this.setCenter(this.pnContent);
	}

	/**
	 * Sets up pane for choosing the first player.
	 * 
	 * @param theGame the current game session
	 */
	private void addFirstPlayerChooserPane(Game theGame) {
		HBox topBox = new HBox();
		topBox.getStyleClass().add("pane-border");
		this.pnChooseFirstPlayer = new NewGamePane(theGame);
		topBox.getChildren().add(this.pnChooseFirstPlayer);
		this.pnContent.setTop(topBox);
	}
	
	/**
	 * Sets up pane for viewing the human player status.
	 * 
	 * @param theGame the current game session
	 */
	private void addHumanPlayerPane(Game theGame) {
		HBox humanStatusBox = new HBox();
		humanStatusBox.getStyleClass().add("pane-border");
		this.pnHumanPlayer = new HumanPane(theGame);
		humanStatusBox.getChildren().add(this.pnHumanPlayer);
		this.pnContent.setLeft(humanStatusBox);
	}
	
	/**
	 * Sets up pane for viewing the game information.
	 * 
	 * @param theGame the current game session
	 */
	private void addGameStatusPane(Game theGame) {
		HBox gameStatusBox = new HBox();
		gameStatusBox.getStyleClass().add("pane-border");
		this.pnGameInfo = new StatusPane(theGame);
		gameStatusBox.getChildren().add(this.pnGameInfo);
		this.pnContent.setCenter(gameStatusBox);
	}
	
	/**
	 * Sets up pane for viewing the computer player status.
	 * 
	 * @param theGame the current game session
	 */
	private void addComputerPlayerPane(Game theGame) {
		HBox computerStatusBox = new HBox();
		computerStatusBox.getStyleClass().add("pane-border");
		this.pnComputerPlayer = new ComputerPane(theGame);
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

			// TODO: Instantiate the computer player button and add
			// ComputerFirstListener as its action listener.
			this.radComputerPlayer = new RadioButton(this.theComputer.getName() + " first");
			this.radComputerPlayer.setOnAction(new ComputerFirstListener());

			// TODO: Create a ToggleGroup and add the 2 radio buttons to it.
			ToggleGroup buttonGroup = new ToggleGroup();
			buttonGroup.getToggles().addAll(this.radHumanPlayer, this.radComputerPlayer);
			
			// TODO: Add the 2 radio buttons to this pane.
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
				// TODO: Enable the human player pane and start a game
				// with the human playing first.

			}
		}
	}
}
