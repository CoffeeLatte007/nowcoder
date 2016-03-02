package jianzhioffer;

/**
 * Created by lizhaoz on 2016/3/2.
 */

public class FindKthToTail {
    public ListNode findKthToTail(ListNode head,int k) {
        if (k==0||head==null){
            return null;
        }
        ListNode first=head;
        for (int i = 0; i < k-1; i++) {
            if (first.next==null)return null;
            else first=first.next;
        }
        ListNode two=head;
        while (first.next!=null){
            first=first.next;
            two=two.next;
        }
        return two;
    }


}
