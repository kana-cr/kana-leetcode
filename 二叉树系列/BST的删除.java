package 二叉树系列;

//给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。
// 返回二叉搜索树（有可能被更新）的根节点的引用。
public class BST的删除 {

    public  TreeNode deleteNode(TreeNode root, int key) {
        TreeNode node = root;
        while (node != null) {
            int cmp = key - node.val;
            if (cmp == 0) {
                break;
            } else if (cmp < 0) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        //这里得到的node是key所对应的node,或者null 为没有找到的情况
        if (node != null) {
            if (node.left != null && node.right != null) {
                TreeNode backTreeNode = findBackTreeNode(node, root);
                TreeNode parentTreeNode = findParentTreeNode(root, backTreeNode.val);
                if (parentTreeNode.left == backTreeNode) {
                    if (backTreeNode.left!=null) {
                        parentTreeNode.left=backTreeNode.left;
                    }else {
                        parentTreeNode.left=backTreeNode.right;
                    }
                } else  if (parentTreeNode.right == backTreeNode) {
                    if (backTreeNode.right!=null) {
                        parentTreeNode.right=backTreeNode.right;
                    }else {
                        parentTreeNode.right=backTreeNode.left;
                    }
                }
                int val = backTreeNode.val;
                node.val = val;

                return root;
            }

            TreeNode replacement = node.left != null ? node.left : node.right;
            TreeNode nodeParent = findParentTreeNode(root, node.val);
            if (replacement != null) { // node是度为1的节点
                // 更改parent
                TreeNode parentTreeNode = findParentTreeNode(root, replacement.val);
                parentTreeNode = nodeParent;
                // 更改parent的left、right的指向
                if (nodeParent == null) { // node是度为1的节点并且是根节点
                    root = replacement;
                } else if (node == nodeParent.left) {
                    nodeParent.left = replacement;
                } else { // node == node.parent.right
                    nodeParent.right = replacement;
                }
            } else if (nodeParent == null) { // node是叶子节点并且是根节点
                root = null;
            } else { // node是叶子节点，但不是根节点
                if (node == nodeParent.left) {

                    nodeParent.left = null;
                } else { // node == node.parent.right

                    nodeParent.right = null;
                }
            }
        } else {
            return root;
        }
        return root;
    }

    // 找出后继节点
    private  TreeNode findBackTreeNode(TreeNode node, TreeNode root) {
        if (node.right != null) {
            //存在右节点
            TreeNode next = node.right;

            while (next.left != null) {
                next = next.left;
            }
            return next;
        }

        //到了这里是没有右节点的，所以我们需要进行另外的一种判断
        return findFatherTreeNode(root, node.val);
        //到这里的node

    }

    private  TreeNode findFatherTreeNode(TreeNode node, int key) {
        TreeNode leftParent = null;
        while (node != null) {
            int cmp = key - node.val;
            if (cmp == 0) {
                return leftParent;
            } else if (cmp < 0) {
                if (node.left != null) {
                    leftParent = node;
                }
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return leftParent;
    }

    private  TreeNode findParentTreeNode(TreeNode node, int key) {

        TreeNode parent = null;
        while (node != null) {
            int cmp = key - node.val;
            if (cmp == 0) {

                return parent;
            } else if (cmp < 0) {
                if (node.left != null) {
                    parent = node;
                }
                node = node.left;
            } else {
                if (node.right != null) {
                    parent = node;
                }
                node = node.right;
            }
        }

        return parent;
    }


    public TreeNode deleteNode_my(TreeNode root, int key) {
        if (root==null)
            return root;
        TreeNode realRoot=root;
        boolean ifExist=false;
        int dir=0;// 1为右 2为左 0即代表原来的根节点被删除
        TreeNode parent=root;//当前找到的节点的父节点
        while (root!=null){
            if (key==root.val) {
                ifExist=true;
              break;
            } else if (key>root.val) {
                parent=root;
                root = root.right;
                dir=1;
            } else {
                parent=root;
                root = root.left;
                dir=2;
            }
        }
       /* //root就是当前找到的节点
        if (!ifExist)
            return realRoot;

            if (dir==1){
                //父节点的右节点
                if (root.left==null){
                    parent.right=root.right;
                }else if (root.right==null){
                    parent.right=root.left;
                }else {
                    dir=3;
                }
            }else if (dir==2){
                //父节点的左节点
                if (root.left==null){
                    parent.left=root.right;
                }else if (root.right==null){
                    parent.left=root.left;
                }else {
                    dir=4;
                }
            }
            if (dir==3||dir==4){
                //要删除的结点左右子树都存在的情况(包括节点是根节点的情况)
                    root=root.right;
                    TreeNode successorParent=new TreeNode(0);
                    while (root.left!=null){
                        if (root.left.left==null) {
                            successorParent.val = root.val;
                            successorParent.left=root.left;
                            successorParent.right=root.right;
                            //找到后继节点的父节点
                        }
                        root=root.left;
                        //此时root就是找到的后继节点
                    }
                    //父节点的右节点
                if (dir==3) {
                    //给后继节点的子树找到位置
                    successorParent.left=root.right;
                    //接班右子树
                    root.right=parent.right.right;
                    //接班左子树
                    root.left=parent.right.left;
                    parent.right = root;

                }


        }*/
     return realRoot;
    }

    //《算法（第4版）》- 3.2 二叉查找树
    private TreeNode deleteNode_Recursion(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.val) {
            // 待删除节点在左子树中
            root.left = deleteNode_Recursion(root.left, key);
            return root;
        } else if (key > root.val) {
            // 待删除节点在右子树中
            root.right = deleteNode_Recursion(root.right, key);
            return root;
        } else {
            // key == root.val，root 为待删除节点
            if (root.left == null) {
                // 返回右子树作为新的根
                return root.right;
            } else if (root.right == null) {
                // 返回左子树作为新的根
                return root.left;
            } else {
                // 左右子树都存在，返回后继节点（右子树最左叶子）作为新的根
                //也可以使用前驱节点
                TreeNode successor = min(root.right);
                //接班右子树
                successor.right = deleteMin(root.right);
                //接班左子树
                successor.left = root.left;
                return successor;
            }
        }
    }
    //找到最左叶子
    private TreeNode min(TreeNode node) {
        if (node.left == null) {
            return node;
        }
        return min(node.left);
    }
    //找到最左叶子的右树，放到对应的位置
    private TreeNode deleteMin(TreeNode node) {
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        return node;
    }
}
