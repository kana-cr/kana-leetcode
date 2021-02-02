package 二叉树系列;

//给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
//你需要将他们合并为一个新的二叉树。
// 合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
public class 合并二叉树 {

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
       t1 = merge(t1,t2);
       if (t1 != null && t2 != null) {
          t1.left = mergeTrees(t1.left, t2.left);
          t1.right = mergeTrees(t1.right, t2.right);
       }
       return t1;
    }

    private static TreeNode merge(TreeNode t1, TreeNode t2){
        if (t1==null && t2 == null) {
            return null;
        } else if (t1==null || t2 == null){
            if (t1 == null){
                t1 = new TreeNode(t2.val);
                return t1;
            }else {
                return t1;
            }
        }else {
            t1.val = t1.val + t2.val;
            return t1;
        }
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        //root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(3);
        TreeNode root2 = new TreeNode(1);
       // root2.left  = new TreeNode(1);
        root2.right  = new TreeNode(2);
       // root2.left.right  = new TreeNode(4);
        root2.right.right = new TreeNode(3);
       TreeNode root = mergeTrees(root1,root2);
        System.out.println(root);
    }
}
