package binarySearch;

/**
 *
 从二叉树的节点A出发，可以向上或者向下走，但沿途的节点只能经过一次，当到达节点B时，
 路径上的节点数叫作A到B的距离。对于给定的一棵二叉树，求整棵树上节点间的最大距离。
 给定一个二叉树的头结点root，请返回最大距离。保证点数大于等于2小于等于500.
 * Created by lizhaoz on 2016/1/18.
 */

public class LongestDistance {
    public int findLongest(TreeNode root) {
        int[] mx=new int[550];
        return get(root,mx);
    }

    private int get(TreeNode root, int[] mx) {

        int lmx=0,rmx=0,ret=0;
        if (root.left!=null){
            ret=get(root.left,mx);lmx=mx[root.left.val];
        }
        if (root.right!=null){
            ret=get(root.right,mx);rmx=mx[root.right.val];
        }
        mx[root.val]=Math.max(lmx,rmx)+1;
        if (lmx+rmx+1>ret)ret=lmx+rmx+1;
        return ret;
    }
}
