package jianzhioffer;

import java.util.Stack;

/**
 * Created by lizhaoz on 2016/2/29.
 */

public class fifth {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.empty()&&!stack1.empty()){
            while (!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
