package 二叉树系列;

import java.util.ArrayList;
import java.util.List;

//给定一棵二叉搜索树，请找出其中第k大的节点。
public class 二叉搜索树的第k大节点 {

    public int kthLargest(TreeNode root, int k) {
        List<Integer> valList = new ArrayList<>();
        inorderTraversal(root,valList);
       return valList.get(valList.size() - k);
           }

    private void inorderTraversal(TreeNode root , List<Integer> valList){
        if (root == null)
            return;
        if (root.left != null) {
            inorderTraversal(root.left,valList);
        }
        valList.add(root.val);
        if (root.right != null) {
            inorderTraversal(root.right,valList);
        }
    }
}
