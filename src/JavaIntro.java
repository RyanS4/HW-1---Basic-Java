// Name: Ryan Snyder
// Computing ID: csp3pn@virginia.edu
// Homework Name: JavaIntro 
/* Resources Used: https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/util/Random.html (for Random object)
 * https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/lang/String.html#toLowerCase() (for making rpsls non case sensitive using toLowerCase())
 */

import java.util.*;

public class JavaIntro {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    Random randomNumber = new Random();

    // hilo()
    System.out.println("Enter a number above 1 for the computer to guess: ");
    int userSelectedTarget = scan.nextInt();
    System.out.println("Enter the max number the computer can guess: ");
    int userSelectedMax = scan.nextInt();
    System.out.println("Total attempts for computer to guess: " + hilo(userSelectedMax, userSelectedTarget));
    System.out.println();

    // rpsls()
    System.out.println("rock, paper, scissors, lizard, or spock?");
    scan.nextLine();
    String userRpslsChoice = scan.nextLine();
    String[] computerRpslsChoiceArray = {"rock", "paper", "scissors", "lizard", "spock"};
    int computerRpslsChoiceIndex = randomNumber.nextInt(computerRpslsChoiceArray.length);
    System.out.println("Computer chooses " + computerRpslsChoiceArray[computerRpslsChoiceIndex]);
    int winner = rpsls(userRpslsChoice, computerRpslsChoiceArray[computerRpslsChoiceIndex]);
    if (winner == -1) {
      System.out.println("Tie!");
    } else if (winner == 0) {
      System.out.println("Computer wins!");
    } else {
      System.out.println("You win!");
    }

    System.out.println();

    // fuzzbizz()
    System.out.println("Pick a number: ");
    int userFuzzbizzNumber = scan.nextInt();
    System.out.println("First Divisor: ");
    int userFuzzbizzDivisor1 = scan.nextInt();
    System.out.println("Second Divisor: ");
    int userFuzzbizzDivisor2 = scan.nextInt();
    System.out.println(fuzzbizz(userFuzzbizzDivisor1, userFuzzbizzDivisor2, userFuzzbizzNumber));
    System.out.println();

    // countRuns()
    System.out.println("How many numbers will be in your set of numbers: ");
    int userNumberListLength = scan.nextInt();
    int[] userNumberList = new int[userNumberListLength];
    for (int i = 0; i < userNumberListLength; i++) {
      System.out.println("Enter list item #" + (i+1));
      userNumberList[i] = scan.nextInt();
    }

    System.out.println("Number of runs in array: " + countRuns(userNumberList));

    scan.close();
  }



  public static int hilo(int max, int target) {
    boolean correct = false;
    int guessMax = max;
    int guessMin = 1;
    int numberOfAttempts = 0;
    Random randomNumber = new Random();

    for (int i = 1; !correct; i++) {

      int newGuess = randomNumber.nextInt((guessMax - guessMin) + 1) + guessMin;
      System.out.println("This is guess " + i + " and the number is " + newGuess);

      if (newGuess == target) {
        numberOfAttempts = i;
        correct = true;
      } else {
        if (newGuess > target) {
          guessMax = newGuess - 1;
        } else {
          guessMin = newGuess + 1;
        }
      }
    }

    return numberOfAttempts;
  }



  public static int rpsls (String userChoice, String computerChoice) {
    if (userChoice.equals(computerChoice)) {
      return -1;
    }

    int winner = 0;
    
    if ((userChoice.toLowerCase().equals("scissors") && computerChoice.toLowerCase().equals("paper")) ||
      (userChoice.toLowerCase().equals("paper") && computerChoice.toLowerCase().equals("rock")) ||
      (userChoice.toLowerCase().equals("rock") && computerChoice.toLowerCase().equals("lizard")) ||
      (userChoice.toLowerCase().equals("lizard") && computerChoice.toLowerCase().equals("spock")) ||
      (userChoice.toLowerCase().equals("spock") && computerChoice.toLowerCase().equals("scissors")) ||
      (userChoice.toLowerCase().equals("scissors") && computerChoice.toLowerCase().equals("lizard")) ||
      (userChoice.toLowerCase().equals("lizard") && computerChoice.toLowerCase().equals("paper")) ||
      (userChoice.toLowerCase().equals("paper") && computerChoice.toLowerCase().equals("spock")) ||
      (userChoice.toLowerCase().equals("spock") && computerChoice.toLowerCase().equals("rock")) ||
      (userChoice.toLowerCase().equals("rock") && computerChoice.toLowerCase().equals("scissors"))) {
      winner = 1;
    }

    return winner;
  }



  public static String fuzzbizz (int one, int two, int input) {
    boolean divisorCheck = false;
    String outputValue = "";

    if (input % one == 0) {
      outputValue += "fuzz";
      divisorCheck = true;
    }

    if (input % two == 0) {
      outputValue += "bizz";
      divisorCheck = true;
    }

    if (!divisorCheck) {
      outputValue += "none";
    }

    return outputValue;
  }



  public static int countRuns (int[] numbers) {
    int runs = 0;
    int currentRunValue = numbers[0];
    boolean inRun = false;

    for (int i = 0; i < numbers.length - 1; i++) {
      if(currentRunValue == numbers[i + 1]) {
        if (inRun == false) {
          runs++;
        }
        inRun = true;
      } else {
        currentRunValue = numbers[i + 1];
        inRun = false;
      }
    }
    
    return runs;
  }
}
