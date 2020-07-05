package coffeemachine;

import java.util.Scanner;
import static coffeemachine.CoffeeConstants.*;
import static coffeemachine.MenuState.*;

public class CoffeeMachine {
  private int water;
  private int milk;
  private int beans;
  private int cups;
  private int money;
  Scanner sc = new Scanner(System.in);
  MenuState menuState;

  public CoffeeMachine(){
    water = 400;
    milk = 540;
    beans = 120;
    cups = 9;
    money = 550;
    menuState = MAINMENU;
  }

  public static void main(String[] args) {
    CoffeeMachine coffeeMachine = new CoffeeMachine();

    while (!coffeeMachine.menuState.equals(OFF)) {
      coffeeMachine.getInput();
    }
  }

  public void getInput() {
    switch (menuState) {
      case MAINMENU:
        System.out.print(menuState.menuOutput);
        setState(sc.nextLine());
        break;
      case BUY:
        System.out.print(menuState.menuOutput);
        buy(sc.nextLine());
        break;
      case FILL:
        fill();
        break;
      case REMAINING:
        contents();
        break;
      case TAKE:
        take();
        break;
      case OFF:
        break;
    }
  }

  public void setState(String input) {
    switch (input) {
      case "buy":
        menuState = BUY;
        break;
      case "fill":
        menuState = FILL;
        break;
      case "take":
        menuState = TAKE;
        break;
      case "remaining":
        menuState = REMAINING;
        break;
      case "exit":
        menuState = OFF;
        break;
      default:
        System.out.print("Please enter valid action: ");
    }
  }

  public void contents() {
    System.out.println("The coffee machine has:");
    System.out.println(water + " of water");
    System.out.println(milk + " of milk");
    System.out.println(beans + " of coffee beans");
    System.out.println(cups + " of disposable cups");
    if (money == 0) {
      System.out.println(money + " of money");
    } else {
      System.out.println("£" + money + " of money");
    }
    menuState = MAINMENU;
  }

  public void buy(String drink) {
    switch(drink) {
      case "1":
        coffeeSelection(ESPRESSO);
        break;
      case "2":
        coffeeSelection(LATTE);
        break;
      case "3":
        coffeeSelection(CAPPUCCINO);
        break;
      case "back":
        menuState = MAINMENU;
        break;
      default:
        System.out.println("Not a valid selection");
    }
  }

  public void fill() {
    System.out.println("How many ml of water do you want to add: ");
    water += Integer.parseInt(sc.nextLine());
    System.out.println("How many ml of milk do you want to add: ");
    milk += Integer.parseInt(sc.nextLine());
    System.out.println("How many grams of coffee beans do you want to add: ");
    beans += Integer.parseInt(sc.nextLine());
    System.out.println("How many disposable cups do you want to add: ");
    cups += Integer.parseInt(sc.nextLine());
    menuState = MAINMENU;
  }

  public void take() {
    System.out.println("I gave you £" + money);
    money = 0;
    menuState = MAINMENU;
  }

  public void coffeeSelection(CoffeeConstants selection) {
    if (checkResources(selection.getWater(), selection.getMilk(), selection.getBeans(), selection.getDisposableCups())) {
      water -= selection.getWater();
      milk -= selection.getMilk();
      beans -= selection.getBeans();
      money += selection.cost;
      cups -= selection.getDisposableCups();
    }
    menuState = MAINMENU;
  }

  public boolean checkResources(int water, int milk, int beans, int cups) {

    if (this.water >= water
        && this.milk >= milk
        && this.beans >= beans
        && this.cups >= cups) {
      System.out.println("I have enough resources, making you a coffee!");
      return true;
    } else {
      System.out.println("Sorry, not enough resources.");
      return false;
    }
  }
}
