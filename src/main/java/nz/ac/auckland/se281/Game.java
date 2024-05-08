package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {
  private Player human;
  private Player ai;
  private int numOfRounds;
  private List<Integer> winHistory;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // Reset the number of rounds count and win history.
    numOfRounds = 0;
    winHistory = new ArrayList<>();

    // Create new Human instance of Player class (overwriting previous object).
    human = new Human(options[0], choice); // options[0] is the name of the player

    // Create new Ai instance of Player class (overwriting previous object) with factory.
    ai = Skynet.createAi(difficulty, choice, human, winHistory);

    MessageCli.WELCOME_PLAYER.printMessage(human.getName());
  }

  public void play() {
    int fingerSum;
    Choice sumEvenOrOdd;
    String sumEvenOrOddString;
    Player winner;

    // Print "Start round: #x:" where x increases by 1 each time play is invoked.
    ++numOfRounds;
    MessageCli.START_ROUND.printMessage(Integer.toString(numOfRounds));

    // Get the human and AI to pick their number of fingers.
    String aiNumOfFingers = ai.pickFingers();
    String humanNumOfFingers = human.pickFingers();

    // Print the name and number of fingers of each player.
    MessageCli.PRINT_INFO_HAND.printMessage(human.getName(), humanNumOfFingers);
    MessageCli.PRINT_INFO_HAND.printMessage(ai.getName(), aiNumOfFingers);

    // Determine the round outcome.
    // TODO: improve this code, e.g. make it its own method, etc
    fingerSum = Integer.valueOf(humanNumOfFingers) + Integer.valueOf(aiNumOfFingers);
    if (Utils.isEven(fingerSum)) {
      sumEvenOrOdd = Choice.EVEN;
      sumEvenOrOddString = "EVEN";
    } else {
      sumEvenOrOdd = Choice.ODD;
      sumEvenOrOddString = "ODD";
    }
    if (human.getTarget().equals(sumEvenOrOdd)) {
      winner = human;
      winHistory.add(1);
    } else {
      winner = ai;
      winHistory.add(-1);
    }
    MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(fingerSum), sumEvenOrOddString, winner.toString());

  }

  public void endGame() {}

  public void showStats() {}
}
