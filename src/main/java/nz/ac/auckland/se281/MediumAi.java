package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

/**
 * The Ai at MEDIUM difficulty. This class extends Ai.
 *
 * <p>The Medium Ai knows about the opponent and tracks how many rounds have been played.
 * It overrides the pickFingers method so that it switches its current strategy from
 * Random Strategy to Top Strategy at the start of the 4th round.
 */
public class MediumAi extends Ai {
  private Player opponent;
  private int numOfRounds;

  /**
   * Creates a MediumAi instance.
   *
   * @param userChoice the target of the opposing Human player, inputted by the user.
   * @param opponent the Ai's opponent, the Human player.
   */
  public MediumAi(Choice userChoice, Player opponent) {
    super(userChoice);

    this.opponent = opponent;
    numOfRounds = 0;


  }

  @Override
  public String pickFingers() {
    numOfRounds++;
    
    // If this is the 4th round, switch from Random to Top Strategy.
    if (numOfRounds == 4) {
      setStrategy(new TopStrategy(this, opponent.getFingerHistory()));
    }

    return super.pickFingers();
  }

}
