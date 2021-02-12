/* Name: Cole Ternes
 * ID: 2323955
 * Description: The user plays a game of Pig against the computer. First to
 * reach 100 wins.
 */
 import java.util.Scanner;
 import java.util.Random;

public class Pig {
  public static void main(String[] args) {
    Scanner sin = new Scanner(System.in);
    Random rnd = new Random();
    String spacing = " ";

    //Game scores
    int p1Score = 0;
    int p2Score = 0;

    //Switches between Player 1 and Computer
    boolean playerSwitch = true;

    //While-Loop continues to iterate until either the player or computer reaches 100
    while (true) {
      //Variables used
      String response = " ";
      char roll_or_hold = ' ';
      int tempTotal = 0;

      //Prints whos turn it is
      if (playerSwitch) {
        System.out.println("It is Player 1's turn.");
      } else {
        System.out.println("It is the Computer's turn.");
      }

      //Makes it so the first iteration through it automatically rolls
      roll_or_hold = 'r';

      //While-Loop continues to iterate until player types hold, a 1 is rolled, or computer reaches a tempTotal of 20
      while (roll_or_hold == 'r' || roll_or_hold == 'R') {
        //"Rolls" the dice
        int diceNum = rnd.nextInt(6) + 1;

        //Switch statement to decide what action is taken depending on the value of the dice roll
        switch (diceNum) {
          case 1:
            //Only prints if the its the player's turn
            if (playerSwitch) {
              System.out.println("You rolled a 1!\n\nYou lose all points earned from this turn.\nPress 'ENTER' to continue.");
              spacing = sin.nextLine();
            }

            //Sets the tempTotal to 0
            tempTotal = 0;
            break;
          case 2:
            //Increases the tempTotal by 2
            tempTotal += 2;

            //Only prints if the its the player's turn
            if (playerSwitch) {
              System.out.println("You rolled a 2.\n\nThis brings your turn's total to " + tempTotal + ".");
            }
            break;
          case 3:
            //Increases the tempTotal by 3
            tempTotal += 3;

            //Only prints if the its the player's turn
            if (playerSwitch) {
              System.out.println("You rolled a 3.\n\nThis brings your turn's total to " + tempTotal + ".");
            }
            break;
          case 4:
            //Increases the tempTotal by 4
            tempTotal += 4;

            //Only prints if the its the player's turn
            if (playerSwitch) {
              System.out.println("You rolled a 4.\n\nThis brings your turn's total to " + tempTotal + ".");
            }
            break;
          case 5:
            //Increases the tempTotal by 5
            tempTotal += 5;

            //Only prints if the its the player's turn
            if (playerSwitch) {
              System.out.println("You rolled a 5.\n\nThis brings your turn's total to " + tempTotal + ".");
            }
            break;
          case 6:
            //Increases the tempTotal by 6
            tempTotal += 6;

            //Only prints if the its the player's turn
            if (playerSwitch) {
              System.out.println("You rolled a 6.\n\nThis brings your turn's total to " + tempTotal + ".");
            }
            break;
          default:
            //Error message
            System.out.println("Error in switch statement evaluating dice roll.");
        }

        //If its the player's turn and a 1 is rolled, then break
        if (playerSwitch && diceNum == 1) {
          break;
        }
        //Else if its the computer's turn and a 1 is rolled, then print to screen what happened so that the player can understand
        else if (!playerSwitch && diceNum == 1){
          System.out.println("The computer gained " + tempTotal + " points in their turn.");
          break;
        }

        //If its the player's turn, then prompt them to roll again
        if (playerSwitch) {
          System.out.println("Would you like to roll again or hold? (r/h)");
          response = sin.nextLine();
          roll_or_hold = response.charAt(0);
        }
        //Else if its the computer's turn and tempTotal >= 20, then the computer can break
        else if (!playerSwitch && tempTotal >= 20) {
          System.out.println("The computer gained " + tempTotal + " points in their turn.");
          break;
        }
      }

      //If its the player's turn, then add the tempTotal to their turn and switch to the computer's turn
      if (playerSwitch) {
        p1Score += tempTotal;
        playerSwitch = false;
      }
      //Else if its the computer's turn, then add the tempTotal to their turn and switch to the player's turn
      else {
        p2Score += tempTotal;
        playerSwitch = true;
      }

      //If the player reached 100 points, then print that they have won
      if (p1Score >= 100) {
        System.out.println("\n\n\nPlayer 1 wins! The scores were:\nPlayer 1 = " + p1Score + "\nComputer = " + p2Score);
        break;
      }
      //Else if the computer reached 100 points, then print that it won (again grrrrr)
      else if (p2Score >= 100) {
        System.out.println("\n\n\nPlayer 2 wins! The scores were:\nPlayer 1 = " + p1Score + "\nComputer = " + p2Score);
        break;
      }

      //Print out the score box
      System.out.println("\n\n===========SCORE===========\nPlayer 1's score is " + p1Score + "\nThe computer's score is " + p2Score + "\n===========================\n\n");
      System.out.println("\nPress 'ENTER' to continue.");
      spacing = sin.nextLine();
    }
  }
}
