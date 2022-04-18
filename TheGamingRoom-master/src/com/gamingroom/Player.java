package com.gamingroom;

/**
 * A simple class to hold information about a player
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a player is
 * created.
 * </p>
 * @author paul.hatfield@snhu.edu
 *
 */
public class Player extends Entity {
	
	/*
	 *
	 */
	/**
	 * Hide the default constructor to prevent creating empty instances.
	 */
	private Player() {
		
	}
	
	/*
	 * Constructor with an identifier and name
	 */
	// Parameter constructor that calls the Base class Entity Constructor 
	// Will set the id and name properties that are inherited from the Entity Base Class
	public Player(long id, String name) {
		super(id, name);
	}

	@Override
	public String toString() {
		return "Player [id=" + this.getId() + ", name=" + this.getName()+ "]";
	}
}
