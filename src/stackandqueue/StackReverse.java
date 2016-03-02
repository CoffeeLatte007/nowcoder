package stackandqueue;

import java.util.Stack;

/**
 *

 实现一个栈的逆序，但是只能用递归函数和这个栈本身的pop操作来实现，而不能自己申请另外的数据结构。

 给定一个整数数组A即为给定的栈，同时给定它的大小n，请返回逆序后的栈。
 测试样例：

 [4,3,2,1],4

 返回：[1,2,3,4]


 * Created by lizhaoz on 2016/2/3.
 */

public class StackReverse {
    Stack<Integer> stack=new Stack<Integer>();
    public int[] reverseStack(int[] A, int n) {
        for (int i = A.length-1; i >=0 ; i--) {
            stack.push(A[i]);
        }
        reverse(stack);
        for (int i = 0; i <A.length ; i++) {
            A[i]=stack.pop();
        }
        return A;
    }

    private void reverse(Stack<Integer> stack) {
        if (stack.size()<=0)
            return;
        int last=get();
        reverse(stack);
        stack.push(last);
    }

    private int get(){
        int num = stack.pop();
        if (stack.empty())
        {
            return num;
        }
        int ret = get();
        stack.push(num);
        return ret;
    }
}
