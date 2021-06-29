~Pig Game Synopsis~
A game of pig where a human player plays against the computer, which can adopt a strategy of the user's choosing.

Version 2.5 Features:

~Pick For Me~
A new radio button was added that will enable the app to choose a first player on behalf of the user.
A button and listener was added in the PigPane class, and a new randomizer method was added to the Game class. 
The button in the view called on the randomizer method in the Game model class in order to follow the MVC design pattern.

~Rules~
A menu item was added to the Game menu in the PigPane class. Upon clicking it (either with your mouse or shortcut), 
it presents a dialog with a list of instructions that familiarize the user with the GUI. I decided to go with a dialog 
box because it does not interrupt the current PigPane layout, while also having the flexibility to appear and disappear 
at the click of a button.

~Goal Score~
A text field was added to the StatusPane class that allows the user to enter (make sure you actually click enter) a new
goal score. In order to execute this, the previous goal score instance variable was changed to private status with a 
corresponding getter and setter method. I decided to add the text field to the status pane because I found it to be the
most esthetically pleasing pane to place it in. I also made sure to disable the field while the game is ongoing, so that
it doesn't distract the user or add unnecessary complexity to the game from being altered mid-game.

~Play Again~
A play again button was added to the StatusPane class. When pressed, it calls on a method in the Game class called playAgain,
which makes use of the AbstractPlayer class to reset all the scores for both players, then enables the pane for the 
player chosen at the beginning of the first game. I chose to document the first player via an instance variable in the Game
class and use that for starting every new game, but future versions may adopt a model that allows the first player for each
new game to be the player that won the previous round. I chose to place the play again button in the StatusPane because I
wanted the button to be easy to find. A future version, I may change the playAgain button into a dialog prompt so as to keep
the game GUI even more sleek.

Prerequesites:

VM Argument
--module-path "${eclipse_home}/javafx-sdk-14.0.2.1/lib" --add-modules javafx.controls,javafx.fxml

Technologies Used:
-Java
-JavaFX
-Eclipse
-HTML/CSS

To-do:
-Add game to frontend.
-Make computer take its turn automatically.

Notes: 
-Constructors for classes referencing abstract super classes (HumanPlayer and ComputerPlayer) were indirectly tested by using 
 getName method in the corresponding JUnit test classes. This method is similar to using a toString method to test constructors.
-Tested play method from Game class in GUI since it relies on player input.
-Tested playAgain method from Game class in GUI since it relies on player input as a starting point to properly gauge resets.
-Did not test random strategy class rollAgain method or Game class getRandomPlayer method because results are random.