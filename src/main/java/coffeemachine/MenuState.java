package coffeemachine;

public enum MenuState {
  OFF("Turning Off"),
  MAINMENU("What would you like to do (buy, fill, take, remaining, exit): "),
  BUY("What do you want to buy? 1 - espresso, 2 - latte, 3- cappuccino, back - to main menu: "),
  FILL("Filling"),
  REMAINING("Remaining"),
  TAKE("Taking");

  String menuOutput;

  MenuState(String menuOutput) {
    this.menuOutput = menuOutput;
  }
}
