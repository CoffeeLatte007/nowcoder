package jianzhioffer;

/**
 * Created by lizhaoz on 2016/3/15.
 */

public class KthNode {
    int k;
    TreeNode KthNode(TreeNode pRoot, int k) {
        this.k = k;
        return helper(pRoot);
    }

    private TreeNode helper(TreeNode pRoot) {
        TreeNode temp = null;
        if (pRoot != null) {
            if ((temp = helper(pRoot.left)) != null) return temp;
            if (--k == 0) return pRoot;
            if ((temp = helper(pRoot.right)) != null) return temp;
        }
        return null;
    }
}
