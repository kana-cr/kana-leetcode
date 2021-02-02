package 剑指offer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;


public class 二叉_搜索_树的最近公共祖先 {

    public TreeNode lowestCommonAncestor_BST(TreeNode root, TreeNode p, TreeNode q) {
        if(isChildNode(p, q)) return p;
        if(isChildNode(q, p)) return q;
        if( (root.val < p.val && root.val > q.val) || (root.val < q.val && root.val > p.val) ) return root;
        else if(root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
        else return lowestCommonAncestor(root.left, p, q);
    }

    
    //非搜索树情况
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(isChildNode(p, q)) return p;
        if(isChildNode(q, p)) return q;
        if(isChildNode(root.left, p) && isChildNode(root.left, q)) return lowestCommonAncestor(root.left, p, q);
       else if(isChildNode(root.right, p) && isChildNode(root.right, q)) return lowestCommonAncestor(root.right, p, q);  
       return root;

    }

    public boolean isChildNode(TreeNode root , TreeNode node){
        if(root == null) return false;
        if(root.left == node || root.right == node) return true;
        return isChildNode(root.left, node)||isChildNode(root.right, node);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return null;
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> nodes = new ArrayDeque<>();
        nodes.push(root);
        while(!nodes.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = nodes.pop();
                list.add(cur.val);
                if(cur.left != null) nodes.addLast(cur.left);
                if(cur.right != null)nodes.addLast(cur.right);
            }
            res.add(list);
        }
        return res;
    }

    public int[] levelOrder_arr(TreeNode root) {
        if(root == null) return new int[0];
        Deque<TreeNode> nodes = new ArrayDeque<>();
        nodes.push(root);
        List<Integer> list = new ArrayList<>();
        while(!nodes.isEmpty()){
            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = nodes.pop();
                list.add(cur.val);
                if(cur.left != null) nodes.addLast(cur.left);
                if(cur.right != null)nodes.addLast(cur.right);
            }
          } 
          int[] res = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                  res[i] = list.get(i);
            }
        return res;
    }
    
    //判断二叉平衡树
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        if (Math.abs( depth(root.left) - depth(root.right) ) > 1 ) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int depth(TreeNode root){
        if(root == null) return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }

  
}