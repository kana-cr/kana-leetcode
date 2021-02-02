package 二叉树系列;

import java.util.Stack;

//请完成一个函数，输入一个二叉树，该函数输出它的镜像。
public class 二叉树的镜像 {

    public TreeNode mirrorTree_Re(TreeNode root) {
        if (root == null)
            return null;
        TreeNode right = root.right;
        root.right = root.left;
        root.left = right;
        if (root.right != null)
        mirrorTree(root.right);
        if (root.left != null)
        mirrorTree(root.left);
        return root;
    }

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null)
            return null;
        Stack<TreeNode> nodes = new Stack<>();
        nodes.add(root);
        while (!nodes.isEmpty()){
            TreeNode node = nodes.pop();
            TreeNode right = node.right;
            node.right = node.left;
            node.left = right;
            if (node.right != null)
            nodes.push(node.right);
            if (node.left != null)
            nodes.push(node.left);
        }
        return root;
    }
}
