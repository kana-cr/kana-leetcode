package 二叉树系列;


import java.util.ArrayList;
import java.util.List;

public class N叉树的前序遍历 {

    //给定一个 N 叉树，返回其节点值的前序遍历。

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }


    static List<Integer> preList = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        if (root == null)
            return preList;
        preList.add(root.val);
        if (root.children == null)
            return preList;
        for (Node child: root.children) {
           preorder(child);
        }
        return preList;
    }
}
