package jianzhioffer;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * Created by lizhaoz on 2016/3/6.
 */

public class Convert {

    TreeNode lastmaxnode=null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        convertnode(pRootOfTree);
        TreeNode pHead=lastmaxnode;
        while (pHead!=null&&pHead.left!=null)
            pHead=pHead.left;
        return pHead;
    }

    private void convertnode(TreeNode pRootOfTree) {
        if (pRootOfTree==null)
            return;
        TreeNode pCurrent=pRootOfTree;
        convertnode(pRootOfTree.left);
        pCurrent.left=lastmaxnode;
        if (lastmaxnode!=null)
            lastmaxnode.right=pCurrent;
        lastmaxnode=pCurrent;
        convertnode(pRootOfTree.right);

    }
}
