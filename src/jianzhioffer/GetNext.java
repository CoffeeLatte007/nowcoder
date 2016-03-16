package jianzhioffer;

/**
 * Created by lizhaoz on 2016/3/15.
 */
 class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
public class GetNext {
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode==null){
            return null;
        }
        if (pNode.right!=null){
            TreeLinkNode tnod=pNode.right;
            while (tnod.left!=null){
                tnod=tnod.left;
            }
            return tnod;
        }
        TreeLinkNode preNode=pNode.next;
        if (preNode==null){
            return null;
        }
        while (preNode.left!=pNode){
            pNode=preNode;
            preNode=preNode.next;
            if (preNode==null){
                return null;
            }
        }
        return preNode;
    }
}
