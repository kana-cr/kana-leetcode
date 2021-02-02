package 剑指offer;

public class 剪绳子 {

    public int cuttingRope(int n) {
    int res = 1;
    if(n <= 3) return n - 1;
    while(n > 3){
    if(n == 4){
        res *= 4;
        return res;
    }    
    n -= 3;
    res *= 3; 
    }
    return res * n;
    }
}