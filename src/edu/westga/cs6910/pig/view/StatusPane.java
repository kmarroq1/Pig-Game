package edu.westga.cs6910.pig.view;

import edu.westga.cs6910.pig.model.Game;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
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
	private CheckMenuItem rulesItem;

	/**
	 * Creates a new status pane that observes the specified game.
	 * 
	 * @param theGame the model object from which this pane gets its data
	 * 
	 * @requires theGame != null
	 */
	public StatusPane(Game theGame) {
		this.theGame = theGame;
		this.rulesItem();
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
	 * Gets rules menu item.
	 * 
	 * @return the rulesItem
	 */
	public CheckMenuItem getRulesItem() {
		return this.rulesItem;
	}

	/**
	 * Sets rules menu item.
	 * 
	 * @param rulesItem the rulesItem to set
	 */
	public void setRulesItem(CheckMenuItem rulesItem) {
		if (rulesItem == null) {
			throw new IllegalArgumentException("Invalid menu item");
		}
		this.rulesItem = rulesItem;
	}

	/**
	 * Shows the rules dialog if the item is selected.
	 */
	public void showRulesDialog() {
		if (this.rulesItem.isSelected()) {
			this.buildRulesDialog().showAndWait();
		} else {
			return;
		}
	}

	/**
	 * Creates rules menu item and adds an event handler.
	 */
	private void rulesItem() {
		this.setRulesItem(new CheckMenuItem("R_ules"));
		this.rulesItem.setSelected(true);
		this.rulesItem.setMnemonicParsing(true);
		this.rulesItem.setAccelerator(new KeyCodeCombination(KeyCode.U, KeyCombination.SHORTCUT_DOWN));
	}

	/**
	 * Builds the rules menu item.
	 * 
	 * @return updated dialog box
	 */
	private Dialog<String> buildRulesDialog() {
		Dialog<String> rulesDialog = new Dialog<String>();
		rulesDialog.setTitle("Instructions");

		TabPane tabPane = new TabPane();
		tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		Tab howToPlay = new Tab();
		howToPlay.setText("How to play");
		Label guiRules = new Label(
				"\nTo opt out of this dialog, uncheck the Rules menu item in the\nGame menu.\n\n1. (Opt.) Set a new goal score\n2. (Opt.) Select a strategy for the computer player\n3. Select the first player\n4. Either Roll/Hold or Take Turn depending on whose turn it is\n5. Play again!");
		howToPlay.setContent(guiRules);
		Tab howToWin = new Tab();
		howToWin.setText("How to win");
		Label winningRules = new Label(
				"\nTo opt out of this dialog, uncheck the Rules menu item in the\nGame menu.\n\nA common strategy includes taking more risks by rolling\nat the beginning of the game. Once you start getting\n closer to the goal score, hold after less rolls.");
		howToWin.setContent(winningRules);
		tabPane.getTabs().addAll(howToPlay, howToWin);
		rulesDialog.setGraphic(tabPane);

		ButtonType okButton = new ButtonType("Ok", ButtonData.OK_DONE);
		rulesDialog.getDialogPane().getButtonTypes().add(okButton);
		rulesDialog.getDialogPane().setMaxWidth(350);

		return rulesDialog;
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
		public void handle(ActionEvent event) {
			if (!StatusPane.this.theGame.isGameOver() || StatusPane.this.theGame.getCurrentPlayer() == null) {
				return;
			} else {
				StatusPane.this.theGame.playAgain();
				StatusPane.this.showRulesDialog();
			}

		}
	}
}
