package dev.notarezzz;

public class DoubleDiceState implements DiceState {
  @Override
  public int getScore(int eyes) {
    return 2 * eyes;
  }

  @Override
  public DiceState onEven() {
    return new SquareDiceState();
  }

  @Override
  public DiceState onOdd() {
    return new SingleDiceState();
  }
}
