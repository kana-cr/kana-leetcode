package 二叉树系列;

//给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。
//二叉搜索树保证具有唯一的值。
public class 二叉搜索树的范围和 {

    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null){
            return 0;
        }
        if (root.val > R){
            return rangeSumBST(root.left,L,R);
        }else if (root.val < L){
            return rangeSumBST(root.right,L,R);
        }else {
            return root.val + rangeSumBST(root.left,L,R) + rangeSumBST(root.right,L,R);
        }
    }
}
