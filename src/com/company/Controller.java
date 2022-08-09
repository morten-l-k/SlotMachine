package com.company;

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


    public void startProgram(){
        ui.printWelcome();
        boolean runProgram = true;
        while (runProgram){
            ui.printDigits(firstDigit, secondDigit, thirdDigit);
            ui.lockDigit();
            String input = sc.nextLine();
            lockDigit(input);
            ui.pullHandle();

            //Choose to lock a digit
        }
    }

    public void lockDigit(String input){
        if (input.equals("Y") | input.equals("y") | input.equals("Yes") | input.equals("YES") | input.equals("yes")) {
            ui.chooseDigit();
            String chosenDigit = sc.nextLine();
            changeDigit(chosenDigit);
        }
    }

    public void changeDigit(String chosenDigit){
        if(chosenDigit.equals("1")){
            isFirstDigitChangeable = false;
        } else if (chosenDigit.equals("2")){
            isSecondDigitChangeable = false;
        } else if (chosenDigit.equals("3")){
            isThirdDigitChangeable = false;
        }
    }

    public static void main(String[] args) {
        Controller obj = new Controller();
        obj.startProgram();


    }
}
