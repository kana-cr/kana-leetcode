package 七天练.树;

public class 翻转二叉树 {

    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        invertTree(root.right);
        invertTree(root.left);
        return root;
    }
    
}