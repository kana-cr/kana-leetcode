package 二叉树系列;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

//根据一棵树的中序遍历与后序遍历构造二叉树
public class 从中序与后序遍历序列构造二叉树 {

    //例 中序遍历 inorder = [9,3,15,20,7]  后序遍历 postorder = [9,15,7,20,3]
    public static TreeNode buildTree(int[] inorder, int[] postorder) {

        int len = inorder.length;
        if (len != postorder.length || len < 1)
            return null;
       int left = 0;
       while (inorder[left] != postorder[len - 1])
           left++;
       TreeNode node = new TreeNode(postorder[len - 1]);
       node.left = buildTree(Arrays.copyOf(inorder,left) , Arrays.copyOf(postorder,left));
       node.right = buildTree(Arrays.copyOfRange(inorder,left + 1 , len) , Arrays.copyOfRange(postorder,left , len - 1));
       return node;
    }


    public TreeNode buildTree_迭代(int[] inorder, int[] postorder) {
        if(postorder == null || postorder.length == 0 || inorder == null || inorder.length == 0 )
            return null;
        int in = inorder.length - 1, post = postorder.length - 1;
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode root = new TreeNode(postorder[post]);
        TreeNode first = root;
        stack.push(root);
        while (post > 0) {
            // 一路右下
            // 若当前两节点不同，取下一个位置的节点，相同的话，该节点已被取过
            while (postorder[post] != inorder[in]) {
                root.right = new TreeNode(postorder[--post]);
                root = root.right;
                stack.push(root);
            }
            --in;
            stack.poll();
            // 往回走，对于当前节点，中序遍历到达父节点需要先经过其左子树
            // 若相同，说明该节点不存在左子树
            while (!stack.isEmpty() && inorder[in] == stack.peek().val) {
                --in;
                root = stack.poll();
            }
            if (post > 0) {
                root.left = new TreeNode(postorder[--post]);
                stack.push(root.left);
                root = root.left;
            }
        }
        return first;
    }
    public static void main(String[] args) {

        TreeNode root = buildTree(new int[]{9,3,15,20,7} , new int[]{9,15,7,20,3});
        System.out.println(root);
    }
}
