package edu.westga.cs6910.pig.model;

/**
 * HumanPlayer represents a human player in the game Pig.
 * 
 * @author CS6910
 * @version Summer 2021
 */
public class HumanPlayer extends AbstractPlayer {
	
	/**
	 * Creates a new ComputerPlayer with the specified name.
	 * 
	 * @param name	this Player's name
	 * 
	 * @requires	name != null
	 * @ensure		name().equals(name) && getTotal() == 0
	 */
	public HumanPlayer(String name) {
		super(name);
	}
}
