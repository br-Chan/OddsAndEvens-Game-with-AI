package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public abstract class Ai extends Player {
  Strategy currentStrategy;

  public Ai(Choice userChoice) {
    super("HAL-9000", userChoice);

    switch (userChoice) {
      case EVEN:
        break;
      case ODD:
        this.target = Choice.EVEN;
      default:
        System.err.println("invalid Choice, defaulting to ODD");
    }

    this.target = Choice.ODD;
  }

  public void setCurrentStrategy(Strategy newStrategy) {
    this.currentStrategy = newStrategy;
  }

}
