package nz.ac.auckland.se281;

/**
 * The Random Strategy that an Ai instance will use in the ODD OR EVEN game.
 * This class implements Strategy.
 *
 * <p>It overrides the generateNumber function to return a random number between
 * 0 and 5.
 */
public class RandomStrategy implements Strategy {

  @Override
  public int generateNumber() {
    return Utils.getRandomNumberRange(0, 5);
  }

}
