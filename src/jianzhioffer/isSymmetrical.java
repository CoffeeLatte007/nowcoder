package jianzhioffer;

/**
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * Created by lizhaoz on 2016/3/15.
 */

public class isSymmetrical {
    boolean isSymmetrical(TreeNode pRoot)
    {
        return isSymmetrical(pRoot, pRoot);
    }

    private boolean isSymmetrical(TreeNode pRoot, TreeNode pRoot1) {
        if (pRoot==null&&pRoot1==null){
            return true;
        }
        if (pRoot==null||pRoot1==null){
            return false;
        }
        if (pRoot.val!=pRoot1.val){
            return false;
        }
        return isSymmetrical(pRoot.left,pRoot1.right)&&isSymmetrical(pRoot.right,pRoot1.left);
    }
}
