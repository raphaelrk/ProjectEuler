import java.io.*;
class Main {
  // in a grid, being only able to move
  // right and down, how many ways are
  // there to go from the top-left to
  // lower-right corners?
  // based on http://www.robertdickau.com/lattices.html
  
  // if doing this again, do it faster! no
  // matter what you do there are 
  // (grid width) rights you always
  // have to make and (grid height) downs
  // so this is an n Choose k problem
  // imagining a grid of gw + gh
  // n is the size of the grid, k is the 
  // width or height. So for this it'd be
  // n! / ((n - k)! * k!)
  // n is gw + gh and k is either one
  // (gw+gh)!/((gw+gh-gw)!(gw)!
  // (gw+gh)!/(gw!gh!)
  
  // 40!/(20!20!). :D
  
  public static void main (String[] args) throws Exception {
    // number of vertices in a row/col
    int size = 21;
    // vertices
    long[][] pts=new long[size][size];
    
    // first fills left and top with 1's
    pts[0][0] = 1;
    for(int i = 1; i < size; i++) {
      pts[i][0] = 1;
      pts[0][i] = 1;
    }
    // then loops through the 
    // "L" of unfilled boxes
    // adjacent to the filled cols/rows
    // first fills corner then the rest of the
    // row/ column
    // fills them with the sum of the box
    // above them and the box left of them
    for(int r = 1; r < size; r++) {
      pts[r][r] = pts[r-1][r] + pts[r][r-1];
      
      for(int c = r + 1; c < size; c++) {
        pts[r][c] = pts[r-1][c] + pts[r][c-1];
        pts[c][r] = pts[c-1][r] + pts[c][r-1];
      }
    }
    
    long paths = pts[size-1][size-1];
    
    System.out.println("PATHS: "+paths);
    for(int i = 0; i < size; i++) {
      for(int j = 0; j < size; j++) {
        System.out.println(pts[i][j] + " ");
      }
      System.out.println();
    }
  }
}