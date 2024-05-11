package nz.ac.auckland.se281;

public interface Strategy {

  /**
   * Uses the implemented algorithm to randomly pick a number of fingers to show on one hand
   * when a round in a game of ODD OR EVEN is played.
   * 
   * @return an integer between 0 and 5.
   */
  public int generateNumber();

}
