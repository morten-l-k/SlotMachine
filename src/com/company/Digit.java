package com.company;

public class Digit {
  private String digit;
  private boolean isDigitChangeable;

  public Digit(String digit, boolean isDigitChangeable){
    this.digit = digit;
    this.isDigitChangeable = isDigitChangeable;
  }

  public String getDigit(){
    return digit;
  }

  public boolean isDigitChangeable(){
    return isDigitChangeable;
  }

  public void setDigitChangeable(boolean digitChangeable) {
    this.isDigitChangeable = digitChangeable;
  }
}
