package 二叉树系列;

public class BST的查找 {

    //迭代
    public TreeNode searchBST(TreeNode root, int val) {
        if (root==null)
            return null;
    while (root!=null){
        if (val==root.val) {
            return root;
        } else if (val>root.val) {
            root = root.right;
        } else {
            root = root.left;
        }
    }
    return null;
    }
    //递归
    public TreeNode searchBST_Recursion(TreeNode root, int val) {
        if (root == null)
            return null;
        if (root.val > val) {
            return searchBST(root.left, val);
        } else if (root.val < val) {
            return searchBST(root.right, val);
        } else {
            return root;
        }
    }
}
