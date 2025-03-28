package dev.notarezzz;

public interface DiceState {
  int getScore(int eyes);
  DiceState onEven();
  DiceState onOdd();
}
