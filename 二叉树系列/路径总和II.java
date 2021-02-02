package 二叉树系列;

import java.util.ArrayList;
import java.util.List;

//给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
public class 路径总和II {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return new ArrayList<>();
        }
        if(root.val == sum && root.left == null && root.right == null){
            List<Integer> nodes = new ArrayList<>();
            nodes.add(root.val);
            ans.add(nodes);
            return ans;
        }
        List<List<Integer>> left = pathSum(root.left , sum - root.val);
        List<List<Integer>> right = pathSum(root.right , sum - root.val);
        for (List<Integer> list:left) {
            list.add(0 , root.val);
            ans.add(list);
        }
        for (List<Integer> list:right) {
            list.add(0,root.val);
            ans.add(list);
        }
        return ans;
    }


}
