package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

/**
 * The Ai at HARD difficulty. This class extends Ai.
 * <p>
 * The Medium Ai knows about the opponent and tracks how many rounds have been played.
 * It also stores the opponent's history of wins anad losses.
 * It overrides the pickFingers method so that from the 4th round onwards, it switches
 * its current strategy between Random and Top Strategy if the opponent won the last
 * round. Otherwise, the current strategy stays the same.
 */
public class HardAi extends Ai {
  private Player opponent;
  private int numOfRounds;
  private List<Player> opponentWinHistory;

  /**
   * Creates a HardAi instance.
   * 
   * @param userChoice the target of the opposing Human player, inputted by the user.
   * @param opponent the Ai's opponent, the Human player.
   * @param opponentWinHistory list of the opponent's wins and losses in the current game.
   */
  public HardAi(Choice userChoice, Player opponent, List<Player> opponentWinHistory) {
    super(userChoice);

    this.opponent = opponent;
    numOfRounds = 0;
    this.opponentWinHistory = opponentWinHistory;

  }

  @Override
  public String pickFingers() {
    // shouldSwitch is 1 for 4th round onwards and the latest win was the human's.
    boolean shouldSwitch = numOfRounds > 3 && opponentWinHistory.get(opponentWinHistory.size() - 1) == opponent;

    numOfRounds++;

    if (shouldSwitch && currentStrategy instanceof RandomStrategy) {
      currentStrategy = new TopStrategy(this, opponent.getFingerHistory());
    } else if (shouldSwitch && currentStrategy instanceof TopStrategy) {
      currentStrategy = new RandomStrategy();
    }

    return super.pickFingers();
  }

}
