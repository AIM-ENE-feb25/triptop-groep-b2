package dev.notarezzz;

public class SquareDiceState implements DiceState{
  @Override
  public int getScore(final int eyes) {
    return eyes * eyes;
  }

  @Override
  public DiceState onEven() {
    return new SquareDiceState();
  }

  @Override
  public DiceState onOdd() {
    return new DoubleDiceState();
  }
}
