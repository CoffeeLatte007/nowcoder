package binarySearch;

/**
 * Created by lizhaoz on 2016/1/18.
 */

public class CheckBlance {
    public static boolean check(TreeNode root){
        return chk(root)>=0;
    }

    private static int chk(TreeNode root) {
        if (root==null) return 0;
        int l=chk(root.left),r=chk(root.right);//左右两边深度
        if (l<0||r<0) return -1;
        if ((Math.abs(r-l)>1))return -1;//当左右两边深度差超过1时 返回-1
        return r>l?r+1:l+1;//当到达这一句话的时候证明该子树左右肯定是平衡二叉树，然后返回最大的深度
        //最后只要返回的是任意非-1值 均为平衡子树
    }

    public static void main(String[] args) {
        TreeNode node4=new TreeNode(4,null,null);
        TreeNode node5=new TreeNode(5,null,null);
        TreeNode node6=new TreeNode(6,null,null);
        TreeNode node7=new TreeNode(7,null,null);
        TreeNode node2=new TreeNode(2,node4,node5);
        TreeNode node3=new TreeNode(3,node6,node7);
        TreeNode root=new TreeNode(1,node2,node3);
        System.out.println(check(root));
    }
}
