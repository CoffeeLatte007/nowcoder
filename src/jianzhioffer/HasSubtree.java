package jianzhioffer;

/**
 * 输入两颗二叉树A，B，判断B是不是A的子结构
 * Created by lizhaoz on 2016/3/3.
 */

public class HasSubtree {

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
       boolean result=false;
      if (root1!=null&&root2!=null){
          if (root1.val==root2.val)
              result=deSubtree(root1,root2);
          if (!result)
              result=HasSubtree(root1.left, root2);
          if (!result)
              result=HasSubtree(root1.right,root2);
      }
        return result;
    }
    private boolean deSubtree(TreeNode root1,TreeNode root2){
       if (root2==null){
           return true;//右边子节点为空时返回Null
       }
        if (root1==null){
            return false;
        }
        if (root1.val!=root2.val){
            return false;
        }
        return deSubtree(root1.left,root2.left)&&deSubtree(root1.right,root2.right);
    }
}
