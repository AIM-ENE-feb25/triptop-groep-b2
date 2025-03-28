package dev.notarezzz;

public class Main {
  public static void main(String[] args) {
    Dice dice = new Dice();
    int total = 0;
    for (int i = 0; i < 10; ++i) {
      total += dice.throwDice();
      System.out.println(total);
    }
  }
}