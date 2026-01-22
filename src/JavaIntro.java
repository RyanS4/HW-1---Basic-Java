// Name: Ryan Snyder
// Computing ID: csp3pn@virginia.edu
// Homework Name: JavaIntro 
// Resources Used: N/A

import java.util.*;

public class JavaIntro {
  public static void main(String[] args) {
    int[] test = {1,1,1,3,4,3,5,5,5,3,3,1,1,8,2,8,2,8,2,8,2};
    System.out.println(countRuns(test));
  }



  public static int hilo(int max, int target) {
    boolean correct = false;
    int guessMax = max;
    int guessMin = 1;
    int numberOfAttempts = 0;

    for (int i = 1; !correct; i++) {

      Random randomNumber = new Random();
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



  public static int rpssl (String userChoice, String computerChoice) {
    if (userChoice.equals(computerChoice)) {
      return -1;
    }

    int winner = 0;
    
    if ((userChoice.equals("scissors") && computerChoice.equals("paper")) ||
      (userChoice.equals("paper") && computerChoice.equals("rock")) ||
      (userChoice.equals("rock") && computerChoice.equals("lizard")) ||
      (userChoice.equals("lizard") && computerChoice.equals("spock")) ||
      (userChoice.equals("spock") && computerChoice.equals("scissors")) ||
      (userChoice.equals("scissors") && computerChoice.equals("lizard")) ||
      (userChoice.equals("lizard") && computerChoice.equals("paper")) ||
      (userChoice.equals("paper") && computerChoice.equals("spock")) ||
      (userChoice.equals("spock") && computerChoice.equals("rock")) ||
      (userChoice.equals("rock") && computerChoice.equals("scissors"))) {
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
