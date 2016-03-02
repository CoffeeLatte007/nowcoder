package binarySearch;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 有一棵二叉树，请设计一个算法，按照层次打印这棵二叉树。
 给定二叉树的根结点root，请返回打印结果，结果按照每一层一个数组进行储存，所有数组的顺序按照层数从上往下，且每一层的数组内元素按照从左往右排列。保证结点数小于等于500。
 * Created by lizhaoz on 2016/1/18.
 */

public class TreePrinter {
    public static void printTree(TreeNode root) {

        TreeNode last=root;//申请last(记录当前打印行的最右结点)
        TreeNode nlast=root;//申请nlast(记录下一行的最右结点)
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();//申请队列
        queue.add(root);//初始头结点添加到队列中
        TreeNode node=null;//缓存弹出结点
        while (!queue.isEmpty()){
            node=queue.removeFirst();//弹出结点
            System.out.print(node.val + " ");
            if (node.left!=null){//弹出结点后将结点的左右孩子依次加入队列中，更新nlast
                queue.add(node.left);
                nlast=node.left;
            }
            if (node.right!=null){
                queue.add(node.right);
                nlast=node.right;
            }
            if (node==last)//如果弹出的结点恰好是当前行的最右结点，并且last不等于nlast的话，说明当前行打印完了，并且下一行的最右结点也确定了，把last指向nLast
            {
                last=nlast;
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        TreeNode node4=new TreeNode(4,null,null);
        TreeNode node5=new TreeNode(5,null,null);
        TreeNode node6=new TreeNode(6,null,null);
        TreeNode node7=new TreeNode(7,null,null);
        TreeNode node2=new TreeNode(2,node4,node5);
        TreeNode node3=new TreeNode(3,node6,node7);
        TreeNode root=new TreeNode(1,node2,node3);
        printTree(root);
    }
}
