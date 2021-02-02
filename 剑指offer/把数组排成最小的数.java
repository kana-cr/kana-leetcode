package 剑指offer;

public class 把数组排成最小的数 {
    
    public String minNumber(int[] nums) {
        if(nums.length == 1) return String.valueOf(nums[0]);
        //bubble_sort
        for (int i = 1; i < nums.length; i++) {
            boolean finish = false;
            for (int j = 1; j < nums.length - i + 1; j++) {
                if(compare(nums[j - 1], nums[j])){
                    swap(nums, j - 1, j);
                    finish = true;
                }
            }
            //减少遍历次数
            if(!finish) break;
        }
        StringBuilder builder = new StringBuilder();
        for (int i : nums) {
            builder.append(String.valueOf(i));
        }
        return builder.toString();
    }
    //比较拼接后的string值
    private boolean compare(int a ,int b){
    String s1 = String.valueOf(a) + String.valueOf(b);
    String s2 = String.valueOf(b) + String.valueOf(a);
    for (int i = 0; i < s1.length(); i++) {
        if(s1.charAt(i)==s2.charAt(i)) continue;
        return s1.charAt(i) > s2.charAt(i);
    }
    return false;
    }

    private void swap(int[] nums,int a ,int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] =tmp;  
    }
}