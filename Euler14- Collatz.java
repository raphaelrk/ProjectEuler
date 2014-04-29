import java.io.*;
class Main {
  // Collatz:
  // even? new number is n/2
  // odd?   new number is 3n + 1
  // longest chain with start under one mil?
  public static void main (String[] args) throws Exception {
    final int MAX = 1000000;
    int chainLen= 0; // length of chain
    int chainNum = 1; // num that made it
    // 106239-353
    for(int i = MAX/3; i < MAX; i++) {
      if((i - 1) % 3 == 0) {
        int len = collatzLength(i);
        if(len > chainLen) {
          chainLen = len;
          chainNum = i;
          System.out.println("Longest chain: " + len + " number: " + i);
        }
      }
    }
  }
  
  public static int collatzLength(int n) {
    int length = 0;
    while(n != 1) {
      if(n % 2 == 0) {
        n /= 2;
      } else {
        n = 3*n + 1;
      }
      length++;
    }
    return length;
  }
}