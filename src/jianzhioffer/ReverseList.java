package jianzhioffer;

/**
 * Created by lizhaoz on 2016/3/2.
 */

public class ReverseList {
    public ListNode ReverseList(ListNode head) {
        ListNode reverhead=null;
        ListNode pre=head;
        ListNode prn=null;
        while (pre!=null){
            ListNode nextnode=pre.next;
            if (nextnode==null){
                reverhead=pre;
            }
            pre.next=prn;
            prn=pre;
            pre=nextnode;
        }
        return reverhead;
    }
}
