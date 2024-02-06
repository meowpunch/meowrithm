package company.amazon;

/*
    You want to create a method that receives a hand of 5 cards and returns the best poker hand you can make with those cards


    For simplification, we’ll assume cards have a number and a symbol. Numbers go from 1 to 10 and symbols are ‘a’, ‘b’, ‘c’ and ‘d’.

    To start off, assume there are only 3 types of poker hands, from better to worse.
    Take into consideration you will have to add the other ones later.

    Flush: 5 cards of the same symbol. Example: 10a 4a 2a 7a 9a
    Three of a Kind: 3 cards with the same number. Example: 4a 3b 1c 4d 4b
    Pair: Two cards with the same number. Example: 3a 2b 8d 1a 8c

    Return the best poker hand you have. For example. If you have a pair, return “Pair” or any structure that symbolizes you have a pair.
    If you have a three of a kind, return “Three of a Kind” or any structure that represents it.



    String getBestPokerHand(Set<Card> cards)
*/

import java.util.Arrays;
import java.util.Set;

enum Symbol {
  A,
  B,
  C,
  D
}

enum Number {
  ONE,
  TWO,
  THREE,
  FOUR,
  FIVE,
  SIX,
  SEVEN,
  EIGHT,
  NIGHT,
  TEN
}

record Card(Symbol symbol, Number number) {}

// Take into consideration you will have to add the other ones later.
enum PockerHandType {
  Flush,
  ThreeOfAKind,
  Pair
}

class Pocker {

  String getBestPockerHand(Set<Card> cards) {
    var numberToCount = new int[Number.values().length];
    var symbolToCount = new int[Symbol.values().length];

    for (Card card : cards) {
      numberToCount[card.number().ordinal()] += 1;
      symbolToCount[card.symbol().ordinal()] += 1;
    }


    return "";
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(new int[10]));
    System.out.println(Symbol.A.ordinal());
  }
}
