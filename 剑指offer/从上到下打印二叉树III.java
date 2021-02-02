package 剑指offer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class 从上到下打印二叉树III {
    
    public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    if(root == null) return res;
    boolean p = false;
    Deque<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);
    while(!queue.isEmpty()){
        int size = queue.size();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            TreeNode node = queue.pop();
            if(node.left != null) queue.addLast(node.left);
            if(node.right != null) queue.addLast(node.right);
            list.add(node.val);
        }
        if(p) Collections.reverse(list);
        res.add(list);
        p = !p;
    }
    return res;
    }
}