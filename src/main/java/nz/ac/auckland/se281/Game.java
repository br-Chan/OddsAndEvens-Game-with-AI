package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {
  private Player human;
  private Player ai;
  private boolean gameActive;
  private int numOfRounds;
  private List<Player> winHistory;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // Reset the number of rounds count and win history.
    gameActive = true;
    numOfRounds = 0;
    winHistory = new ArrayList<>();

    // Create new Human instance of Player class (overwriting previous object).
    human = new Human(options[0], choice); // options[0] is the name of the player

    // Create new Ai instance of Player class (overwriting previous object) with factory.
    ai = Skynet.createAi(difficulty, choice, human, winHistory);

    MessageCli.WELCOME_PLAYER.printMessage(human.getName());
  }

  public void play() {
    if (!checkGameActive()) {
      return;
    }

    int fingerSum;
    Choice sumEvenOrOdd;
    String sumEvenOrOddString;
    Player winner;

    // Print "Start round: #x:" where x increases by 1 each time a new round starts.
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
    } else {
      winner = ai;
    }
    winHistory.add(winner);
    System.out.println("Win history: " + winHistory);
    MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(fingerSum), sumEvenOrOddString, winner.toString());

  }

  public void endGame() {
    if (!checkGameActive()) {
      return;
    }

    gameActive = false;
  }

  public void showStats() {
    if (!checkGameActive()) {
      return;
    }

    int humanWins = 0;
    int aiWins = 0;

    // Increment human wins every time the human is encountered in win history.
    for (Player player : winHistory) {
      humanWins = (player == human) ? humanWins + 1 : humanWins;
    }

    aiWins = winHistory.size() - humanWins;

    MessageCli.PRINT_PLAYER_WINS.printMessage(human.toString(), Integer.toString(humanWins), Integer.toString(aiWins));
    MessageCli.PRINT_PLAYER_WINS.printMessage(ai.toString(), Integer.toString(aiWins), Integer.toString(humanWins));
  }

  // Checks if a game has been started and hasn't been ended.
  // Prints error message if game has not been started.
  public boolean checkGameActive() {
    if (gameActive) {
      return true;
    } else {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return false;
    }
  }
}
