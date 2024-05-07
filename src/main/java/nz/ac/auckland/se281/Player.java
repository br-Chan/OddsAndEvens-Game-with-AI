package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;

import nz.ac.auckland.se281.Main.Choice;

public abstract class Player {
  final protected String name;
  protected Choice target;
  protected int numOfFingers;
  protected List<Integer> fingerHistory;

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
}
