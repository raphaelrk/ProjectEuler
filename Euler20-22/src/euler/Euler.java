
package euler;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 *
 * @author RAPHAEL
 */
public class Euler {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();  
        
        // call the probelm's "main" method here
        Euler21Main();
        
        long endTime = System.currentTimeMillis();
        System.out.println("Took " + (endTime - startTime) + " milliseconds.");
    }
    
    public static void Euler20Main() {
        int a;
        a = sumDigits(bigFactorial(100).toString());
        System.out.println("Answer: " + a);
    }
    
    public static void Euler21Main() {
        int sum = 0;
        int max = 10000;
        
        // stores whether number is amicable
        boolean[] amicableArr = new boolean[max]; 
        
        for(int i = 1; i < max; i++) {
            if(amicableArr[i] == false) {
                int amicable = isAmicable(i);
                if(amicable != -1) {
                    sum += i;
                    sum += amicable;
                    amicableArr[i] = true;
                    amicableArr[amicable] = true;
                }
            }
        }
        System.out.println("Answer: " + sum);
    }
    
    public static void Euler22Main() {
        
    }
    
    /**
     * Used in Euler 20
     * @param n 
     * @return n!
     */
    public static BigInteger bigFactorial(int n) {
        BigInteger fact = BigInteger.ONE;
        while(n > 1) {
            fact = fact.multiply(new BigInteger(Integer.toString(n)));
            n--;
        }
        return fact;
    }
    /**
     * Used in Euler 20
     * @param s string representation of number
     * @return sum of digits in s
     */
    public static int sumDigits(String s) {
        int sum = 0;
        for(int i = 0; i < s.length(); i++) {
            sum += Integer.parseInt(s.substring(i, i + 1));
        }
        return sum;
    }
    /**
     * Used in Euler 21
     * Determines whether the sum of the proper divisors of n
     * Equals n when you sum its proper divisors, and the
     * sum of the proper divisors doesn't equal n
     * @param n
     * @return -1 if isn't amicable, amicable pair if it is
     */
    public static int isAmicable(int n) {
        
        // divs1 is n's divisors
        // divs1sum is n's possible amicable pair
        ArrayList<Integer> divs1 = getDivisors(n);
        int divs1sum = sumArrayList(divs1) - n;
        
        if(divs1sum == n) return -1;
        
        // divs2 is the possible pair's divisors
        // divs2sum is the sum of the possible pairs divisors
        // and equals n if amicable
        ArrayList<Integer> divs2 = getDivisors(divs1sum);
        int divs2sum = sumArrayList(divs2) - divs1sum;
        
        /*
        System.out.println("N: " + n);
        System.out.println("  1: " + divs1sum + " l: " + divs1.size());
        System.out.println("  2: " + divs2sum + " l: " + divs1.size());
        System.out.println(" am: " + (n == divs2sum));
        */
        
        if (n == divs2sum) return divs1sum;
        return -1;
    }
    
    /**
     * Used in Euler 21
     * @return a list of n's divisors including 1 and n
     */
    public static ArrayList<Integer> getDivisors(int n) {
        ArrayList<Integer> divs = new ArrayList<Integer>();
        for(int i = 1; i < Math.sqrt(n); i++) {
            if(n % i == 0) {
                divs.add(new Integer(i));
                divs.add(new Integer(n / i));
            }
        }
        return divs;
    }
    
    /**
     * Used in Euler 21
     * @return sum of all numbers in ArrayList arr
     */
    public static int sumArrayList(ArrayList<Integer> arr) {
        int sum = 0;
        for(int i = 0; i < arr.size(); i++) {
            sum += arr.get(i);
        }
        return sum;
    }
}
