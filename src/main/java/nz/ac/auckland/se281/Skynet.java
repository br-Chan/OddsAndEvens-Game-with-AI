package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

public class Skynet {
  public static Ai createAi(Difficulty difficulty, Choice choice) {
    switch (difficulty) {
      case EASY:
        return new EasyAi(choice);

      case MEDIUM:
        return new MediumAi(choice);

      case HARD:
        return new HardAi(choice);

      default:
        System.err.println("invalid difficulty, defaulting to Easy");
        return new EasyAi(choice);
        
    }

    
  }

}
