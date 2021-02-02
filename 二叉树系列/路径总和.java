package 二叉树系列;

//给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
public class 路径总和 {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        int count = root.val;
        if (root.right != null || root.left != null) {
            if (root.right == null) {
                return hasPathSum(root.left, sum - count);
            } else if (root.left == null) {
                return hasPathSum(root.right, sum - count);
            } else {
                return hasPathSum(root.right, sum - count) || hasPathSum(root.left, sum - count);
            }
        } else {
            return count == sum;
        }
    }

    private TreeNode Max(TreeNode a ,TreeNode b ,TreeNode c){
        TreeNode max = a.val > b.val ? a : b ;
        max = max.val > c.val ? max : c ;
        return max;
    }

}
