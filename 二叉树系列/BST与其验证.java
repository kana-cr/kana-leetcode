package 二叉树系列;

import java.util.ArrayList;
import java.util.List;

//二叉搜索树
//它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
// 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
// 它的左、右子树也分别为二叉搜索树
public class BST与其验证 {

    //引入上界与下界，用以保存之前的节点中出现的最大值与最小值
    //leetcode提交会因为测试样例的最大值为MAX_VALUE导致出错
    public boolean isValidBST_Recursion(TreeNode root) {
           if (root==null)
               return true;

    return isBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    private boolean isBST(TreeNode root,int min,int max){
        if (root==null)
            return true;
        if (min >= root.val || max <= root.val )
            return false;
        return isBST(root.left,min,root.val)&&isBST(root.right,root.val,max);
    }

    public boolean isValidBST(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        orderBST(list, root);
        for (int i = 0; i <list.size()-1 ; i++) {
            if (list.get(i) >=list.get(i+1))
                return false;
        }
        return true;
    }
    private void orderBST(List<Integer> list,TreeNode root){
        if (root==null)
            return;
        orderBST(list,root.left);
        list.add(root.val);
        orderBST(list,root.right);
    }
}
