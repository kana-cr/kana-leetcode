package 二叉树系列;

import java.util.ArrayList;
import java.util.List;

//给你一个树，请你 按中序遍历 重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
public class 递增顺序查找树 {

    TreeNode head;
    public TreeNode increasingBST(TreeNode root) {
        if (root == null)
            return null;
        root.right = increasingBST(root.right);
        if (root.left!=null){
            TreeNode node = root.left;
            root.left = null;
            head = node;
            while (node.right!=null){
                node = node.right;
            }
            node.right = root;
            return increasingBST(head);
        }else {
            return root;
        }
    }

    public static TreeNode increasingBST_other(TreeNode root) {
        List<TreeNode> valList = new ArrayList<>();
        inorderTraversal(root,valList);
        if (valList.isEmpty())
            return null;
        for (int i = 0; i < valList.size() - 1; i++) {
            valList.get(i).right = valList.get(i + 1);
            valList.get(i).left = null;
        }
        return valList.get(0);
    }

    private static void inorderTraversal(TreeNode root , List<TreeNode> valList){
        if (root == null)
            return;
        if (root.left != null) {
            inorderTraversal(root.left,valList);
        }
        valList.add(root);
        if (root.right != null) {
            inorderTraversal(root.right,valList);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.right = new TreeNode(12);
        root.right.right = new TreeNode(13);
        root.right.left = new TreeNode(11);
        root.left = new TreeNode(7);
        root.left.right = new TreeNode(8);
        root.left.left = new TreeNode(6);
        increasingBST_other(root);
    }

}
