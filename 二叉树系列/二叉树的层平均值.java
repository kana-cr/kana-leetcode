package 二叉树系列;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//给定一个非空二叉树, 返回一个由每层节点平均值组成的数组
public class 二叉树的层平均值 {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> avgList = new ArrayList<>();
        if (root == null)
            return avgList;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            double avg = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if (node.left !=null)
                    queue.add(node.left);
                if (node.right !=null)
                    queue.add(node.right);
                avg += node.val;
            }
            avg /= size;
            avgList.add(avg);
        }
        return avgList;
    }
}
