package nz.ac.auckland.se281;

/**
 * An interface that houses the generateNumber function that an Ai instance will use to
 * pick a number in the ODD OR EVEN game.
 */
public interface Strategy {

  /**
   * Uses the implemented algorithm to randomly pick a number of fingers to show on one hand
   * when a round in a game of ODD OR EVEN is played.
   * 
   * @return an integer between 0 and 5.
   */
  public int generateNumber();

}
