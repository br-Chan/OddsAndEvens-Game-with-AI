package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {
  Player human;
  Player ai;
  Skynet skynet = new Skynet();
  int numOfRounds = 0;


  public void newGame(Difficulty difficulty, Choice choice, String[] options) {

    // Create new Human instance of Player class (overwriting previous object).
    human = new Human(options[0]); // options[0] is the name of the player

    // Create new Ai instance of Player class (overwriting previous object) with factory.
    ai = skynet.createAi(difficulty, choice);

    MessageCli.WELCOME_PLAYER.printMessage(human.getName());
  }

  public void play() {
    // Print "Start round: #x:" where x increases by 1 each time play is invoked.
    ++numOfRounds;
    MessageCli.START_ROUND.printMessage(Integer.toString(numOfRounds));

    // Get the human to pick their number of fingers.
    String humanNumOfFingers = human.pickFingers();

    // Get the AI to pick its number of fingers.
    String aiNumOfFingers = ai.pickFingers();

    // Print information the name and number of fingers of each player.
    MessageCli.PRINT_INFO_HAND.printMessage(human.getName(), humanNumOfFingers);
    MessageCli.PRINT_INFO_HAND.printMessage(ai.getName(), aiNumOfFingers);

  }

  public void endGame() {}

  public void showStats() {}
}
