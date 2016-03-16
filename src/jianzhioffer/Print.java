package jianzhioffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 * Created by lizhaoz on 2016/3/15.
 */

public class Print {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> arrayLists=new ArrayList<ArrayList<Integer>>();
        if (pRoot==null){
            return arrayLists;
        }
        Stack<TreeNode> stack1=new Stack<TreeNode>();
        Stack<TreeNode> stack2=new Stack<TreeNode>();
        stack1.push(pRoot);
        while (!stack1.empty()||!stack2.empty()){
            if (!stack1.empty()){
                ArrayList<Integer> arrayList=new ArrayList<Integer>();
                while (!stack1.empty()){
                    if (stack1.peek().left!=null)
                    {
                        stack2.push(stack1.peek().left);
                    }
                    if (stack1.peek().right!=null)
                    {
                        stack2.push(stack1.peek().right);
                    }
                    arrayList.add(stack1.pop().val);
                }
                arrayLists.add(arrayList);
            }
             if (!stack2.empty()){
                ArrayList<Integer> arrayList=new ArrayList<Integer>();
                while (!stack2.empty()){
                    ArrayList<Integer> arrayListl=new ArrayList<Integer>();
                    while (!stack2.empty()){
                        if (stack2.peek().right!=null)
                        {
                            stack1.push(stack2.peek().right);
                        }
                        if (stack2.peek().left!=null)
                        {
                            stack1.push(stack2.peek().left);
                        }
                        arrayList.add(stack2.pop().val);
                    }
                    arrayLists.add(arrayList);
            }
        }
    }
        return arrayLists;

}

}
