package coffeemachine;

public enum CoffeeConstants {
  ESPRESSO(250, 0, 16, 1, 4),
  LATTE(350, 75, 20, 1, 7),
  CAPPUCCINO(200, 100, 12, 1, 6);

  int water;
  int milk;
  int beans;
  int cups;
  int cost;

  CoffeeConstants(int water, int milk, int beans, int cups, int cost) {
    this.water = water;
    this.milk = milk;
    this.beans = beans;
    this.cups = cups;
    this.cost = cost;
  }

  public int getWater() {
    return water;
  }

  public int getMilk() {
    return milk;
  }

  public int getBeans() {
    return beans;
  }

  public int getDisposableCups() {
    return cups;
  }
}
