package binarySearch;

/**
 * Created by lizhaoz on 2016/1/14.
 */
 class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
    public TreeNode(int val,TreeNode left,TreeNode right) {
        this.val = val;this.left=left;this.right=right;
    }
}
public class CountNodes {
    public int count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return bs(root, 1, mostLeftLevel(root, 1));
    }
    int bs(TreeNode node,int l,int h){
        if (l==h) return 1;//判断是否是一层，计算就只有一个结点
        //右子节点的最左是否和高度相等，计算左边的所有，递归右边
        if (mostLeftLevel(node.right,l+1)==h){
            return (1<<(h-1)) + bs(node.right,1,mostLeftLevel(node.right,1));
        }
        //计算右边的所有，递归左边
        else return (1<<(h-l-1))+bs(node.left,1,mostLeftLevel(node.left,1));
    }
    /*
     返回最左边的层数
     */
    int mostLeftLevel(TreeNode node,int level){
        while (node!=null){
            level++;
            node=node.left;
        }
        return level-1;
    }
}
