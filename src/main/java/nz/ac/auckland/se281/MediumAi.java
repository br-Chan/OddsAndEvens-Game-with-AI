package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class MediumAi extends Ai {
  Player opponent;
  int numOfRounds;

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
      currentStrategy = new TopStrategy(this, opponent.getFingerHistory());
    }

    return super.pickFingers();
  }

}
