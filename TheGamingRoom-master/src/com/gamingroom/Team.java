package com.gamingroom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A simple class to hold information about a team
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a team is
 * created.
 * </p>
 * @author paul.hatfield@snhu.edu
 *
 */
public class Team extends Entity {
	

	/*
	 * List holds all the active players in the game
	 */
	private static List<Player> players = new ArrayList<Player>();
	
	
	/*
	 * Default Constructor 
	 */
	/**
	 * Hide the default constructor to prevent creating empty instances.
	 */
	private Team() {
		
	}
	
	/*
	 * Constructor with an identifier and name
	 */
	/*
	 * Constructor with an identifier and name
	 */
	// Parameter constructor that calls the Base class Entity Constructor 
	// Will set the id and name properties that are inherited from the Entity Base Class
	public Team(long id, String name) {
		super(id, name);
	}
	

	/*
	 * @return: new Player
	 * @parameter: name-String 
	 */
	public Player addPlayer(String name) {
		
		// local player instance
		Player player = null;
		

		// Implement iterator pattern to traverse Player list
		Iterator<Player> playerIterator = players.iterator();
		
		// Go through playerIterator and see if there exists a player with the same name
		// passed through the parameter
		// If the player exists, return existing player
		// else add new player to players list
		// Implementation of the iterator allows us to traverse any data structure(list, array,etc) in a the same way
		// An iterator provides us simple tools for traversing the data.
		while(playerIterator.hasNext()) {
			player = playerIterator.next();
			if(player.getName().equals(name)) {
				break;
			}
			
			player = null;
		}
		
		// if no player is found, add new player instance to player list
		if(player == null) {
			player = new Player(players.size()+1,name);
			players.add(player);
		}
		
		// return player
		return player;
		
	}


	@Override
	public String toString() {
		return "Team [id=" + this.getId() + ", name=" + this.getName() + "]";
	}
}
