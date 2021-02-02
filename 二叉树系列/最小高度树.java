package 二叉树系列;

import java.util.Arrays;

//给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树
public class 最小高度树 {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0)
            return null;
        else if (nums.length == 1)
            return new TreeNode(nums[0]);
        else if (nums.length == 2){
          TreeNode root =  new TreeNode(nums[0]);
          root.right = new TreeNode(nums[1]);
          return root;
        }
        int mid = (nums.length - 1) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        traverse(root, Arrays.copyOfRange(nums,mid + 1 , nums.length ));
        traverse(root,Arrays.copyOf(nums,mid));
        return root;
    }

    private void traverse(TreeNode root , int[] nums) {
        if (nums.length <= 2){
            if (nums[0] < root.val){
                root.left = new TreeNode(nums[0]);
                if (nums.length == 2)
                    root.left.right = new TreeNode(nums[1]);
            }else {
                root.right =new TreeNode(nums[0]);
                if (nums.length == 2)
                    root.right.right = new TreeNode(nums[1]);
            }
        }else {
            int mid = (nums.length - 1) / 2;
            if (nums[mid] < root.val){
                root.left = new TreeNode(nums[mid]);
                traverse(root.left,Arrays.copyOfRange(nums,mid + 1 , nums.length ));
                traverse(root.left,Arrays.copyOf(nums,mid));
            }else {
                root.right = new TreeNode(nums[mid]);
                traverse(root.right,Arrays.copyOfRange(nums,mid + 1 , nums.length ));
                traverse(root.right,Arrays.copyOf(nums,mid));
            }
        }
    }


}
