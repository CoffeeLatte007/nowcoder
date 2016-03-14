package jianzhioffer;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
 * 重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * Created by lizhaoz on 2016/3/14.
 */

public class deleteDuplication {
    public ListNode deleteDuplication(ListNode pHead)
    {
        if (pHead==null){
            return null;
        }
        ListNode preNode=null;
        ListNode cuNode=pHead;
        while (cuNode!=null){
            ListNode nextNode=cuNode.next;
            boolean needDelete=false;
            if (nextNode !=null&&nextNode.val==cuNode.val)
                needDelete=true;
            if (!needDelete){
                preNode=cuNode;
                cuNode=cuNode.next;
            }
            else {
                int value=cuNode.val;
                ListNode delNode=cuNode;
                while (delNode!=null&&delNode.val==value){
                    nextNode=delNode.next;
                    delNode=nextNode;
                }
                if (preNode==null)
                    pHead=nextNode;
                else preNode.next=nextNode;
                cuNode=nextNode;
            }
        }
        return pHead;
    }
}
