package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

/**
 * The Top Strategy that an Ai instance will use in the ODD OR EVEN game.
 * This class implements Strategy.
 *
 * <p>It overrides the generateNumber function. It stores the numbers of 
 * fingers the opponent has played this game and determines which choice,
 * ODD or EVEN, that the opponent has played the most. If the opponent 
 * has played ODD more than EVEN it will be assumed the opponent will play
 * ODD next, and vice versa. 
 *
 * <p>If the opponent has played both choices the same number of times, a
 * number between 0 and 5 will be picked randomly. Otherwise, the 
 * generateNumber function will return a random EVEN number if the Ai's
 * target is the same as what it is assumed the opponent will play, and
 * ODD if they are different. This algorithm ensures that if the opponent
 * really does play what the Top Strategy assumes, the Ai will win.
 */
public class TopStrategy implements Strategy {
  private Player ai;
  private List<Integer> opponentfingerHistory;

  /**
   * Creates a TopStrategy instance.
   *
   * @param ai the Ai that will use this instance of TopStrategy.
   * @param opponentfingerHistory list of the opponent's history of number of fingers played.
   */
  public TopStrategy(Player ai, List<Integer> opponentfingerHistory) {
    this.ai = ai;
    this.opponentfingerHistory = opponentfingerHistory;

  }

  @Override
  public int generateNumber() {
    int numberOfEvenFingers = 0;
    Choice assumedOpponentChoice = Choice.ODD; // Initially assume opponent will play odd.

    // Use a for loop to increment the number of evens played,
    // and assume the opponent will play even if this number surpasses half the history size.
    for (int n : opponentfingerHistory) {
      if (Utils.isEven(n)) {
        numberOfEvenFingers++;
      }

      if (numberOfEvenFingers > opponentfingerHistory.size() / 2) {
        assumedOpponentChoice = Choice.EVEN;
        break;
      }
    }

    // If half of the opponent's finger history is even, randomly pick.
    if (numberOfEvenFingers == opponentfingerHistory.size() - numberOfEvenFingers) {
      return Utils.getRandomNumberRange(0, 5);
    }

    // If the opponent will play the same choice as the AI's target play even, odd otherwise.
    if (ai.getTarget().equals(assumedOpponentChoice)) {
      return Utils.getRandomEvenNumber();
    } else {
      return Utils.getRandomOddNumber();
    }

  }

}
