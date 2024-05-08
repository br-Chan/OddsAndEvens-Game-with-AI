package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class MediumAi extends Ai {

  public MediumAi(Choice userChoice) {
    super(userChoice);
    currentStrategy = new RandomStrategy();
  }

  @Override
  public String pickFingers() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'pickFingers'");
  }

}
