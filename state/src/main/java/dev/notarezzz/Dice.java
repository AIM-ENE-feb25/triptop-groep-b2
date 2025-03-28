package dev.notarezzz;

import java.util.Random;

public class Dice {
  private int eyes;
  private DiceState currentDiceState = new SingleDiceState();

  public int throwDice() {
    this.eyes = new Random().nextInt(6) + 1;
    int score = this.currentDiceState.getScore(this.eyes);
    this.nextDice();
    return score;
  }

  private void nextDice() {
    this.currentDiceState = this.eyes % 2 == 0 ? this.currentDiceState.onEven() : this.currentDiceState.onOdd();
  }
}
