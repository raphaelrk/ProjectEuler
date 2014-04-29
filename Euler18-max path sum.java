import java.io.*;
import java.util.Scanner;
class Main {
  // finds path down an 
  // equilateral triangle with
  // max sum of points on way down
  // works bottom-up finding the best way 
  // down for all in the second to last row
  // then best way for all in the third to last
  // row based on it, and on until
  // the top is reached
  
  // used on Euler 18 and 67
  public static void main (String[] args) throws Exception {
    // how many rows
    int size = 100;
    
    // [row, col] initial triangle
    int[][] triangle = new int[size][size];
    
    // visualize triangle like this: 
    // 15 00 00 00
    // 12 13 00 00
    // 29 16 17 00
    // 11 16 21 13
    
    // scan in the triangle
    Scanner sc = new Scanner(System.in);
    try {
      for(int i = 0; i < size; i++) {
        String[] nums = sc.nextLine().split("\\s");
        for(int j = 0; j <= i; j++){
          int num = Integer.parseInt(nums[j]);
          triangle[i][j] = num;
        }
      }
    } catch(Exception e) {
      e.printStackTrace();
      System.out.println("fff");
    }
    
    // changes numbers in the triangle
    // so the numbers sum the max path
    // below them
    for(int r = size - 2; r >= 0; r--) {
      for(int c = 0; c <= r; c++) {
        int below = triangle[r+1][c];
        // "below and right"
        int bandr = triangle[r+1][c+1];
        int max = Math.max(below, bandr);
        triangle[r][c] += max;
      }
    }
    
    System.out.println("MAX PATH SUM: " + triangle[0][0]);
    
  }
}