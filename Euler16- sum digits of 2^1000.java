import java.io.*;
import java.math.BigInteger;
class Main {
  // what is the sum of the digits of
  // 2 ^ 1000 ?
  public static void main (String[] args) throws Exception {
    BigInteger two = new BigInteger("2");
    int power = 1000;
    BigInteger num = two.pow(power);
    System.out.println("2^" + power + " num: " + num + " digits: " + sumDigits(num));
  }
  
  public static int sumDigits(BigInteger b) {
    int sum = 0;
    BigInteger[] divAndRem;
    while(b.compareTo(BigInteger.ZERO) > 0) {
      divAndRem = b.divideAndRemainder( BigInteger.TEN);
      b = divAndRem[0];
      sum += divAndRem[1].intValue();
    }
    return sum;
  }
}