package org.example.input;

import java.util.Scanner;

public class LadderInput {
  private Scanner input = new Scanner(System.in);

  public String enterPlayerName() {
    String playerNames = this.input.nextLine();
//    boolean validationValue = this.checkNumberOfValidPlayers(playerNames);

//     if (validationValue) {
//       saving a player name
//       receive reword
////    }
//     printing a single player cannot play game

    return playerNames;
  }

//  private boolean checkNumberOfValidPlayers(String playerNames) {
//    if (playerNames.contains(",")) {
//      return true;
//    }
//    return false;
//  }

  public String enterReword() {
    String rewords = this.input.nextLine();

    return rewords;
  }

  public String enterLadderLine() {
    String ladderLine = this.input.nextLine();

    return ladderLine;
  }
}
