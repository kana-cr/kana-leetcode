package 剑指offer;

public class 对称的二叉树 {
    
      //判断对称二叉树
      public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
      return helper(root.left, root.right);
    }
    
    public boolean helper(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        if(root1.val != root2.val) return false;
      return  helper(root1.left, root2.right) && helper(root1.right, root2.left);
        
    }
}