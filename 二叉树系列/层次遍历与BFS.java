package 二叉树系列;

import java.util.*;

//给定一个二叉树，返回其按层次遍历的节点值。（即逐层地，从左到右访问所有节点）
public class 层次遍历与BFS {

    //BFS
    public List<List<Integer>> levelOrder_BFS(TreeNode root) {
        List<List<Integer>> nodesList=new ArrayList<>();
        if (root == null) {
            return nodesList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        //nodesList.add(Collections.singletonList(root.val));
        while (!queue.isEmpty()){
            List<Integer> list =new ArrayList<>();
            int size=queue.size();
            for (int i = 0; i < size ; i++) {
              TreeNode node = queue.remove();
              list.add(node.val);
                if (node.left !=null)
                    queue.add(node.left);
                if (node.right !=null)
                    queue.add(node.right);
            }
            nodesList.add(list);
        }
        return nodesList;
    }






}
