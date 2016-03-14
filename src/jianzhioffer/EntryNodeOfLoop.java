package jianzhioffer;

/**
 * 一个链表中包含环，请找出该链表的环的入口结点。
 * Created by lizhaoz on 2016/3/14.
 */

public class EntryNodeOfLoop {
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if (pHead==null||pHead.next==null){
            return null;
        }
        int count=findcount(pHead);
        ListNode node=findnode(pHead,count);
        return node;
    }

    private ListNode findnode(ListNode pHead, int count) {
        ListNode quick=pHead;
        for (int i = 0; i < count; i++) {
            quick=quick.next;
        }
        ListNode slow=pHead;
        while (quick!=slow){
            quick=quick.next;
            slow=slow.next;
        }
        return quick;
    }

    private int findcount(ListNode pHead) {
        ListNode slow=pHead;
        ListNode qu=pHead.next;
        while (qu!=slow){
            qu=qu.next.next;
            slow=slow.next;
        }
        int count=1;
        while(qu.next!=slow){
            qu=qu.next;
            count++;
        }
        return count;
    }
}
