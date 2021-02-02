package 二叉树系列;

//给定一个二叉树，判断它是否是高度平衡的二叉树。
public class 平衡二叉树 {

    public boolean isBalanced(TreeNode root) {
        if (root==null)
            return true;
        if (!isBalanced(root.left)||!isBalanced(root.right))
            return false;
        int leftHigh=maxDepth(root.left) + 1;
        int rightHigh=maxDepth(root.right) + 1;
        return Math.abs(leftHigh - rightHigh) <= 1;
    }

    public int maxDepth(TreeNode root) {
        if (root==null)
            return 0;
        return maxDepth(root.left) > maxDepth(root.right)?maxDepth(root.left)+ 1 :maxDepth(root.right)+ 1;
    }

}
