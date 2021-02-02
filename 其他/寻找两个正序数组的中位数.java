package 其他;

//给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m n))。
// 你可以假设 nums1 和 nums2 不会同时为空。
public class 寻找两个正序数组的中位数 {

    public static double findMedianSortedArrays_bl(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0){
           if (nums1.length == 0){
               if (nums2.length % 2 == 0)
                   return (double) ( (nums2[nums2.length / 2] + nums2[nums2.length / 2 - 1]) / 2.0 );
               else
                   return (double) nums2[nums2.length / 2];
           }else {
               if (nums1.length % 2 == 0)
                   return (double) ( (nums1[nums1.length / 2] + nums1[nums1.length / 2 - 1]) / 2.0 );
               else
                   return (double) nums1[nums1.length / 2];
           }
        }
        int[] arr = new int[nums1.length + nums2.length];
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < nums1.length + nums2.length; i++) {
            if (nums1[index1] < nums2[index2] ){
                arr[i] = nums1[index1];
                index1 ++;
                if (index1 == nums1.length){
                    while (index2 < nums2.length)
                        arr[++i] = nums2[index2++];
                }
            }else {
                arr[i] = nums2[index2];
                index2 ++;
                if (index2 == nums2.length){
                    while (index1 < nums1.length)
                        arr[++i] = nums1[index1++];
                }
            }
        }
        if (arr.length % 2 == 0)
            return (double) ((arr[arr.length / 2] + arr[arr.length / 2 - 1]) / 2.0);
        else
            return (double) arr[arr.length / 2];
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int total = len1 + len2;
        int left = (total + 1) / 2;
        int right = (total + 2) / 2;
        return (findK(nums1, 0, nums2, 0, left) + findK(nums1, 0, nums2, 0, right)) / 2.0;

    }

    //找到两个数组中第k小的元素
    public int findK(int[] nums1, int i, int[] nums2, int j, int k) {
        if (i >= nums1.length)
            return nums2[j + k - 1];
        if (j >= nums2.length)
            return nums1[i + k - 1];
        if (k == 1) {
            return Math.min(nums1[i], nums2[j]);
        }
        //计算出每次要比较的两个数的值，来决定 "删除"" 哪边的元素
        int mid1 = (i + k / 2 - 1) < nums1.length ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int mid2 = (j + k / 2 - 1) < nums2.length ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
        //通过递归的方式，来模拟删除掉前K/2个元素
        if (mid1 < mid2) {
            return findK(nums1, i + k / 2, nums2, j, k - k / 2);
        }
        return findK(nums1, i, nums2, j + k / 2, k - k / 2);
    }

    public static void main(String[] args) {
       double result = findMedianSortedArrays_bl(new int[]{1,3,5,7,9},new int[]{2,4,6,8,11});
    }
}
