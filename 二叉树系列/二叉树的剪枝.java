package 二叉树系列;

//剪枝概述：
// 假设有一棵树，最上层的是root节点，而父节点会依赖子节点。如果现在有一些节点已经标记为无效，我们要删除这些无效节点。
// 如果无效节点的依赖的节点还有效，那么不应该删除，如果无效节点和它的子节点都无效，则可以删除。
// 剪掉这些节点的过程，称为剪枝，目的是用来处理二叉树模型中的依赖问题。

//题目：
//给定二叉树根结点 root ，此外树的每个结点的值要么是 0，要么是 1。
// 返回移除了所有不包含 1 的子树的原二叉树。( 节点 X 的子树为 X 本身，以及所有 X 的后代。)
public class 二叉树的剪枝 {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null)
            return root;
            if (root.left!=null) {
                if (findChildren(root.left)) {
                    root.left = null;
                } else {
                    pruneTree(root.left);
                }
            }
            if (root.right!=null) {
                if (findChildren(root.right)) {
                    root.right = null;
                } else {
                    pruneTree(root.right);
                }
            }
        if (root.val==0&&findChildren(root.left)&&findChildren(root.right))
            return null;
        return root;
    }
    private boolean findChildren(TreeNode root){
        boolean ifNeedPrune = true;
        if (root==null)
            return ifNeedPrune;
        if (root.val==1) {
            ifNeedPrune=false;
            return ifNeedPrune;
        }
       return findChildren(root.right)&&findChildren(root.left);
    }

    public TreeNode pruneTree_Recursion(TreeNode root){
    return deal(root);
    }
    private TreeNode deal(TreeNode node){
        if (node==null)
            return null;
        node.left=deal(node.left);
        node.right=deal(node.right);
        if (node.right==null&&node.left==null&&node.val==0)
            return null;
        return node;
    }

}
