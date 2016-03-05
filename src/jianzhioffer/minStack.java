package jianzhioffer;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 * Created by lizhaoz on 2016/3/5.
 */

public class minStack {
    Stack<Integer> stack=new Stack<Integer>();
    Stack<Integer> helpstack=new Stack<Integer>();
    public void push(int node) {
        stack.push(node);
        if (!helpstack.empty()&&helpstack.peek()<node){
            helpstack.push(helpstack.peek());
        }
        else helpstack.push(node);

    }

    public void pop() {
        if (stack.empty())
            return;
        stack.pop();
        helpstack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return helpstack.peek();
    }
}
