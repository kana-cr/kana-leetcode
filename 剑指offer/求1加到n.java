package 剑指offer;

public class 求1加到n {
    
    @SuppressWarnings("unused") 
    public int sumNums(int n) {
      int sum = n;
      boolean t = ( (n != 0) && (sum += sumNums(n - 1)) > 0);
      return sum;
    }
}