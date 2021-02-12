/* Name: Cole Ternes
 * ID: 2323955
 * Description: Program calculates the population of a green crud colony
 * that grows at the same rate as the Fibonacci sequence based off of the
 * user's input.
 */
import java.util.Scanner;

public class Fibonacci {
  public static void main(String[] args) {
    Scanner sin = new Scanner(System.in);
    /*
     * Day 0 - 10 lbs.
     * Day 5 - 10 lbs.
     * Day 10 - 20 lbs.
     * Day 15 - 30 lbs.
     * Day 20 - 50 lbs.
     */

     //Variables for Calculations
     String response = " ";
     String spacing = " ";
     char cont = ' ';
     int total = 0;
     int userDays = 0;
     int every5Days = 0;

     //Allows the calculation to be repeated for as long as the user wants
     do {
       //Resets the variables to 0 each iteration of calculating
       int f0 = 0;
       int f1 = 0;

       //User enters initial population and days
       System.out.println("Input the initial weight of the Green Crud population:");
       f0 = sin.nextInt();
       System.out.println("Input the number of days:");
       userDays = sin.nextInt();

       //Crud grows every 5 days
       every5Days = (userDays / 5);

       //Sets the two first values to be equal each other (based on Fibonacci)
       f1 = f0;

      //Calculates the total weight of the colony after so many days
       for (int i = 0; i < every5Days-1; i++) {
         total = f0 + f1;
         f0 = f1;
         f1 = total;
       }
       if (userDays <= 5) {
         total = f0;
       }

       //Prints the total after days based off of user's input
       System.out.println("\nAfter " + userDays + " Days, the Green Crud population is " + total + " lbs.");
       spacing = sin.nextLine();

       //Allows the user to calculate again before exiting the program
       System.out.println("\nDo you wish to calculate the population again? (y/n)");
       response = sin.nextLine();
       cont = response.charAt(0);
       f0 = 0;
       f1 = 0;
     } while (cont == 'Y' || cont == 'y');
  }
}
