package com.app;

public class Main {
  public static void main(String[] args) {
    Woordenlijst lijst = new Woordenlijst();

    System.out.println("Ongesorteerde woordenlijst:");
    lijst.print();

    // Sorteer met BubbleSort
    lijst.setSorteerStrategie(new BubbleSort());
    lijst.sorteer();
    System.out.println("Gesorteerde woordenlijst met BubbleSort:");
    lijst.print();

    // Reset de lijst en gebruik SelectionSort
    lijst = new Woordenlijst();
    lijst.setSorteerStrategie(new SelectionSort());
    lijst.sorteer();
    System.out.println("Gesorteerde woordenlijst met SelectionSort:");
    lijst.print();
  }
}
