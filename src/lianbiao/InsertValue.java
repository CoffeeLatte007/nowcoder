package lianbiao;
import java.util.*;

/**
 * 有一个整数val，如何在节点值有序的环形链表中插入一个节点值为val的节点，并且保证这个环形单链表依然有序。
 给定链表的信息，及元素的值A及对应的nxt指向的元素编号同时给定val，请构造出这个环形链表，并插入该值。
 测试样例：
 [1,3,4,5,7],[1,2,3,4,0],2
 返回：{1,2,3,4,5,7}
 */

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class InsertValue {
    public ListNode insert(int[] A, int[] nxt, int val) {
        ListNode node=new ListNode(val);
        if(A==null||A.length<=0){
            node.next=node;
            return node;
        }
        ListNode head=unionList(A,nxt);
        head=getList(A,nxt,head,val);
        return head;
    }

    private ListNode getList(int[] a, int[] nxt, ListNode head, int val) {
        int headval=head.val;
        int pre=0,cur=0;
        ListNode head1=head;
        for (int i = 1; i <=a.length-1 ; i++) {
            pre=head1.val;
            cur=head1.next.val;
            if (val>=pre&&val<=cur){
                ListNode node=new ListNode(val);
                node.next=head1.next;
                head1.next=node;
                return head;
            }
            head1=head1.next;
        }
        if (head1.val<val){
            ListNode node=new ListNode(val);
            node.next=head1.next;
            head1.next=node;
        }
        if (head.val>val){
            ListNode node=new ListNode(val);
            node.next=head;
            head.next=node;
        }
        return head;
    }

    private ListNode unionList(int[] a, int[] nxt) {
        ListNode head=new ListNode(a[0]);
        ListNode prenode=head;
        for (int i = 1; i <a.length ; i++) {
            ListNode nxtnode=new ListNode(a[i]);
            prenode.next=nxtnode;
            prenode=nxtnode;
        }
        prenode.next=head;
        return head;
    }
}