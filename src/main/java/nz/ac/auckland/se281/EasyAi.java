package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class EasyAi extends Ai {

  public EasyAi(Choice userChoice) {
    super(userChoice);
    currentStrategy = new RandomStrategy();
  }

  @Override
  public String pickFingers() {
    int numOfFingers = currentStrategy.generateNumber();
    //fingerHistory.add(numOfFingers); tentatively, remove when required
    return Integer.toString(numOfFingers);
  }

}
