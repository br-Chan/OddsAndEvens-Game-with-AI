package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {
  Player human;
  Player ai;
  int numOfRounds = 0;


  public void newGame(Difficulty difficulty, Choice choice, String[] options) {

    // Create new instance of Player class (overwriting any previous Player objects).
    human = new Human(options[0]); // options[0] is the name of the player

    MessageCli.WELCOME_PLAYER.printMessage(human.getName());
  }

  public void play() {
    // Print "Start round: #x:" where x increases by 1 each time play is invoked.
    ++numOfRounds;
    MessageCli.START_ROUND.printMessage(Integer.toString(numOfRounds));

    String humanNumOfFingers = human.pickFingers();

    // Print information about human's name and number of fingers.
    MessageCli.PRINT_INFO_HAND.printMessage(human.name, humanNumOfFingers);

    // Print information about AI's name and number of fingers.
    MessageCli.PRINT_INFO_HAND.printMessage("HAL-9000", "-1");

  }

  public void endGame() {}

  public void showStats() {}
}
