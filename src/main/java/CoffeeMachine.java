import java.util.Scanner;

public class CoffeeMachine {
  private static int water = 400;
  private static int milk = 540;
  private static int beans = 120;
  private static int cups = 9;
  private static int money = 550;

  public static void contents() {
    System.out.println("The coffee machine has:");
    System.out.println(water + " of water");
    System.out.println(milk + " of milk");
    System.out.println(beans + " of coffee beans");
    System.out.println(cups + " of disposable cups");
    if (money == 0) {
      System.out.println(money + " of money");
    } else {
      System.out.println("$" + money + " of money");
    }
    System.out.println();
  }

  public static void fill(int w, int m, int b, int c) {
    water += w;
    milk += m;
    beans += b;
    cups += c;
  }

  public static void buy(String n){
    if (n.equals("1")) {
      if (cups  <= 0) {
        System.out.println("Sorry, not enough disposable cups!");
        System.out.println();
      } else if (water < 250 ) {
        System.out.println("Sorry, not enough water!");
        System.out.println();
      } else if (beans < 16) {
        System.out.println("Sorry, not enough coffee beans!");
        System.out.println();
      } else {
        System.out.println("I have enough resources, making you a coffee!");
        System.out.println();
        water -= 250;
        beans -= 16;
        money += 4;
        cups --;
      }

    } else if (n.equals("2")) {
      if (cups  <= 0) {
        System.out.println("Sorry, not enough disposable cups!");
        System.out.println();
      } else if (water <350 ) {
        System.out.println("Sorry, not enough water!");
        System.out.println();
      } else if (beans < 20) {
        System.out.println("Sorry, not enough coffee beans!");
        System.out.println();
      } else if (milk < 75) {
        System.out.println("Sorry, not enough milk!");
        System.out.println();
      } else {
        System.out.println("I have enough resources, making you a coffee!");
        System.out.println();
        water -= 350;
        milk -= 75;
        beans -= 20;
        money += 7;
        cups -= 1;
      }

    } else {
      if (cups  <= 0) {
        System.out.println("Sorry, not enough disposable cups!");
        System.out.println();
      } else if (water < 200) {
        System.out.println("Sorry, not enough water!");
        System.out.println();
      } else if (beans < 12) {
        System.out.println("Sorry, not enough coffee beans!");
        System.out.println();
      } else if (milk < 100) {
        System.out.println("Sorry, not enough milk!");
        System.out.println();
      } else {
        System.out.println("I have enough resources, making you a coffee!");
        System.out.println();
        water -= 200;
        milk -= 100;
        beans -= 12;
        money += 6;
        cups -= 1;
      }

    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Write action (buy, fill take, remaining, exit):");

    while (scanner.hasNextLine()) {
      String action = scanner.nextLine();
      switch (action) {
        case "buy":
          System.out.println();
          System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
          String buy = scanner.nextLine();
          if (buy.equals("back")) {
            System.out.println();
            System.out.println("Write action (buy, fill take, remaining, exit):");
          } else {
            buy(buy);
          }
          System.out.println("Write action (buy, fill take, remaining, exit):");
          break;
        case "fill":
          System.out.println();
          System.out.println("Write how many ml of water do you want to add:");
          int water = scanner.nextInt();
          System.out.println("Write how many ml of milk do you want to add:");
          int milk = scanner.nextInt();
          System.out.println("Write how many grams of coffee do you want to add:");
          int beans = scanner.nextInt();
          System.out.println("Write how many disposable cups of coffee do you want to add:");
          int cups = scanner.nextInt();
          fill(water, milk, beans, cups);
          System.out.println("Write action (buy, fill take, remaining, exit):");
          break;
        case "take":
          System.out.println();
          System.out.println("I gave you $" + money);
          money = 0;
          System.out.println();
          System.out.println("Write action (buy, fill take, remaining, exit):");
          break;
        case "remaining":
          System.out.println();
          contents();
          System.out.println("Write action (buy, fill take, remaining, exit):");
          break;
        case "exit":
          break;
      }
    }
    scanner.close();
  }
}
