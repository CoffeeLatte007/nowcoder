package jianzhioffer;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 * 具体策略 一条链表先走n步
 * Created by lizhaoz on 2016/3/10.
 */

public class FindFirstCommonNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1==null||pHead2==null){
            return null;
        }
        ListNode p1=pHead1,p2=pHead2;
        while (p1!=null&&p2!=null){
            p1=p1.next;
            p2=p2.next;
        }
        int morestep=0;
        int moretype=0;
        while (p1!=null){
            p1=p1.next;
            morestep++;
        }
        while (p2!=null){
            p2=p2.next;
            morestep++;
            moretype=1;
        }
        ListNode node;
        if (moretype==0)
        node=find(pHead1,pHead2,morestep);
        else
            node=find(pHead2,pHead1,morestep);
        return node;
    }

    private ListNode find(ListNode pHead1, ListNode pHead2,int morestep) {
        for (int i = 0; i < morestep; i++) {
            pHead1=pHead1.next;
        }
        while (pHead1!=pHead2){
            pHead1=pHead1.next;
            pHead2=pHead2.next;
        }
        return pHead1;
    }
}
