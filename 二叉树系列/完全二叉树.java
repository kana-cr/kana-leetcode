package 二叉树系列;

//给出一个完全二叉树，求出该树的节点个数。
public class 完全二叉树 {

    //暴力递归
    public int countNodes_Recursion(TreeNode root) {
    if (root==null)
        return 0;
    return 1+ countNodes_Recursion(root.left) + countNodes_Recursion(root.right);
    }

    //利用完全二叉树的性质
    //将该完全二叉树可以分割成若干满二叉树和完全二叉树，满二叉树直接根据层高h计算出节点为2^h-1，然后继续计算子树中完全二叉树节点
    //对任意一个子树，遍历其左子树层高left，右子树层高right，相等左子树则是满二叉树，否则右子树是满二叉树
    public int countNodes(TreeNode root) {
    if (root==null)
        return 0;
    int left=countLevels(root.left);
    int right=countLevels(root.right);
    if (left==right){
      return (1<<left) + countNodes(root.right);
    }else {
      return (1<<right) + countNodes(root.left);
    }

    }

    private int countLevels(TreeNode root) {
        int level = 0;
        //因为是完全二叉树 所以有最左节点肯定有右节点
        while (root!=null){
         root=root.left;
         level++;
        }
        return level;
    }
}
