package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class EasyAi extends Ai {

  public EasyAi(Choice userChoice) {
    super(userChoice);
    currentStrategy = new RandomStrategy();
  }

  @Override
  public String pickFingers() {
    return Integer.toString(currentStrategy.generateNumber());
  }

}
