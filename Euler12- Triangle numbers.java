import java.io.*;
class Main {
  // "What is the value of the first triangle number to have over five hundred divisors?"
  // triangle numbers-1,3,6,10,15,21,28...
  // 28 is first to have over 5 divisors
  public static void main (String[] args) throws Exception {
    int currTri = 1;
    int add = 2; //what'll be added to currTri
    while(divisorAmt(currTri) <=500) {
      currTri += add;
      add++;
    }
    System.out.println(currTri + " !");
  }
  
  public static int divisorAmt(int n) {
    int amt = 0;
    for(int i = 1; i < Math.sqrt(n); i++) {
      if(n % i == 0) {
        amt += 2;
      }
    }
    if(n % Math.sqrt(n) == 0) amt++;
    
    return amt;
  }
}