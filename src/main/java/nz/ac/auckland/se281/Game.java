package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {
  String playerName = null;
  int numOfRounds = 0;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // the first element of options[0]; is the name of the player
    playerName = options[0];

    // Print Welcome message.
    MessageCli.WELCOME_PLAYER.printMessage(playerName);
  }

  public void play() {
    // Print "Start round: #x:" where x increases by 1 each time play is invoked.
    ++numOfRounds;
    MessageCli.START_ROUND.printMessage(Integer.toString(numOfRounds));

    // Prompt user for input for number of fingers.
    String numOfFingers = null;
    while (!Utils.isInteger(numOfFingers) || Integer.parseInt(numOfFingers) > 5 || Integer.parseInt(numOfFingers) < 0) {
      // If user has input before, print the invalid input message.
      if (numOfFingers != null) {
        MessageCli.INVALID_INPUT.printMessage();
      }

      // Print prompt message and get input.
      MessageCli.ASK_INPUT.printMessage();
      numOfFingers = Utils.scanner.nextLine();
    }

    // Print information about player name and number of fingers.
    MessageCli.PRINT_INFO_HAND.printMessage(playerName, numOfFingers);

  }

  public void endGame() {}

  public void showStats() {}
}
