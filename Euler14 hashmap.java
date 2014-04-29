import java.io.*;
import java.util.HashMap;
class Main { 
  // this is Euler 14 with a 
  // hashmap & recursion
  // problem: longest Collatz stop time 
  // with start under 1 million?
  // winner: 837799
  public static void main (String[] args) throws Exception {
    int MAX = 1000000;
    HashMap<Long, Integer> stopTime = new HashMap<Long, Integer>();
      //value- stop time, key- number
    int maxlen = 0;
    int maxnum = 1;
    
    for(int i = 1; i < MAX; i++) {
      if(!stopTime.containsKey((long)i)) {
        int len = collatzLen(i, stopTime);
        if(len >= maxlen) {
          maxlen = len;
          maxnum = i;
          System.out.println("num: " + i + " chain: " + len);
        }
      }
    }
    System.out.println("done");
  }
  
  public static int collatzLen(long n, HashMap st) {
    int len = 0;
    long orig = n;
    if(n <= 1) return 0;
    if(st.containsKey(n)) {
      int val = ((Integer)(st.get(n))).intValue();
      return val;
    }
    if(n % 2 == 0) {
      len = 1 + collatzLen(n / 2, st);
    }
    else {
      len = 1 + collatzLen(3*n + 1, st);
    }
    st.put(orig, len);
    return len;
  }
}