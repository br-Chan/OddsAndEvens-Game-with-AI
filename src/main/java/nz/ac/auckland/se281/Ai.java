package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

/**
 * The Ai player in the ODD OR EVEN game. This class extends Player.
 * 
 * <p>
 * 
 * The number of fingers it plays in a round is determined by its current strategy.
 * It overrides the pickFinger method from the Player class, generating a number using
 * the current strategy.
 */
public abstract class Ai extends Player {
  protected Strategy currentStrategy;

  /**
   * Creates an Ai instance, setting its target to be opposite that of the Human and
   * setting its current strategy to RandomStrategy.
   * 
   * @param userChoice the target of the opposing Human player, inputted by the user.
   */
  public Ai(Choice userChoice) {
    super("HAL-9000", userChoice);

    // Set the AI's target to the opposite of what the user chose.
    switch (userChoice) {
      case EVEN:
        this.target = Choice.ODD;
        break;

      case ODD:
        this.target = Choice.EVEN;
        break;

      default:
        System.err.println("invalid Choice, defaulting to ODD");
        this.target = Choice.ODD;
        break;
    }

    // Set the initial Strategy to Random Strategy.
    currentStrategy = new RandomStrategy();

  }

  public void setCurrentStrategy(Strategy newStrategy) {
    this.currentStrategy = newStrategy;
  }

  // Baseline method: 'get the strategy to generate the number'.
  @Override
  public String pickFingers() {
    return Integer.toString(currentStrategy.generateNumber());
  }

}
