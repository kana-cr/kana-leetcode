package 二叉树系列;

import java.util.*;

public class 二叉树的后序遍历 {


    public List<Integer> postorderTraversal_rec(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traversal(root,list);
        return list;
    }

    private void traversal(TreeNode root , List<Integer> list){
        if (root == null){
            return;
        }
        if (root.left != null){
            traversal(root.left,list);
        }
        if (root.right != null){
            traversal(root.right,list);
        }
        list.add(root.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        TreeNode node = root;
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty() || node != null){
            if (node != null) {
                queue.add(node);
                list.add(node.val);
                node = node.right;
            }else {
                node = queue.poll();
                node = node.left;
            }
        }
        //list.add(root.val);
        Collections.reverse(list);
        return list;
    }
}
