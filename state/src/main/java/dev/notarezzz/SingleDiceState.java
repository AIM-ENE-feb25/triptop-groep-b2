package dev.notarezzz;

public class SingleDiceState implements DiceState {
  @Override
  public int getScore(int eyes) {
    return eyes;
  }

  @Override
  public DiceState onEven() {
    return new DoubleDiceState();
  }

  @Override
  public DiceState onOdd() {
    return new SingleDiceState();
  }
}
