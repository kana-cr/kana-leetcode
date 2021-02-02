package 二叉树系列;

//给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
//假定 BST 有如下定义：
//    结点左子树中所含结点的值小于等于当前结点的值
//    结点右子树中所含结点的值大于等于当前结点的值
//    左子树和右子树都是二叉搜索树

import java.util.ArrayList;

public class 二叉搜索树中的众数 {
    private int maxCount = 0;
    private int curCount = 0;
    private int preVal = 0;
    ArrayList<Integer> list = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        traverse(root);
        int size = list.size();
        int[] ans = new int[size];
        for(int i = 0; i < size; i++){
            ans[i] = list.get(i);
        }
        return ans;
    }

    private void traverse(TreeNode root) {
        if (root != null){
            traverse(root.left);
            if (root.val == preVal){
                    curCount++;
            }else {
                preVal = root.val;
                curCount = 1;
            }
            if (curCount == maxCount){
                list.add(root.val);
            }else if (curCount > maxCount){
                maxCount = curCount;
                list.clear();
                list.add(root.val);
            }
            traverse(root.right);
        }
    }

}
