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

  /**
   * Starts a new game of ODD OR EVEN, overwriting any previously existing game.
   * A Human object and Ai object are created, and a welcome message including
   * the human player's name will be printed.
   * 
   * @param difficulty the difficulty of the AI.
   * @param choice the choice between ODD and EVEN that the human player must achieve.
   * @param options options[0] is the name that the human player has inputted.
   */
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

  /**
   * Plays a round of the current game, if a game has been created.
   * The current number of the round is printed depending on how many rounds have been played
   * in this game. The Ai picks a number from 0 to 5 and the human player is prompted to do the
   * same. These numbers are printed, the sum is calculated and the winner of the round is 
   * determined (e.g. if the human player's choice was ODD, the human wins if the sum of the
   * two numbers is ODD).
   * <p>
   * The round's winner is added to the arraylist winHistory.
   */
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

  /**
   * If a game has been started, shows the stats of the game, determines the winner -
   * whoever has won more games - and ends the current game. Ties are possible.
   */
  public void endGame() {
    if (!checkGameActive()) {
      return;
    }

    showStats();

    int humanWins = getHumanWins();
    int aiWins = winHistory.size() - humanWins;

    // If the human and AI have equal wins, print tie message. Print the winner toherwise.
    if (humanWins == aiWins) {
      MessageCli.PRINT_END_GAME_TIE.printMessage();
    } else {
      String winner = humanWins > aiWins ? human.getName() : ai.getName();
      MessageCli.PRINT_END_GAME.printMessage(winner);
    }


    gameActive = false;
  }

  /**
   * If a game has been started, prints the wins and losses of each player.
   */
  public void showStats() {
    if (!checkGameActive()) {
      return;
    }

    int humanWins = getHumanWins();
    int aiWins = winHistory.size() - humanWins;

    MessageCli.PRINT_PLAYER_WINS.printMessage(human.toString(), Integer.toString(humanWins), Integer.toString(aiWins));
    MessageCli.PRINT_PLAYER_WINS.printMessage(ai.toString(), Integer.toString(aiWins), Integer.toString(humanWins));
  }

  /**
   * Checks if a game has been started and has not been ended.
   * An error message is printed if a game has not been started.
   * 
   * @return true if a game has been started and not ended, false otherwise.
   */
  public boolean checkGameActive() {
    if (gameActive) {
      return true;
    } else {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return false;
    }
  }

  /**
   * Iterates through the winHistory arraylist and adds up the number of times
   * the human player occurs.
   * 
   * @return the number of rounds the human has won in this game.
   */
  public int getHumanWins() {
    int humanWins = 0;

    // Increment human wins every time the human is encountered in win history.
    for (Player player : winHistory) {
      humanWins = (player == human) ? humanWins + 1 : humanWins;
    }

    return humanWins;
  }

}
