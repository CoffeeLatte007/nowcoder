package lianbiao;

import java.util.Stack;

/**
 * 请编写一个函数，检查链表是否为回文。
 给定一个链表ListNode* pHead，请返回一个bool，代表链表是否为回文。
 测试样例：
 {1,2,3,2,1}
 返回：true
 {1,2,3,2,3}
 返回：false
 * Created by lizhaoz on 2016/2/9.
 */

public class Palindrome {
    public boolean isPalindrome(ListNode pHead) {
        ListNode cur=pHead;
        Stack<Integer> stack=new Stack<Integer>();
        while (cur!=null){
            stack.push(cur.val);
            cur=cur.next;
        }
        boolean res=true;
        while (!stack.empty()){
            if (stack.pop()!=pHead.val)return false;
            pHead=pHead.next;
        }
        return res;
    }
}
