package 剑指offer;

import java.util.Arrays;

public class 重建二叉树 {
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0)
          return null;
        int rootVal = 0;
      for (int i = 0; i < inorder.length; i++) {
          //找到子树的根
          if(inorder[i] == preorder[0]){rootVal = i; break;} 
      }
      TreeNode root = new TreeNode(inorder[rootVal]);
      root = build(preorder, inorder);
      return root;
    }
    
    private TreeNode build(int[] preorder, int[] inorder){
      if(preorder.length == 0) return null;
      
      TreeNode root = new TreeNode(preorder[0]);
      int mid = 0;
      for (int i = 0; i <= inorder.length; i++) {
          //找到子树的根
          if(inorder[i] == preorder[0]){mid = i; break;} 
      }
      root.left = build(Arrays.copyOfRange(preorder, 1, mid),Arrays.copyOfRange(inorder, 0, mid));
      root.right = build(Arrays.copyOfRange(preorder, mid + 1, preorder.length),Arrays.copyOfRange(inorder, mid + 1, inorder.length));
      return root;
    }
}