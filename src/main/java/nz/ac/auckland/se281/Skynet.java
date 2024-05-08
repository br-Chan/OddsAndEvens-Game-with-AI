package nz.ac.auckland.se281;

import java.util.List;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

public class Skynet {
  public static Ai createAi(Difficulty difficulty, Choice choice, Player opponent, List<Integer> opponentWinHistory) {
    switch (difficulty) {
      case EASY:
        return new EasyAi(choice);

      case MEDIUM:
        return new MediumAi(choice, opponent);

      case HARD:
        return new HardAi(choice, opponent, opponentWinHistory);

      default:
        System.err.println("invalid difficulty, defaulting to Easy");
        return new EasyAi(choice);
        
    }

    
  }

}
