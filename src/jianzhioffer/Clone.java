package jianzhioffer;

/**
 * Created by lizhaoz on 2016/3/6.
 */
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
public class Clone {
    public RandomListNode Clone(RandomListNode pHead)
    {
        if (pHead==null)
            return null;
        step1Clon(pHead);
        step12Clon(pHead);
        return step13Clon(pHead);

    }

    private RandomListNode step13Clon(RandomListNode pHead1) {
        RandomListNode pNode=pHead1;
        RandomListNode pClonedHead=null;
        RandomListNode pClonedNode=null;
        if (pNode!=null){
            pClonedHead=pClonedNode=pNode.next;
            pNode.next=pClonedHead.next;
            pNode=pNode.next;
        }
        while (pNode!=null){
            pClonedHead.next=pNode.next;
            pClonedNode=pClonedHead.next;
            pNode.next=pClonedNode.next;
            pNode=pNode.next;
        }
        return pClonedHead;
    }

    private void step12Clon(RandomListNode pHead1) {
        RandomListNode pHead=pHead1;
        while (pHead!=null){
            RandomListNode pclone=pHead.next;
            if (pHead.random!=null){
                pclone.random=pHead.random.next;
                pHead=pclone.next;
            }
        }
    }

    private void step1Clon(RandomListNode pHead1) {
        RandomListNode pHead=pHead1;
        while (pHead!=null){
            RandomListNode randomListNode=new RandomListNode(pHead.label);
            randomListNode.next=pHead.next;
            randomListNode.random=null;
            pHead.next=randomListNode;
            pHead=randomListNode.next;
        }
    }
}
