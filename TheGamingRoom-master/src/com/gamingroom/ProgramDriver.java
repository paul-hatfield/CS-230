package com.gamingroom;

/**
 * Application start-up program
 * 
 * @author paul.hatfield@snhu.edu
 */
public class ProgramDriver {
	
	/**
	 * 
	 * @param args command line arguments
	 */
	public static void main(String[] args) {

		GameService service = GameService.getReference();
		GameService.getReference();
		System.out.println("\nAbout to test initializing game data...");
		/*
		 * Testing creating multiple games
		 */
		Game game1 = service.addGame("Game #1");
		System.out.println(game1);
		
		Game game2 = service.addGame("Game #2"); 
		System.out.println(game2);
		
		Game game3 = service.addGame("Paul");
		System.out.println(game3);
	
		// Attempt to create a game with an existing name
		// it will just return the existing game
		Game game4 = service.addGame("Paul");
		System.out.println(game4);
		
		
		// Print out all the existing games
		// use another class to prove there is only one instance
		SingletonTester tester = new SingletonTester();
		tester.testSingleton();
		
		System.out.println("\n\n");
		
		/*
		 * Testing creating teams for the first game in the GameService
		 */
		System.out.println("Creating Teams For first Game in the GameSerivce");
		System.out.println(service.getGame(0).addTeam("Blue Team"));
		System.out.println(service.getGame(0).addTeam("Orange Team"));
		System.out.println(service.getGame(0).addTeam("Purple Team"));
		//Attempting to create a team that already exists with the same name
		// it will just return the already existing team
		System.out.println(service.getGame(0).addTeam("Purple Team"));
		
		
		System.out.println("\n\n");
		
		/*
		 * Test adding players to multiple teams in the first game in the GameService
		 */
			
		System.out.println("Add players to the different teams in the first Game in teh GamesService");
		System.out.println(service.getGame(0).addTeam("Purple Team").addPlayer("Joe").toString());
		System.out.println(service.getGame(0).addTeam("Blue Team").addPlayer("Thomas").toString());
		System.out.println(service.getGame(0).addTeam("Orange Team").addPlayer("Donald").toString());
		System.out.println(service.getGame(0).addTeam("Purple Team").addPlayer("Jose").toString());
		System.out.println(service.getGame(0).addTeam("Blue Team").addPlayer("Paul").toString());
		// test adding a player to the Blue Team with a name that has already been taken
		// it will return the existing player with the name
		System.out.println(service.getGame(0).addTeam("Blue Team").addPlayer("Paul").toString()); 
		
		
		


		
	}
}
