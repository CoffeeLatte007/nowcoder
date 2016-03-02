package binarySearch;

import java.util.Stack;

/**
 *请用非递归方式实现二叉树的先序、中序和后序的遍历打印。
 给定一个二叉树的根结点root，请依次返回二叉树的先序，中序和后续遍历(二维数组的形式)。
 * Created by lizhaoz on 2016/1/18.
 */

public class TreeToSequence {

    public static void main(String[] args) {
        TreeNode node4=new TreeNode(4,null,null);
        TreeNode node5=new TreeNode(5,null,null);
        TreeNode node6=new TreeNode(6,null,null);
        TreeNode node7=new TreeNode(7,null,null);
        TreeNode node2=new TreeNode(2,node4,node5);
        TreeNode node3=new TreeNode(3,node6,node7);
        TreeNode root=new TreeNode(1,node2,node3);
        pre(root);//前序
        mid(root);//中序
        aft(root);//后序，两个栈实现
    }
    /*
          非递归实现后序策略
          1.新建两个栈stack1和stack2,把root结点压入栈stack1
          2.开始循环while (stack1.size()>0)
          3.循环内容：
             每次弹出栈顶，压入stack2
             判断左孩子是否为空，不为空压入左孩子
             判断右孩子是否为空，不为空压入右孩子
          4.打印stack2
         */
    private static void aft(TreeNode root) {
        Stack<TreeNode> stack1=new Stack<TreeNode>();
        Stack<TreeNode> stack2=new Stack<TreeNode>();
        System.out.print("后序遍历为:");
        stack1.push(root);
        TreeNode node;
        while (stack1.size()>0){
            node=stack1.pop();
            stack2.push(node);
            if (node.left!=null)
                stack1.push(node.left);
            if (node.right!=null)
                stack1.push(node.right);
        }
        while (stack2.size()>0){
            System.out.print(stack2.pop().val+" ");
        }
    }
    /*
     非递归实现中序策略
     1.新建一个栈，和一个cur变量用来指向当前变量
     2.循环把左边的所有加入进栈，cur随之变动
     3.当cur为空时弹出，把右边的赋值给cur
    */
    private static void mid(TreeNode root) {
        System.out.print("中序遍历为:");
        Stack<TreeNode> stack=new Stack<TreeNode>();
        TreeNode cur=root;
        TreeNode node;
        while (cur!=null||stack.size()>0) {
           if (cur==null){
               node=stack.pop();
               System.out.print(node.val+" ");
               cur=node.right;
               continue;
           }
            stack.push(cur);
            cur=cur.left;
        }
    }

    /*
      非递归实现前序策略
      1.新建一个栈，把root结点压入栈
      2.开始循环while (stack.size()>0)
      3.循环内容：
         每次弹出栈顶，打印
         判断右孩子是否为空，不为空压入右孩子
         判断左孩子是否为空，不为空压入左孩子
     */
    private static void pre(TreeNode root) {
        System.out.print("前序遍历为:");
        Stack<TreeNode> stack=new Stack<TreeNode>();
        stack.push(root);
        while (stack.size()>0){
            TreeNode node=stack.pop();
        System.out.print(node.val + " ");
        if (node.right!=null)
            stack.push(node.right);
        if (node.left!=null)
            stack.push(node.left);
    }
    }
}
