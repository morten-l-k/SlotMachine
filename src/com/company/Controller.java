package com.company;

import java.util.Random;
import java.util.Scanner;

public class Controller {
  UI ui = new UI();
  Scanner sc = new Scanner(System.in);
  Digit digit1 = new Digit("A", true);
  Digit digit2 = new Digit("B", true);
  Digit digit3 = new Digit("C", true);

  String firstDigit = "A";
  String secondDigit = "B";
  String thirdDigit = "C";
  boolean isFirstDigitChangeable = true;
  boolean isSecondDigitChangeable = true;
  boolean isThirdDigitChangeable = true;
  int CODEPOINTLOWERBOUND = 65;
  int CODEPOINTUPPERBOUND = 75;


  public void startProgram() {
    ui.printWelcome();
    boolean runProgram = true;
    while (runProgram) {
      //Pull handle
      sc.nextLine();

      //Print displayed digits
      ui.printDigits(firstDigit, secondDigit, thirdDigit);

      //Choose to lock a digit
      ui.lockDigit();
      String input = sc.nextLine();
      changeDigit(input);

      //Print pull handle
      ui.pullHandle();

      // TODO: 10/08/2022 refactor to avoid DRY
      setRandomDigits();
      // TODO: 10/08/2022 make digits into objects. Make class for digits 
    }
  }

  public void setRandomDigits(){
    setRandomDigit(isFirstDigitChangeable, firstDigit);
    setRandomDigit(isSecondDigitChangeable, secondDigit);
    setRandomDigit(isThirdDigitChangeable, thirdDigit);
   /* setRandomFirstDigit();
    setRandomSecondDigit();
    setRandomThirdDigit();*/
  }

  public void setRandomDigit(boolean isDigitChangeable, String digit){
    if(isDigitChangeable) {
      char tmpDigit = (char) getRandomCodePoint();
      digit = Character.toString(tmpDigit);
    }
  }

 /* public void setRandomFirstDigit() {
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
  }*/

  public int getRandomCodePoint() {
    Random random = new Random();
    int codePoint = random.nextInt(CODEPOINTLOWERBOUND, CODEPOINTUPPERBOUND);
    return codePoint;
  }

  public void changeDigit(String input) {
    if (input.equals("Y") | input.equals("y") | input.equals("Yes") | input.equals("YES") | input.equals("yes")) {
      ui.chooseDigit();
      String chosenDigit = sc.nextLine();
      lockDigit(chosenDigit);
      ui.printDigits(firstDigit, secondDigit, thirdDigit);
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
