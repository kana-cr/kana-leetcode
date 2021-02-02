package 数组系列;



//给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
//注：不能转整型做加法，因为有长度限制
public class 加一 {

    public int[] plus_one(int[] nums){
        for (int i = nums.length-1; i >= 0; i--) {
            if (nums[i]!=9){
                nums[i]+=1;
                break;
            }else {
                nums[i]=0;
                if (i==0){
                  int[] new_arr=new int[nums.length + 1];
                  new_arr[0]=1;
                  //后面全为0
                    nums=new_arr;
                }
            }
        }
        return nums;
    }

}
