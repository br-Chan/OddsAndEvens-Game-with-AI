package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

/**
 * A player in the ODD OR EVEN game. It can be either a Human or Ai.
 *
 * Every player has a name, target (ODD or EVEN) to achieve, a number of fingers
 * and history that stores these numbers.
 */
public abstract class Player {
  protected final String name;
  protected Choice target;
  protected int numOfFingers;
  protected List<Integer> fingerHistory;

  /**
   * Creates a Player instance.
   * 
   * @param name the name of the player.
   * @param choice the target, ODD or EVEN, that the player must achieve.
   */
  public Player(String name, Choice choice) {
    this.name = name;
    this.target = choice;
    numOfFingers = 0;
    fingerHistory = new ArrayList<>();
  }

  public Choice getTarget() {
    return target;
  }

  public String getName() {
    return name;
  }

  public int getNumOfFingers() {
    return numOfFingers;
  }

  public void setNumOfFingers(int numOfFingers) {
    this.numOfFingers = numOfFingers;
  }

  public List<Integer> getFingerHistory() {
    return fingerHistory;
  }

  // Returns the number of fingers chosen by the player (human or AI), as a string.
  public abstract String pickFingers();

  @Override
  public String toString() {
    return name;
  }
}
