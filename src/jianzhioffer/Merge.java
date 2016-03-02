package jianzhioffer;

/**
 * Created by lizhaoz on 2016/3/2.
 */

public class Merge {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1==null){
            return list2;
        }
        if (list2==null){
            return list1;
        }
        ListNode head=null;

        if (list1.val<list2.val){
            head=list1;
            list1=list1.next;
        }
        else {
            head=list2;
            list2=list2.next;
        }
        ListNode pNode=head;
        while (list1!=null&&list2!=null){
            if (list1.val<list2.val){
                pNode.next=list1;
                list1=list1.next;
                pNode=pNode.next;
            }
            else {
                pNode.next=list2;
                list2=list2.next;
                pNode=pNode.next;
            }
        }
        if (list1!=null){
           pNode.next=list1;
        }
        if (list2!=null){
            pNode.next=list2;
        }
        return head;
    }

    public static void main(String[] args) {
        System.out.println((~1));
    }
}
