import java.io.*;
class Main {
  // finds the one pythagorean triple 
  // whose sum is 1000
  public static void main (String[] args) throws Exception {
    for(int c = 998; c > 333; c--) {
      for(int b = (c>500)?1000-c-1:c-1; b > 0; b--) {
        int a = 1000 - c - b;
        if(a*a+b*b == c*c) {
          System.out.println("a: " + a);
          System.out.println("b: " + b);
          System.out.println("c: " + c);
          System.out.println("abc: " + a*b*c);
          return;
        } 
      }
    }
  }
}