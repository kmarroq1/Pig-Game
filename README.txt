~Pig Game Synopsis~
A game of pig where a human player plays against the computer, which can adopt a strategy of the user's choosing.

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
-Create rules dialog class.

Notes: 
-Constructors for classes referencing abstract super classes (HumanPlayer and ComputerPlayer) were indirectly tested by using 
 getName method in the corresponding JUnit test classes. This method is similar to using a toString method to test constructors.
-Tested play method from Game class in GUI since it relies on player input.
-Tested playAgain method from Game class in GUI since it relies on player input as a starting point to properly gauge resets.
-Did not test random strategy class rollAgain method or Game class getRandomPlayer method because results are random.