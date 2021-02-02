package 二叉树系列;

//二叉树常被用于实现二叉查找树和二叉堆。树比链表稍微复杂，因为链表是线性数据结构，而树不是。
// 树的问题很多都可以由广度优先搜索或深度优先搜索解决。

import java.util.*;

//给定一个二叉树，找出其最大深度。二叉树的深度为根节点到最远叶子节点的最长路径上的节点数
public class 二叉树的最大深度 {



    //递归 (DFS) 耗时
    //在递归中，如果层级过深，我们很可能保存过多的临时变量，导致栈溢出
    public int maxDepth(TreeNode root) {
        if (root==null)
            return 0;
        return maxDepth(root.left) > maxDepth(root.right)?maxDepth(root.left)+ 1 :maxDepth(root.right)+ 1;
    }

    //BFS 广度优先搜索
    public int maxDepth_BFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return level;
    }

    //使用栈的非递归
    //非递归的DFS遍历
    public List<TreeNode> traversal(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.empty()){
            TreeNode node= stack.peek();
            res.add(node);
            stack.pop();
            if (node.right!=null)
                stack.push(node.right);
            if (node.left!=null)
                stack.push(node.left);
        }
        return res;
    }

    private int maxDepth_dfs(TreeNode root) {
        if (root==null)
            return 0;
        int depth=1;
        int dep1=depth;
        int dep2=depth;
        if (root.left!=null)
           dep1 = Traverse(root.left,depth + 1);
        if (root.right!=null)
           dep2 = Traverse(root.right,depth + 1);
        depth=dep1>dep2?dep1:dep2;
        return depth;
    }
    //dfs
  private int Traverse(TreeNode treeNode,int depth){
      int dep1=depth;
      int dep2=depth;
        if (treeNode.right!=null)
            dep1 = Traverse(treeNode.right,depth + 1);
        if (treeNode.left!=null)
            dep2 =  Traverse(treeNode.left,depth + 1);
       return dep1>dep2?dep1:dep2;
  }


}
