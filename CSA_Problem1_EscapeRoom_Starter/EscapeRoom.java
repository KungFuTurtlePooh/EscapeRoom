/*
* Problem 1: Escape Room
* 
* V1.0
* 10/10/2019
* Copyright(c) 2019 PLTW to present. All rights reserved
*/
import java.util.Scanner;

/**
 * Create an escape room game where the player must navigate
 * to the other side of the screen in the fewest steps, while
 * avoiding obstacles and collecting prizes.
 */
public class EscapeRoom
{

      // describe the game with brief welcome message
      // determine the size (length and width) a player must move to stay within the grid markings
      // Allow game commands:
      //    right, left, up, down: if you try to go off grid or bump into wall, score decreases
      //    jump over 1 space: you cannot jump over walls
      //    if you land on a trap, spring a trap to increase score: you must first check if there is a trap, if none exists, penalty
      //    pick up prize: score increases, if there is no prize, penalty
      //    help: display all possible commands
      //    end: reach the far right wall, score increase, game ends, if game ended without reaching far right wall, penalty
      //    replay: shows number of player steps and resets the board, you or another player can play the same board
      // Note that you must adjust the score with any method that returns a score
      // Optional: create a custom image for your player use the file player.png on disk
    
      /**** provided code:
      // set up the game
      boolean play = true;
      while (play)
      {
        // get user input and call game methods to play 
        play = false;
      }
      */

  public static void main(String[] args) 
  {      
    // welcome message
    System.out.println("Welcome to EscapeRoom!");
    System.out.println("Get to the other side of the room, avoiding walls and invisible traps,");
    System.out.println("pick up all the prizes.\n");
    
    GameGUI game = new GameGUI();
    game.createBoard();

    // size of move
    int m = 60; 
    // individual player moves
    int px = 0;
    int py = 0; 
    
    int score = 0;

    Scanner in = new Scanner(System.in);
    String[] validCommands = { "right", "left", "up", "down", "r", "l", "u", "d",
    "jump", "jr", "jumpleft", "jl", "jumpup", "ju", "jumpdown", "jd",
    "pickup", "p", "quit", "q", "replay", "help", "?"};
  
    // set up game
    boolean play = true;
    while (play)
    {
      /* TODO: get all the commands working */
    /* Your code here */
    
      // Prompts and gets user input
      System.out.println("Please input a command");
      String input = UserInput.getValidInput(validCommands);
      score += UserInput.getDeductedPoints();


      /* 
       * This if/else if block is used to determine what the user wants to do.
       * If the user wants to move, then their px & py are modified so that 
       * later on, it would use these values to move the player using the 
       * method .movePlayer();
       */
      // Checks if user wants to quit
      if(input.equals("quit") || input.equals("q")) {
        play = false;
      }
      // Checks if user needs the list of commands
      else if(input.equals("help") || input.equals("?") || input.equals("h")) {
        System.out.print("Valid Inputs: ");
        for(String str : validCommands) {
          System.out.print(" " + str + ", ");
        }
        System.out.println();
      } 
      // Checks if the user wants to go right
      else if(input.equals("right") || input.equals("r")) {
        px = m;
        py = 0;
      } 
      // Checks if the user wants to jump right two spaces
      else if(input.equals("jump") || input.equals("jr")) {
        px = 2*m;
        py = 0;
      } 
      // Checks if the user wants to go left
      else if(input.equals("left") || input.equals("l")) {
        px = -m;
        py = 0;
      } 
      // Checks if the user wants to jump left 2 spaces
      else if(input.equals("jumpleft") || input.equals("jl")) {
        px = -2*m;
        py = 0;
      }
      // Checks if the user wants to go up the board
      else if(input.equals("up") || input.equals("u")) {
        px = 0;
        py = -m;
      }
      // Checks if the user wants to jump 2 spaces up the board
      else if(input.equals("jumpup") || input.equals("ju")) {
        px = 0;
        py = -2*m;
      }
      // Checks if the user wants to go down the board
      else if(input.equals("down") || input.equals("d")) {
        px = 0;
        py = m;
      }
      // Checks if the user wants to jump 2 spaces down
      else if(input.equals("jumpdown") || input.equals("jd")) {
        px = 0;
        py = 2*m;
      }
      // Checks if the user wants to pickup potential coins at their location
      else if(input.equals("pickup") || input.equals("p")) {
        score += game.pickupPrize();
      }
      // Checks if the user wants to replay
      else if(input.equals("replay")) {
        score += game.replay();
        System.out.println("score=" + score);
        System.out.println("steps=" + game.getSteps());
        
        System.out.println("GAME RESET");
        score = 0;
      }
      

      // This conditional checks to make sure it does not move the pieces if a command
      // inputted does not move.
      if(!(input.equals("pickup") || input.equals("p") || input.equals("quit") || input.equals("q") || input.equals("help") || input.equals("?") || input.equals("h"))){
        score += game.movePlayer(px, py);
      }

      // Prints out current score.
      System.out.println("score=" + score);
    }

  

    score += game.endGame();

    System.out.println("score=" + score);
    System.out.println("steps=" + game.getSteps());
  }
}

        