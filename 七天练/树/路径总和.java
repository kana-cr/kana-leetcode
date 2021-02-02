package 七天练.树;

public class 路径总和 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
        return false;
        int count = root.val;
        if(sum - count == 0 && root.right == null && root.left == null) return true;
        return hasPathSum(root.left, sum - count) || hasPathSum(root.right, sum - count);  
        
    }
}