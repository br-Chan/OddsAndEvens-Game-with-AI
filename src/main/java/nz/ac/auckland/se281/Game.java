package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {
  int numOfRounds = 0;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // the first element of options[0]; is the name of the player

    // Print Welcome message.
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
  }

  public void play() {
    // Print "Start round: #x:" where x increases by 1 each time play is invoked.
    ++numOfRounds;
    MessageCli.START_ROUND.printMessage(Integer.toString(numOfRounds));

    // Prompt user for input for number of fingers.
    String input = null;
    while (!Utils.isInteger(input) || Integer.parseInt(input) > 5 || Integer.parseInt(input) < 0) {
      // If user has input before, print the invalid input message.
      if (input != null) {
        MessageCli.INVALID_INPUT.printMessage();
      }

      // Print prompt message and get input.
      MessageCli.ASK_INPUT.printMessage();
      input = Utils.scanner.nextLine();
    }


  }

  public void endGame() {}

  public void showStats() {}
}
