package stackandqueue;

import java.util.Stack;

/**
 *

 对于一个没有重复元素的整数数组，请用其中元素构造一棵MaxTree，MaxTree定义为一棵二叉树，
 其中的节点与数组元素一一对应，同时对于MaxTree的每棵子树，它的根的元素值为子树的最大值。
 现有一建树方法，对于数组中的每个元素，其在树中的父亲为数组中它左边比它大的第一个数和右边比它大的第一
 个数中更小的一个。若两边都不存在比它大的数，那么它就是树根。请设计O(n)的算法实现这个方法。

 给定一个无重复元素的数组A和它的大小n，请返回一个数组，其中每个元素为原数组中对应位置元素在树中的父亲节点的编号，
 若为根则值为-1。
 测试样例：

 [3,1,4,2],4

 返回：[2,0,-1,2]


 * Created by lizhaoz on 2016/2/4.
 */

public class MaxTree {
    public static int[] buildMaxTree(int[] A, int n) {
        if (A==null||A.length<=0){
            return null;
        }
        Integer[] leftmax=new Integer[n];//左边第一个比他大的数
        Integer[] rightmax=new Integer[n];//右边第一个比他大的数
        int[] res=new int[n];
        Stack<Integer> helpStack=new Stack<Integer>();
        //计算每个左边第一个比他大的数
        for (int i = 0; i < n; i++) {
            while (!helpStack.empty()&&A[helpStack.peek()]<A[i]){
                helpStack.pop();
            }
            if (helpStack.empty())
            leftmax[i]=null;
            else leftmax[i]=helpStack.peek();
            helpStack.push(i);
        }
        helpStack.clear();
        for (int i = n-1; i >= 0; i--) {
            while (!helpStack.empty()&&A[helpStack.peek()]<A[i]){
                helpStack.pop();
            }
            if (helpStack.empty())
                rightmax[i]=null;
            else rightmax[i]=helpStack.peek();
            helpStack.push(i);
        }
        for (int i = 0; i < n; i++) {
            if (leftmax[i]==null&&rightmax[i]==null){
                res[i]=-1;
            }
            else if (leftmax[i]==null&&rightmax[i]!=null){
                res[i]=rightmax[i];
            }
            else if (leftmax[i]!=null&&rightmax[i]==null){
                res[i]=leftmax[i];
            }
            else
            {
                if (A[leftmax[i]]<A[rightmax[i]])res[i]=leftmax[i];
                else  res[i]=rightmax[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A=new int[]{1,4,3,2};
        int []res=buildMaxTree(A,4);
        for (int i = 0; i <4 ; i++) {
            System.out.println(res[i]);
        }
    }
}
