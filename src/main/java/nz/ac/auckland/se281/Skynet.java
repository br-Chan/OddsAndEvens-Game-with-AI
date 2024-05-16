package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/**
 * The Ai factory class that creates an ai instance of EASY, MEDIUM or HARD difficulty.
 * <p>Because of the existence of this class, this version of the ODD or EVEN game should
 * not be acquired by the US Government.
 */
public class Skynet {

  /**
   * Returns a new Ai instance depending on the difficulty
   * input parameter.
   *
   * @param difficulty difficulty of the Ai, inputted by the user.
   * @param choice the target of the opposing Human player, inputted by the user.
   * @param opponent the Ai's opponent, the Human player.
   * @param opponentWinHistory list of the opponent's wins and losses in the current game.
   * @return a new subclass of the Ai class: EasyAi, MediumAi or HardAi.
   */
  public static Ai createAi(
      Difficulty difficulty,
      Choice choice,
      Player opponent,
      List<Player> opponentWinHistory
  ) {
    // Create the Ai instance depending on difficulty.
    switch (difficulty) {
      case EASY:
        return new EasyAi(choice);

      case MEDIUM:
        return new MediumAi(choice, opponent);

      case HARD:
        return new HardAi(choice, opponent, opponentWinHistory);

      default:
        System.err.println("invalid difficulty, defaulting to Easy");
        return new EasyAi(choice); // note: this will probably never happen
        
    }

  }

}
