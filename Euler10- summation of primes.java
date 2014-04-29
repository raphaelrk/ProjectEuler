import java.io.*;
class Main {
  // finds sum of all primes
  // below max
  public static void main (String[] args) throws Exception {
    int max = 2000000;
    long sum = 5; // 2, 3 already there
   // System.out.println("2 2\n3 5");
    for(int i = 6; i <= max; i+=6) {
      if(isPrime(i-1)) {
        sum += i-1;
       // System.out.println(i-1 + " " + sum);
      }
      if(isPrime(i+1) && i+1 < max) {
        sum+= i + 1;
       // System.out.println(i+1 + " " + sum);
      }
    }
    System.out.println("sum: " + sum);
  }
  
  public static boolean isPrime(int n) {
    if(n==2 || n==3) return true;
    
    if(n%2==0 || n==1) return false;
    
    for(int i = 3; i <= Math.sqrt(n); i+=2) {
      if(n%i==0) return false;
    }
    
    return true;
  }
}