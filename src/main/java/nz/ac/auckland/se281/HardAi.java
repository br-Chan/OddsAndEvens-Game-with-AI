package nz.ac.auckland.se281;

import java.util.List;

import nz.ac.auckland.se281.Main.Choice;

public class HardAi extends Ai {
  private Player opponent;
  private int numOfRounds;
  private List<Player> opponentWinHistory;

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
