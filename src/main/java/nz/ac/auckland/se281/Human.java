package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class Human extends Player {

  public Human(String name, Choice target) {
    super(name, target);

  }

  @Override
  public String pickFingers() {
    // Prompt user for input for number of fingers.
    String numOfFingers = null;
    while (!Utils.isInteger(numOfFingers) || Integer.parseInt(numOfFingers) > 5 || Integer.parseInt(numOfFingers) < 0) {
      // If user has input before, print the invalid input message.
      if (numOfFingers != null) {
        MessageCli.INVALID_INPUT.printMessage();
      }

      // Print prompt message and get input.
      MessageCli.ASK_INPUT.printMessage();
      numOfFingers = Utils.scanner.nextLine();
    }

    // Add the number of fingers to the finger history and return the integer.
    fingerHistory.add(Integer.valueOf(numOfFingers));
    return numOfFingers;
  }
}
