package jianzhioffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
 * \他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}
 * ， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 * Created by lizhaoz on 2016/3/16.
 */

public class maxInWindows {
    public ArrayList<Integer> maxInWindows(int [] arr, int w)
    {
        ArrayList<Integer> arrayList=new ArrayList<Integer>();
        int n=arr.length;
        if (arr == null || w < 1 || n < w) {//如果数组为空，窗口w小于1或者数组长度小于窗口长度返回Null
            return arrayList;
        }
        int[] res=new int[n-w+1];
        LinkedList<Integer> qmax=new LinkedList<Integer>();
        int index=0;
        for (int i = 0; i < n; i++) {
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {//如果队尾的小于此时i的话弹出队尾，直到找到比他大的或者队列为空
                qmax.pollLast();
            }
            qmax.addLast(i);//把i添加进去
            if (qmax.peekFirst()==i-w){//过期判断弹出
                qmax.pollFirst();
            }
            if (i>=w-1){
                arrayList.add(arr[qmax.peekFirst()]);//把对应的值添加进res
            }
        }
        return arrayList;
    }
}
