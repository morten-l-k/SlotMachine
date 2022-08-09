package com.company;

import java.util.Random;
import java.util.Scanner;

public class Controller {
  UI ui = new UI();
  Scanner sc = new Scanner(System.in);
  String firstDigit = "A";
  String secondDigit = "B";
  String thirdDigit = "C";
  boolean isFirstDigitChangeable = true;
  boolean isSecondDigitChangeable = true;
  boolean isThirdDigitChangeable = true;


  public void startProgram() {
    ui.printWelcome();
    boolean runProgram = true;
    while (runProgram) {
      ui.printDigits(firstDigit, secondDigit, thirdDigit);
      //Choose to lock a digit
      ui.lockDigit();
      String input = sc.nextLine();
      changeDigit(input);

      //Print pull handle
      ui.pullHandle();

      //Set random letters
      setRandomFirstDigit();
      setRandomSecondDigit();
      setRandomThirdDigit();


    }
  }

  public void setRandomFirstDigit() {
    if (isFirstDigitChangeable) {
      char digit = (char) getRandomCodePoint();
      firstDigit = Character.toString(digit);
    }
  }

  public void setRandomSecondDigit() {
    if (isSecondDigitChangeable) {
      char digit = (char) getRandomCodePoint();
      secondDigit = Character.toString(digit);
    }
  }

  public void setRandomThirdDigit() {
    if (isThirdDigitChangeable) {
      char digit = (char) getRandomCodePoint();
      thirdDigit = Character.toString(digit);
    }
  }

  public int getRandomCodePoint() {
    Random random = new Random();
    int codePoint = random.nextInt(65, 91);
    return codePoint;
  }

  public void changeDigit(String input) {
    if (input.equals("Y") | input.equals("y") | input.equals("Yes") | input.equals("YES") | input.equals("yes")) {
      ui.chooseDigit();
      String chosenDigit = sc.nextLine();
      lockDigit(chosenDigit);
    }
  }

  public void lockDigit(String chosenDigit) {
    if (chosenDigit.equals("1")) {
      isFirstDigitChangeable = false;
    } else if (chosenDigit.equals("2")) {
      isSecondDigitChangeable = false;
    } else if (chosenDigit.equals("3")) {
      isThirdDigitChangeable = false;
    }
  }

  public static void main(String[] args) {
    Controller obj = new Controller();
    obj.startProgram();


  }
}
