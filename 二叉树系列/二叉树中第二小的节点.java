package 二叉树系列;

import java.util.HashMap;
import java.util.Map;

public class 二叉树中第二小的节点 {

    private HashMap<Integer,Integer> map = new HashMap<>();

    public int findSecondMinimumValue(TreeNode root) {
      dfs(root);
      int min = root.val;
      boolean exist = false;
        for (Map.Entry num: map.entrySet()) {
           min = Math.min((int)num.getValue() , min);
        }
        int secondMin = Integer.MAX_VALUE;
        for (Map.Entry num: map.entrySet()) {
            if ((int)num.getValue() == min)
                continue;
            if ((int)num.getValue() == Integer.MAX_VALUE){
                exist = true;
            }
            secondMin = Math.min((int)num.getValue() , secondMin);
        }
        return secondMin == Integer.MAX_VALUE  && !exist ? -1 :secondMin;
    }

    private void dfs(TreeNode root){
        if (root == null)
            return;
        map.putIfAbsent(root.val,root.val);
        dfs(root.left);
        dfs(root.right);
    }



    public int findSecondMinimumValue_right(TreeNode root) {
       return traverse(root,root.val);

    }
    public int traverse(TreeNode root, int val) {
        if (root == null)
            return -1;
        if (root.val > val) {
            return root.val;
        }
        int left = traverse(root.left,val);
        int right = traverse(root.right,val);
        if (left > val && right > val){
            return Math.min(left,right);
        }
        return Math.max(left,right);
    }

}
