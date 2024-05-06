package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;

public abstract class Player {
  final protected String name;
  protected int numOfFingers;
  protected List<Integer> fingerHistory;

  public Player(String name) {
    this.name = name;
    numOfFingers = 0;
    fingerHistory = new ArrayList<>();
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
}
