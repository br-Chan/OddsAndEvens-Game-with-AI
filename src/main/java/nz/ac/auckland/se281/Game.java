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

    // Ask user for input on number of fingers.
    MessageCli.ASK_INPUT.printMessage();

  }

  public void endGame() {}

  public void showStats() {}
}
