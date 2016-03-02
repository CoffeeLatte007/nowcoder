package jianzhioffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by lizhaoz on 2016/2/29.
 */


      class ListNode {
         int val;
         ListNode next = null;

         ListNode(int val) {
             this.val = val;
         }
 }

public class third {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<ListNode> stack=new Stack<ListNode>();
        ArrayList<Integer> arrayList=new ArrayList<Integer>();;
        while (listNode!=null){

            stack.push(listNode);
            listNode=listNode.next;
        }
        while (stack.empty()){
            arrayList.add(stack.pop().val);
        }
        return arrayList;
    }
}
