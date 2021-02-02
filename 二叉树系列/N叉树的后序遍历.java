package 二叉树系列;

import java.util.ArrayList;
import java.util.List;

//给定一个 N 叉树，返回其节点值的后序遍历。
public class N叉树的后序遍历 {
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


    public List<Integer> postorder(Node root) {
        if(root == null)
            return new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        postorder(root,arr);
        return arr;
    }

    private void postorder(Node root ,List<Integer> list){
        if (root == null)
            return;
        for (Node node:root.children) {
            postorder(node,list);
        }
        list.add(root.val);
    }
}
