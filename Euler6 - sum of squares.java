import java.io.*;
class Main {
  public static void main (String[] args) throws Exception {
    int sumOfSquares=0;
    int squareOfSums=0;
    
    for(int i = 1; i <= 100; i++) {
      sumOfSquares += i*i;
      squareOfSums += i;
    }
    
    squareOfSums *= squareOfSums;
    
    System.out.println(squareOfSums - sumOfSquares);
  }
}