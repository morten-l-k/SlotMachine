package com.company;

import java.util.Random;
import java.util.Scanner;

public class Controller {
  UI ui = new UI();
  Scanner sc = new Scanner(System.in);
  Digit digit1 = new Digit("A", true);
  Digit digit2 = new Digit("B", true);
  Digit digit3 = new Digit("C", true);
  int CODEPOINTLOWERBOUND = 65;
  int CODEPOINTUPPERBOUND = 75;
  boolean runProgram = true;


  public void startProgram() {
    ui.printWelcome();
    while (runProgram) {
      //Pull handle
      sc.nextLine();

      //Print displayed digits
      ui.printDigits(digit1.getDigit(), digit2.getDigit(), digit3.getDigit());

      //Choose to lock a digit
      ui.lockDigit();
      String input = sc.nextLine();
      changeDigit(input);

      //Print pull handle
      ui.pullHandle();

      //Randomizes confirmed changeable digits
      setRandomDigits();

      //Make method to check if all digits are the same
      if (checkDigits()) {
        ui.printYouWin();
        runProgram = false;
      }
    }
  }

  public boolean checkDigits() {
    boolean tmpBoolean = false;
    if (digit1.getDigit().equals(digit2.getDigit()) && digit2.getDigit().equals(digit3.getDigit())) {
      tmpBoolean = true;
    }
    return tmpBoolean;
  }

  public void setRandomDigits() {
    setRandomFirstDigit();
    setRandomSecondDigit();
    setRandomThirdDigit();
  }

  public void setRandomFirstDigit() {
    if (digit1.isDigitChangeable()) {
      char digit = (char) getRandomCodePoint();
      digit1.setDigit(Character.toString(digit));
    }
  }

  public void setRandomSecondDigit() {
    if (digit2.isDigitChangeable()) {
      char digit = (char) getRandomCodePoint();
      digit2.setDigit(Character.toString(digit));
    }
  }

  public void setRandomThirdDigit() {
    if (digit3.isDigitChangeable()) {
      char digit = (char) getRandomCodePoint();
      digit3.setDigit(Character.toString(digit));
    }
  }

  public int getRandomCodePoint() {
    Random random = new Random();
    return random.nextInt(CODEPOINTLOWERBOUND, CODEPOINTUPPERBOUND);
  }

  public void changeDigit(String input) {
    if (input.equals("Y") | input.equals("y") | input.equals("Yes") | input.equals("YES") | input.equals("yes")) {
      ui.chooseDigit();
      String chosenDigit = sc.nextLine();
      lockDigit(chosenDigit);
      ui.printDigits(digit1.getDigit(), digit2.getDigit(), digit3.getDigit());
    }
  }

  public void lockDigit(String chosenDigit) {
    if (chosenDigit.equals("1")) {
      digit1.setDigitChangeable(false);
    } else if (chosenDigit.equals("2")) {
      digit2.setDigitChangeable(false);
    } else if (chosenDigit.equals("3")) {
      digit3.setDigitChangeable(false);
    }
  }

  public static void main(String[] args) {
    Controller obj = new Controller();
    obj.startProgram();
  }
}
