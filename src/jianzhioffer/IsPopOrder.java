package jianzhioffer;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，
 * 请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * Created by lizhaoz on 2016/3/5.
 */

public class IsPopOrder {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA.length<=0||popA.length<=0||pushA==null||popA==null){
            return false;
        }
        Stack<Integer> helpstack=new Stack<Integer>();
        int j=0;
        int i=0;
        for (; i <popA.length ; i++) {
            while (helpstack.empty()||helpstack.peek()!=popA[i]){
                if (j==pushA.length)
                    break;
                helpstack.push(pushA[j++]);
            }
            if (helpstack.peek()!=popA[i])
                break;
            helpstack.pop();
        }
        if (helpstack.empty()&&i==popA.length){
            return true;
        }else return false;
    }
}
