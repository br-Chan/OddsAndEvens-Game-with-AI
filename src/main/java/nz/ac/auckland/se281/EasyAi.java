package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

/**
 * The Ai at EASY difficulty. This class extends Ai.
 * 
 * It does not override the pickFingers method, so it uses the Ai class's implementation alone.
 */
public class EasyAi extends Ai {

  public EasyAi(Choice userChoice) {
    super(userChoice);
  }

}
