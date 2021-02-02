package 剑指offer;

import java.util.ArrayList;
import java.util.List;

public class 二叉搜索树与双向链表 {
    
    
    public Node treeToDoublyList(Node root) {
        if(root == null) return null;
        List<Node> nodes = new ArrayList<>();
        build(root,nodes);
        Node head = nodes.get(0);
        Node last = nodes.get(nodes.size() - 1);
        for (int i = 1; i < nodes.size(); i++) {
            nodes.get(i - 1).right = nodes.get(i);
            nodes.get(i).left = nodes.get(i - 1);
        }
        head.left = last;
        last.right = head;
        return head;
    }

    //中序遍历
    private void build(Node root , List<Node> list){
        if(root == null) return;
        if(root.left != null) build(root.left, list);
        list.add(root);
        if(root.right != null) build(root.right, list);
    }
}