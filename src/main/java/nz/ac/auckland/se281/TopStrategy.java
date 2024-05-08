package nz.ac.auckland.se281;

import java.util.List;

import nz.ac.auckland.se281.Main.Choice;

public class TopStrategy implements Strategy {
  Player ai;
  List<Integer> opponentfingerHistory;

  public TopStrategy(Player ai, List<Integer> opponentfingerHistory) {
    this.ai = ai;
    this.opponentfingerHistory = opponentfingerHistory;

  }

  @Override
  public int generateNumber() {
    int numberOfEvenFingers = 0;
    Choice assumedOpponentChoice = Choice.ODD; // Initially assume opponent will play odd.

    System.out.println(opponentfingerHistory); // TODO remove this when required

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
