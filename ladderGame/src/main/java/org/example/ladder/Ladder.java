package org.example.ladder;

import org.example.input.LadderInput;

import java.util.Scanner;

public class Ladder {
  private LadderInput ladderInput = new LadderInput();

  public void startGame() {

    System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

    String playerName = ladderInput.enterPlayerName();
  }
}
