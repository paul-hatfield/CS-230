package com.gamingroom;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

/**
 * A singleton service for the game engine
 * 
 * @author paul.hatfield@snhu.edu
 */
public class GameService {

	/**
	 * Properties
	 */
	private static List<Game> games = new ArrayList<Game>();// holds list of all the active games
	private static long nextGameId = 1; // holds next game identifier
	private static long nextPlayerId = 1; // holds next player identifier
	private static long nextTeamId = 1; // holds next team identifier

	// FIXME: Add missing pieces to turn this class a singleton 
	private static GameService reference;
	
	// Return reference to Singleton Game Service
	// if the reference is already set, return reference
	// if the referenece does not exists, create a new GameService and return
	// This singleton pattern implementation will ensure only one instance of the GameService class will exist in our application.
	// There is no need to create multiple instances of the GameService class.
	public static GameService getReference() {
		
		// check if reference already exists
		if(reference == null)
			reference = new GameService();
		
		return reference;
	}

	/**
	 * Construct a new game instance
	 * 
	 * @param name the unique name of the game
	 * @return the game instance (new or existing)
	 */
	public Game addGame(String name) {

		// a local game instance
		Game game = null;

		// FIXME: Use iterator to look for existing game with same name
		// if found, simply return the existing instance
		// Implementation of the iterator allows us to traverse any data structure(list, array,etc) in a the same way
		// An iterator provides us simple tools for traversing the data.
		Iterator<Game> gamesIterator = games.iterator(); // create iterator
		
		// Go through the gamesIterator while an entry exists
		// set the game variable to the next item in the iterator
		// see if game variable has a game with the same name of the new game
		// if it exists, exit loop and return existing game
		// it does not exists set game to null and add new game to games list
		while(gamesIterator.hasNext()) {
			game = gamesIterator.next();
			if(game.getName().equals(name)) {
				break;
			}
			game = null;
		}
		
		
		// if not found, make a new game instance and add to list of games
		if (game == null) {
			game = new Game(nextGameId++, name);
			games.add(game);
		}

		// return the new/existing game instance to the caller
		return game;
	}

	/**
	 * Returns the game instance at the specified index.
	 * <p>
	 * Scope is package/local for testing purposes.
	 * </p>
	 * @param index index position in the list to return
	 * @return requested game instance
	 */
	 Game getGame(int index) {
		return games.get(index);
	}
	
	/**
	 * Returns the game instance with the specified id.
	 * 
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	public Game getGame(long id) {

		// a local game instance
		Game game = null;

		// FIXME: Use iterator to look for existing game with same id
		// if found, simply assign that instance to the local variable
		
		
		Iterator<Game> gamesIterator = games.iterator(); // create iterator
		
		//while iterator has something loop through
		// set the game variable with the next game in the iterator
		// see if that game has matching id
		// if it exists, return existing game
		// else return null once the iterator finishes
		// Implementation of the iterator allows us to traverse any data structure(list, array,etc) in a the same way
		// An iterator provides us simple tools for traversing the data.
		while(gamesIterator.hasNext()) {
			game = gamesIterator.next();
			if(game.getId() == id)
				return game;
		}
		
		return null;
		
	}

	/**
	 * Returns the game instance with the specified name.
	 * 
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Game getGame(String name) {

//		// a local game instance
		Game game = null;
//
//		// FIXME: Use iterator to look for existing game with same name
		Iterator<Game> gamesIterator = games.iterator();
		
		//while iterator has something loop through
		// set the game variable with the next game in the iterator
		// see if that game has matching name
		// if it exists, return existing game
		// else return null once the iterator finishes
		// Implementation of the iterator allows us to traverse any data structure(list, array,etc) in a the same way
		// An iterator provides us simple tools for traversing the data.
		while(gamesIterator.hasNext()) {
			game = gamesIterator.next();
			if(game.getName().equals(name))
				return game;
		}
		
		return null;
	}

	/**
	 * Returns the number of games currently active
	 * 
	 * @return the number of games currently active
	 */
	public int getGameCount() {
		return games.size();
	}
	
	/**
	 * Returns the next player id
	 * 
	 * @return the next player id
	 */
	public long getNextPlayerId() {
		return nextPlayerId++;
	}
	
	/**
	 * Returns the next team id
	 * 
	 * @return the next team id
	 */
	public long getNextTeamId() {
		return nextTeamId++;
	}
}
