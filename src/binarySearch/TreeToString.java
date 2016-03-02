package binarySearch;

/**
 * 首先我们介绍二叉树先序序列化的方式，假设序列化的结果字符串为str，初始时str等于空字符串。先序遍历二叉树，
 * 如果遇到空节点，就在str的末尾加上“#!”，“#”表示这个节点为空，节点值不存在，当然你也可以用其他的特殊字符，
 * “!”表示一个值的结束。如果遇到不为空的节点，假设节点值为3，就在str的末尾加上“3!”。现在请你实现树的先序序列化。
 给定树的根结点root，请返回二叉树序列化后的字符串。
 * Created by lizhaoz on 2016/1/18.
 */

public class TreeToString {
    public static String toString(TreeNode root) {
        StringBuilder stringBuilder=new StringBuilder();
        pretoString(root,stringBuilder);
        return stringBuilder.toString();
    }

    private static void pretoString(TreeNode root, StringBuilder stringBuilder) {
        if (root==null)
        {
            stringBuilder.append("#!");
        return;
        }
        else
            stringBuilder.append(root.val+"!");
        pretoString(root.left,stringBuilder);
        pretoString(root.right,stringBuilder);
    }

    public static void main(String[] args) {
        TreeNode node4=new TreeNode(4,null,null);
        TreeNode node5=new TreeNode(5,null,null);
        TreeNode node6=new TreeNode(6,null,null);
        TreeNode node7=new TreeNode(7,null,null);
        TreeNode node2=new TreeNode(2,node4,node5);
        TreeNode node3=new TreeNode(3,node6,node7);
        TreeNode root=new TreeNode(1,node2,node3);
        System.out.println(toString(root));
    }
}
