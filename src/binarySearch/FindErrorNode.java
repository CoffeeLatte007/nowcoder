package binarySearch;

import java.util.ArrayList;
import java.util.List;

/**
 *
 一棵二叉树原本是搜索二叉树，但是其中有两个节点调换了位置，使得这棵二叉树不再是搜索二叉树，请找到这两个错误节点
 并返回他们的值。保证二叉树中结点的值各不相同。

 给定一棵树的根结点，请返回两个调换了位置的值，其中小的值在前。

 * Created by lizhaoz on 2016/1/18.
 */

public class FindErrorNode {

    /*
     *中序遍历得到值 通过连续大小来发现
     */
     public int[] findError(TreeNode root) {
         int[] num=new int[2];
         List<Integer> list=new ArrayList<Integer>();
         mid(root,list);
         int A=-1,B=-1;
         for (int i = 0; i <list.size()-1; i++) {
             if (list.get(i)>list.get(i+1)){
                 if (A!=-1) B=i+1;
                 else {
                     A = i;
                     B = i+1;
                 }
             }
         }
         num[0]=list.get(B);
         num[1]=list.get(A);
         return num;
    }

    private void mid(TreeNode root, List<Integer> list) {
        if (root==null)
            return;
        mid(root.left,list);
        list.add(root.val);
        mid(root.right,list);
    }
}
