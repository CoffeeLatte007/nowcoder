package stackandqueue;

import java.util.ArrayList;

import java.util.Stack;

/**
 * 请编写一个程序，按升序对栈进行排序（即最大元素位于栈顶），
 * 要求最多只能使用一个额外的栈存放临时数据，但不得将元素复制到别的数据结构中。

 给定一个int[] numbers(C++中为vector<int>)，其中第一个元素为栈顶，请返回排序后的栈。
 请注意这是一个栈，意味着排序过程中你只能访问到第一个元素。
 测试样例：

 [1,2,3,4,5]

 返回：[5,4,3,2,1]
 * Created by lizhaoz on 2016/2/3.
 */

public class TwoStacks {
    public static ArrayList<Integer> twoStacksSort(int[] numbers) {
        Stack<Integer> stack=new Stack<Integer>();
        Stack<Integer> helpstack=new Stack<Integer>();
        for (int i = 0; i <=numbers.length-1; i++) {
            stack.push(numbers[i]);
        }
        while(!stack.empty()){
            int pre=stack.pop();//得到本站的栈顶
            while (!helpstack.empty()){
                int prehelp=helpstack.peek();
                if (prehelp<pre){
                    stack.push(helpstack.pop());
                }
                else break;
            }
            helpstack.push(pre);
        }
        ArrayList<Integer> list=new ArrayList<Integer>(helpstack);
        System.out.println(list.size());
        return list;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{2,2,3,5,5};
        twoStacksSort(nums);
    }
}
