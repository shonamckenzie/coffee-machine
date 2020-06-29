package machine;

import java.util.Scanner;

public class CoffeeMachine {
  private static final int water = 200;
  private static final int milk = 50;
  private static final int beans = 15;

  public static void main(String[] args) {


    Scanner scanner = new Scanner(System.in);

    System.out.println("Write how many ml of water the coffee machine has: ");
    int containsWater = scanner.nextInt();

    System.out.println("Write how many ml of milk the coffee machine has: ");
    int containsMilk = scanner.nextInt();

    System.out.println("Write how many grams of coffee beans the coffee machine has: ");
    int containsBeans = scanner.nextInt();

    System.out.println("Write how many cups of coffee you will need: ");
    int cups = scanner.nextInt();

    scanner.close();
// Calculate the number of cups that can be made from ingredients based on 1 cup measurement
    int cupsOfWater = containsWater / water;
    int cupsOfMilk = containsMilk / milk;
    int cupsOfBeans = containsBeans / beans;

// Get the minimum number of cups possible from all ingredients
    int minCups = Math.min(cupsOfWater, cupsOfMilk);
    minCups = Math.min(cupsOfBeans, minCups);

// Calculate the difference between number of cups input and minimum number of cups the ingredients can make
    if (cups == minCups) {
      System.out.println("Yes, I can make that amount of coffee");
    } else if (cups < minCups) {
      System.out.println("Yes, I can make that amount of coffee (and even " + (minCups - cups) + " more than that)");
    } else {
      System.out.println("No, I can make only " + minCups + " cup(s) of coffee");
    }

  }
}

