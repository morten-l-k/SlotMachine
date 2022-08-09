package com.company;

public class UI {

  public void printWelcome(){
    System.out.println("Welcome to the slot machine.");
    System.out.println("Pull the handle to spin the numbers!");
  }

  public void printDigits(String firstDigit, String secondDigit, String thirdDigit){
    System.out.println(firstDigit + " - " + secondDigit + " - " + thirdDigit);
  }

  public void lockDigit(){
    System.out.println("Do you want to lock a number?");
    System.out.println("Yes: Press Y | No: Press N");
  }

  public void pullHandle(){
    System.out.println("Pull the handle! (Press any key on the keyboard followed by ENTER)");
  }

  public void chooseDigit(){
    System.out.println("Which digit do you want to lock?");
    System.out.println("First digit: Press 1 | Second digit: Press 2 | Third digit: Press 3");
  }

}
