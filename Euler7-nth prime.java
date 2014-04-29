import java.io.*;
class Main {
  // finds the primeIndex-th prime number
  public static void main (String[] args) throws Exception {
    int primeIndex = 10001;
    int numPrimes = 2;
    int i = 6;
    System.out.println(2);
    System.out.println(3);
    while(numPrimes != primeIndex) {
      if(isPrime(i-1)) {
        numPrimes++;
        System.out.println(i-1);
        if(numPrimes == primeIndex) break;
      }
      if(isPrime(i+1)) {
        numPrimes++;
        System.out.println(i+1);
      }
      i += 6;
    }
    
  }
          
  public static boolean isPrime(int n) {
    if(n==2 || n== 3) return true;
    
    if(n%2==0 || n==1) return false;
    
    for(int i = 3; i <= Math.sqrt(n); i+=2){
      if(n%i==0) return false;
    }
    
    return true;
  }
}