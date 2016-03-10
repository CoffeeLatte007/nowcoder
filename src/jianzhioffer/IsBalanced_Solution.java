package jianzhioffer;

/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * Created by lizhaoz on 2016/3/10.
 */

public class IsBalanced_Solution {
//    public boolean IsBalanced_Solution(TreeNode root) {
//        if (root == null)
//            return true;
//
//        if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1)
//            return false;
//        return IsBalanced_Solution(root.left)&&IsBalanced_Solution(root.right);
//    }
//    public int getHeight(TreeNode root) {
//        if (root == null)
//            return 0;
//        return max(getHeight(root.left), getHeight(root.right)) + 1;
//    }
//    private int max(int a, int b) {
//        return (a > b) ? a : b;
//    }
    public boolean IsBalanced_Solution(TreeNode root){
        int []a=new int[1];
        a[0]=0;
        return IsBalanced(root,a);
    }

    private boolean IsBalanced(TreeNode root, int[] a) {
        if (root==null){
            a[0]=0;
            return true;
        }
        int[] left=new int[1];int[] right=new int[1];
        if (IsBalanced(root.left,left)&&IsBalanced(root.right,right)){
            if (Math.abs(left[0]-right[0])<=1){
                a[0]=Math.max(left[0],right[0])+1;
                return true;
            }
        }
        return false;
    }
}
