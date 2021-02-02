package 剑指offer;



public class 树的子结构 {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
      if(B == null) return false;
      return checkisSub(A, B,false);
    }

    private boolean checkisSub(TreeNode A ,TreeNode B,boolean sub){
        if(B == null) return true;
        if(A == null) return false;
        boolean isSub = false;
        if(A.val == B.val){
           isSub = checkisSub(A.left, B.left,true) && checkisSub(A.right, B.right,true);
        }else if(sub){
            return false;
        }
        if(isSub) return true;
            return checkisSub(A.left, B,false) || checkisSub(A.right, B,false);
        
    }

}