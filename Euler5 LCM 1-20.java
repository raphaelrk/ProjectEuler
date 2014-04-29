import java.io.*;
class Main {
  // finds lowest number divisible by all numbers between low and high
  // how? finds a numbers prime factors and if it has one or one extra that others don't have it will be a factor to the lcm
  public static void main (String[] args) throws Exception {
    int low = 1; // may not work if changed
    int high = 20;
    int lcm = 1;
    
    for(int i = low; i <= high; i++) {
      if(isPrime(i)) {
        lcm *= highestpowered(i, high);
        System.out.println(lcm);
      }
    }
  }
  
  public static boolean isPrime(int n) {
    if(n<4) return true;
    
    if(n%2 == 0) return false;
    
    for(int i = 3; i <= Math.sqrt(n); i+=2){
      if(n % i == 0) return false;
    }
    return true;
  }
  
  // returns n to the highest power possible
  // where it remains under max
  public static int highestpowered(int n, int max) {
    int power = (int)(Math.log(max)/Math.log(n));
    return (int) Math.pow(n, power);
  }
}