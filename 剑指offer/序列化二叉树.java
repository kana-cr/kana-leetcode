package 剑指offer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;




public class 序列化二叉树 {

    class Codec {
        

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if(root == null) return null;
            StringBuilder builder = new StringBuilder();
            LinkedList<TreeNode> stack = new LinkedList<>();
            stack.push(root);
            while(!stack.isEmpty()){
                int size = stack.size();
                for (int i = 0; i < size; i++) {
                    TreeNode cur = stack.pop();
                    if(cur != null){
                    builder.append(cur.val);
                    stack.addLast(cur.left);
                    stack.addLast(cur.right);
                }else{
                    builder.append("null");
                }
                builder.append(",");
                }
                
            }
            return builder.toString();
        }
    
        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if(data.equals("") || data == null) return null;
            String[] nodes = data.split(",");
            int index = 0;
            TreeNode root = buildNode(nodes[index++]);
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while(!queue.isEmpty()){
                TreeNode cur = queue.pop();
                TreeNode left = buildNode(nodes[index++]);
                TreeNode right = buildNode(nodes[index++]);
                cur.left = left;
                cur.right = right;
                if(left != null) queue.addLast(left);
                if(right != null) queue.addLast(right);
            }
            return root;
        }

        public TreeNode buildNode(String val){
            if(val.equals("null")) return null;
            return new TreeNode(Integer.valueOf(val));
        }
       
    }

}