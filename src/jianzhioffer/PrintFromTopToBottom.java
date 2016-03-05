package jianzhioffer;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * Created by lizhaoz on 2016/3/5.
 */

public class PrintFromTopToBottom {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {

        ArrayList<Integer> arrayList=new ArrayList<Integer>();
        if (root==null)
            return arrayList;
        LinkedBlockingQueue<TreeNode> queue=new LinkedBlockingQueue<TreeNode>() ;
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode printnode=queue.poll();
            arrayList.add(printnode.val);
            if (printnode.left!=null)
                queue.add(printnode.left);
            if (printnode.right!=null)
                queue.add(printnode.right);
        }
        return arrayList;
    }

}
