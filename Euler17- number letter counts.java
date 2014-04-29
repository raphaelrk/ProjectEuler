import java.io.*;
class Main {
  // if all the numbers from one to one thousand were written out how many letters would be used
  // spaces and hyphens don't count
  // ands count
  
  public enum Num {
    ONE (),
    TWO (), 
    THREE(), 
    FOUR (), 
    FIVE(), 
    SIX (),
    SEVEN (), 
    EIGHT(),
    NINE (),
    TEN (),
    ELEVEN (),
    TWELVE (),
    THIRTEEN (),
    TEEN (),
    FIFTEEN (),
    EIGHTEEN (),
    TWENTY (),
    THIRTY (),
    FORTY (),
    FIFTY (),
    SIXTY (),
    SEVENTY (),
    EIGHTY (),
    NINETY,
    HUNDRED (),
    AND (),
    THOUSAND ();
    
    private int length;
    Num() {
      length = this.toString().length();
    }
    
    public int len() {
      return length;
    }
  }
  
  public static void main (String[] args) throws Exception {
    int sum = 0;
    
    for(int i = 1; i <= 1000; i++) {
      Num[] numArr = toWord(i);
      String num = "";
      int numSum = 0;
      for(int j = 0; j < numArr.length; j++) {
        num += numArr[j] + " ";
        numSum += numArr[j].len();
      }
      sum += numSum;
      System.out.println(i + ": " + num + " sum: " + numSum + " total: " + sum);
    }
  }
  
  public static Num[] toWord(int n) {
    int ones = n % 10;
    int tens = (n % 100 - ones)/10;
    int hundreds = (n % 1000 - tens - ones)/100;
    Num NumOnes = null;
    Num NumTens = null;
    Num NumAnd = null;
    Num NumHundred = null;
    Num NumXHundred = null;
    int arrLen = 0;
    
    if(ones != 0) {
      arrLen++;
      switch (ones) {
        case 1:
          NumOnes = Num.ONE;
          break;
        case 2:
          NumOnes = Num.TWO;
          break;
        case 3:
          NumOnes = Num.THREE;
          break;
        case 4:
          NumOnes = Num.FOUR;
          break;
        case 5:
          NumOnes = Num.FIVE;
          break;
        case 6:
          NumOnes = Num.SIX;
          break;
        case 7:
          NumOnes = Num.SEVEN;
          break;
        case 8:
          NumOnes = Num.EIGHT;
          break;
        case 9:
          NumOnes = Num.NINE;
          break;
        default:
          System.out.println("Ones bug: " + ones);
      }
    }
    if(tens != 0) {
      arrLen++;
      switch (tens) {
        case 1:
          if(ones == 0) {
            NumTens = Num.TEN;
          } else if(ones == 1) {
            NumTens = Num.ELEVEN;
            NumOnes = null;
            arrLen--;
          } else if(ones == 2) {
            NumTens = Num.TWELVE;
            NumOnes = null;
            arrLen--;
          } else if(ones == 3) {
            NumTens = Num.THIRTEEN;
            NumOnes = null;
            arrLen--;
          } else if(ones == 5) {
            NumTens = Num.FIFTEEN;
            NumOnes = null;
            arrLen--;
          } else if(ones == 8) {
            NumTens = Num.EIGHTEEN;
            NumOnes = null;
            arrLen--;
          } else {
            NumTens = NumOnes;
            NumOnes = Num.TEEN;
          }
          break;
        case 2:
          NumTens = Num.TWENTY;
          break;
        case 3:
          NumTens = Num.THIRTY;
          break;
        case 4:
          NumTens = Num.FORTY;
          break;
        case 5:
          NumTens = Num.FIFTY;
          break;
        case 6:
          NumTens = Num.SIXTY;
          break;
        case 7:
          NumTens = Num.SEVENTY;
          break;
        case 8:
          NumTens = Num.EIGHTY;
          break;
        case 9:
          NumTens = Num.NINETY;
          break;
        default:
          System.out.println("Tens bug: " + tens);
      }
    }
    if(hundreds != 0) {
      arrLen += 2;
      NumHundred = Num.HUNDRED;
      if(NumOnes != null || NumTens != null) {
        NumAnd = Num.AND;
        arrLen++;
      }
      
      switch (hundreds) {
        case 1:
          NumXHundred = Num.ONE;
          break;
        case 2:
          NumXHundred = Num.TWO;
          break;
        case 3:
          NumXHundred = Num.THREE;
          break;
        case 4:
          NumXHundred = Num.FOUR;
          break;
        case 5:
          NumXHundred = Num.FIVE;
          break;
        case 6:
          NumXHundred = Num.SIX;
          break;
        case 7:
          NumXHundred = Num.SEVEN;
          break;
        case 8:
          NumXHundred = Num.EIGHT;
          break;
        case 9:
          NumXHundred = Num.NINE;
          break;
        default: 
        System.out.println("Hundreds bug: " + hundreds);
      }
    }
    if(n == 1000) {
      Num[] t = new Num[2];
      t[0] = Num.ONE;
      t[1] = Num.THOUSAND;
      return t;
    }
    
    Num[] template = {NumXHundred, NumHundred, NumAnd, NumTens, NumOnes};
    int templSize = 5;
      
    Num[] word = new Num[arrLen];
    int index = 0;
    
    for(int i = 0; i < templSize; i++) {
      if(template[i] != null) {
        word[index] = template[i];
        index++;
      }
    }
    
    return word;
  }
}