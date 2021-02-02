package 七天练.树;

import java.util.ArrayList;
import java.util.List;

public class 验证二叉查找树 {
    //中序遍历
    public boolean isValidBST(TreeNode root) {
    if(root == null) return true;
    List<Integer> nodes = new ArrayList<>();
    orderBST(root.left, nodes); 
    nodes.add(root.val);
    orderBST(root.right,nodes);
   for (int i = 1; i < nodes.size(); i++) {
    if(nodes.get(i)<=nodes.get(i-1)) return false;
   }
    return true;
    }
    private void orderBST(TreeNode root ,List<Integer> list){
        if(root == null) return;
        if(root.left!=null) orderBST(root.left, list);
        list.add(root.val);
        if(root.right!=null)orderBST(root.right, list);
    }
}