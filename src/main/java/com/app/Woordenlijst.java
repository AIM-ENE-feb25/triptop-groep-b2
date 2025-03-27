package com.app;

class Woordenlijst {
  private String[] woorden = {"hond", "beer", "leeuw", "kat", "aap", "tijger", "olifant"};
  private ISorteerStrategie sorteerStrategie;

  public void print() {
    for (String woord : woorden) {
      System.out.print(woord + " ");
    }
    System.out.println();
  }

  public void sorteer() {
    if (sorteerStrategie != null) {
      sorteerStrategie.sorteer(woorden);
    } else {
      throw new UnsupportedOperationException("Geen sorteeralgoritme ingesteld");
    }
  }

  public void setSorteerStrategie(ISorteerStrategie strategie) {
    this.sorteerStrategie = strategie;
  }
}
