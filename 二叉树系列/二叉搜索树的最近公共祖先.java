package 二叉树系列;

//给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
//百度百科中最近公共祖先的定义为：
// “对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
public class 二叉搜索树的最近公共祖先 {


    public  TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q)
            return root;
            if  (p.val < root.val && q.val < root.val ) {
              return   lowestCommonAncestor(root.left , p ,q);
            }else  if (p.val > root.val && q.val > root.val ){
              return lowestCommonAncestor(root.right , q ,p);
            }else {
                return root;
            }

    }

   /* public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.min(minDepth(root.left) + 1 ,minDepth(root.right) + 1 );
    }*/

    private int depth(TreeNode root , TreeNode p ,int deep){
        if (root == null)
            return -1;
        if (root == p)
            return deep;
        return Math.max(depth(root.left , p , deep + 1) ,depth(root.right , p , deep + 1) );
    }

    private TreeNode findParent(TreeNode root ,TreeNode p){
        if (root == null)
            return null;
        if (root.left == p || root.right == p){
            return root;
        }else {
          return  findParent(root.right , p) == null ?findParent(root.left , p):findParent(root.right , p);
        }
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(6);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(8);
        root1.right.right = new TreeNode(9);
        root1.right.left = new TreeNode(7);
        root1.left.left = new TreeNode(0);
        root1.left.right = new TreeNode(4);
        root1.left.right.left = new TreeNode(3);
        root1.left.right.right = new TreeNode(5);
        new 二叉搜索树的最近公共祖先().lowestCommonAncestor(root1 ,root1.left ,root1.right);
    }
}
