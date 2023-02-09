package test;

public class Card {
  private String[] suit = {"spade", "clover", "hart", "diamond"};
  private String[] rank = {"ace", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "jack", "queen", "king"};
  public String[] deck;

  Card() {
    this.deck = new String[52];
    for (int i = 0; i < this.deck.length; i++) {
      if (i < 13) {
        this.deck[i] = suit[0] + " " + rank[i];
      } else if (i < 26) {
        this.deck[i] = suit[1] + " " + rank[i - 13];
      } else if (i < 39) {
        this.deck[i] = suit[2] + " " + rank[i - 26];
      } else if (i < 52) {
        this.deck[i] = suit[3] + " " + rank[i - 39];
      }
    }
  }
}