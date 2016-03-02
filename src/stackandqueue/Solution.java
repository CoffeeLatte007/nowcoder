package stackandqueue;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 * Created by lizhaoz on 2016/2/3.
 */

public class Solution {
    private Stack<Integer> stack=new Stack<Integer>();
    private Stack<Integer> minstack=new Stack<Integer>();
    public void push(int node) {
        stack.push(node);
        if (minstack.size()>0&&node<minstack.peek()){
            minstack.push(node);
        }
        else if (minstack.size()==0){
            minstack.push(node);
        }
        else {
            minstack.push(minstack.peek());
        }
    }

    public void pop() {
        stack.pop();
        minstack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minstack.peek();
    }
}
