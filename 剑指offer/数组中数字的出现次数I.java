package 剑指offer;


public class 数组中数字的出现次数I {
    
    public int[] singleNumbers(int[] nums) {
       int a = 0;
       for (int i = 0; i < nums.length; i++) {
           a ^= nums[i];
       }
       int n = 0;
       while(a != 0){
           if((a & 1) == 1) break;
            a >>= 1;
            n++;   
       }
       a = 0;
       int b = 0;
       for (int i = 0; i < nums.length; i++) {
           if( ( (nums[i] >> n) & 1 ) == 1) a ^= nums[i];
           else b ^= nums[i];
       }
       int[] res = {a , b};
       return res;
    }
}