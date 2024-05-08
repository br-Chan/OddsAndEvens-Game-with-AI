package nz.ac.auckland.se281;

import java.util.List;

import nz.ac.auckland.se281.Main.Choice;

public class TopStrategy implements Strategy {
  Player ai;
  List<Integer> humanFingerHistory;

  public TopStrategy(List<Integer> humanFingerHistory) {
    this.humanFingerHistory = humanFingerHistory;

  }

  @Override
  public int generateNumber() {
    int numberOfEvenFingers = 0;
    Choice assumedHumanChoice = Choice.ODD; // Initially assume human will play odd.

    // Use a for loop to increment the number of evens played,
    // and assume the human will play even if this number surpasses half the history size.
    for (int n : humanFingerHistory) {
      if (Utils.isEven(n)) {
        numberOfEvenFingers++;
      }

      if (numberOfEvenFingers > humanFingerHistory.size() / 2) {
        assumedHumanChoice = Choice.EVEN;
        break;
      }
    }

    // If half of the finger history is even, randomly pick.
    if (numberOfEvenFingers == humanFingerHistory.size() - numberOfEvenFingers) {
      System.out.println("Randomly picking."); // TODO remove this when required
      return Utils.getRandomNumberRange(0, 5);
    }

    // If the human will play the same choice as the AI's target play even, odd otherwise.
    if (ai.getTarget().equals(assumedHumanChoice)) {
      return Utils.getRandomEvenNumber();
    } else {
      return Utils.getRandomOddNumber();
    }

  }

}
