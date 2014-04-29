import java.io.*;
import java.util.ArrayList;
class Main {
  // Finds the largest palindrome made from the product of two 3-digit numbers.
  public static void main (String[] args) throws Exception {
    
    int maxNumber = 999;
    int minNumber = 900;
    
    ArrayList<Integer> products;
    products = new ArrayList<Integer>();
    
    for(int n1 = maxNumber; n1 > minNumber;n1--) {
      for(int n2=n1; n2 > minNumber; n2--) {
        int product = n1*n2;
        //System.out.println(product);
        if(isPalindrome(product)) {
          System.out.println(product + " " 
                            + n1 + "x" + n2);
          products.add(product);
        }
      }
    }
    int maxProduct = alistMax(products);
    System.out.println("!!! " + maxProduct);
  }
  
  public static boolean isPalindrome(int n) {
    StringBuilder sb = new StringBuilder();
    sb.append(n);
    
    String s = new String(sb);
    
    for(int i = 0; i < s.length()/2; i++) {
      if(s.charAt(i) != s.charAt(s.length()-i-1)){
        return false;
      }
    }
    return true;
  }
           
  public static int alistMax(ArrayList<Integer> l){
    int max = l.get(0);
    for(int i = 1; i < l.size(); i++) {
      if(l.get(i) > max) max = l.get(i);
    }
    return max;
  }
}