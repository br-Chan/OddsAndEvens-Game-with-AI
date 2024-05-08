package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {
  private Player human;
  private Player ai;
  private int numOfRounds = 0;
  private int fingerSum;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {

    // Create new Human instance of Player class (overwriting previous object).
    human = new Human(options[0], choice); // options[0] is the name of the player

    // Create new Ai instance of Player class (overwriting previous object) with factory.
    ai = Skynet.createAi(difficulty, choice);

    MessageCli.WELCOME_PLAYER.printMessage(human.getName());
  }

  public void play() {
    Choice sumEvenOrOdd;
    String sumEvenOrOddString;
    Player winner;

    // Print "Start round: #x:" where x increases by 1 each time play is invoked.
    ++numOfRounds;
    MessageCli.START_ROUND.printMessage(Integer.toString(numOfRounds));

    // Get the human and AI to pick their number of fingers.
    String humanNumOfFingers = human.pickFingers();
    String aiNumOfFingers = ai.pickFingers();

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
    } else {
      winner = ai;
    }
    MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(fingerSum), sumEvenOrOddString, winner.toString());

  }

  public void endGame() {}

  public void showStats() {}
}
