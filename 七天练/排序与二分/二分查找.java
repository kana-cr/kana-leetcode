package 七天练.排序与二分;



public class 二分查找 {
    
    //查找等于给定值的元素
    public int binarySearch(int[] arr,int n,int value){
        if(n < 1) return -1;
        int low = 0;
        int high = n-1;
        while(low<=high){
            int mid = (low + high) >> 1;//或者使用 low + ( (high-low) >> 1) 防止int越界
            if(arr[mid]<value){
              low = mid + 1;
            }else if(arr[mid]>value){
              high = mid - 1;
            }else{
                return mid;
            }
        } 
        return -1;
    }

    //查找第一个等于给定值的元素
    public int binarySearch_first(int[] arr,int n,int value){
        if(n < 1) return -1;
        int low = 0;
        int high = n-1;
        while(low<=high){
            int mid = low + ( (high-low) >> 1);
            if(arr[mid]<value){
              low = mid + 1;
            }else if(arr[mid]>value){
              high = mid - 1;
            }else{
                if ((mid == 0) || (arr[mid - 1] != value)) return mid;
                else high = mid - 1;
            }
        } 
        return -1;
    }

     //模糊二分查找算法
     //查找第一个大于等于给定值的元素
     public int binarySearch_mohu(int[] arr,int n,int value){
        if(n < 1) return -1;
        int low = 0;
        int high = n-1;
        while(low<=high){
            int mid = low + ( (high-low) >> 1);
            if(arr[mid]>=value){
            if ((mid == 0) || (arr[mid - 1] < value)) return mid;
            else high = mid - 1;
            }else{
                low = mid + 1;
            }
        } 
        return -1;
    }

    //使用二分的例题
    //x 的平方根
public int mySqrt(int x) {
   if(x==0) return 0;

    int low = 1;
    int high = x;
    int mid = -1;
    int ans = 0;
   while(low<=high){
         mid = low + ( (high-low) >> 1);
        if(mid>x/mid){
            high = mid - 1;
        }else{
            ans = mid;
            low = mid + 1;
        }
    }
    return ans;
    }

    public int mySqrt_leetcode(int x) {
        if (x == 0) return 0;
               long left = 1;
               long right = x / 2;
               while (left < right) {
                   
                   long mid = (right + left) / 2 + 1;
                   if (mid > x / mid) {
                       right = mid - 1;
                   } else {
                       left = mid;
                   }
               }
               return (int) left;
           }


    //704. 二分查找       
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        //求一个数的区间
        while(left<=right){

        int mid = (left + right) >>> 1;
        if(nums[mid] > target){
          right = mid - 1;
        }else if(nums[mid] < target){
          left = mid + 1;
        }else{
            return mid;
        } }
        return -1;
        }

        //35. 搜索插入位置 解法一
            public int searchInsert(int[] nums, int target) {
                int left = 0;
                int right = nums.length - 1;
                while(left<=right){
        
                int mid = (left + right) >>> 1;
                if(nums[mid] > target){
                  right = mid - 1;
                }else if(nums[mid] < target){
                  left = mid + 1;
                }else{
                    return mid;
                } }
                return left;
            }

             //35. 搜索插入位置 解法二
             public int searchInsert_another(int[] nums, int target) {
                int left = 0;
                int right = nums.length - 1;
                //求一个数的区间
                while(left < right){
                int mid = (left + right) >>> 1;
                  // 严格小于 target 的元素一定不是解
                  if(nums[mid] < target){
                    // 下一轮搜索区间是 [mid + 1, right]
                  left = mid + 1;
                }else{
                     // 下一轮搜索区间是 [left, mid]
                    right = mid;
                } }
                return left;
            }
}