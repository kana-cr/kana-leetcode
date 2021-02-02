package 剑指offer;

import java.util.ArrayList;
import java.util.List;

public class 二叉树中和为某一值的路径 {
    
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null) return res;
        add(root, sum, new ArrayList<>());
        return res;
    }

    private void add(TreeNode root , int sum ,List<Integer> list){
        list.add(root.val);
        if(sum -root.val == 0 ) {
            if(root.left == null && root.right == null){
                res.add(list); 
                return;
            }
        }
        if(root.left != null) add(root.left, sum - root.val, new ArrayList<>(list)); 
        if(root.right != null) add(root.right, sum - root.val, new ArrayList<>(list)); 
    }
}