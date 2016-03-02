package stackandqueue;

import java.util.LinkedList;

/**
 *

 有一个整型数组 arr 和一个大小为 w 的窗口从数组的最左边滑到最右边,窗口每次向右边滑一个位置。
 返回一个长度为n-w+1的数组res，res[i]表示每一种窗口状态下的最大值。 以数组为[4,3,5,4,3,3,6,7]，
 、w=3为例。因为第一个窗口[4,3,5]的最大值为5，第二个窗口[3,5,4]的最大值为5，第三个窗口[5,4,3]的最大值为5。
 第四个窗口[4,3,3]的最大值为4。第五个窗口[3,3,6]的最大值为6。第六个窗口[3,6,7]的最大值为7。
 所以最终返回[5,5,5,4,6,7]。

 给定整形数组arr及它的大小n，同时给定w，请返回res数组。保证w小于等于n，同时保证数组大小小于等于500。
 测试样例：

 [4,3,5,4,3,3,6,7],8,3

 返回：[5,5,5,4,6,7]


 * Created by lizhaoz on 2016/2/4.
 */

public class SlideWindow {
    public int[] slide(int[] arr, int n, int w) {
        if (arr == null || w < 1 || n < w) {//如果数组为空，窗口w小于1或者数组长度小于窗口长度返回Null
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<Integer>();//实现一个qmax的队列
        int[] res = new int[n - w + 1];
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
                res[index++]=arr[qmax.peekFirst()];//把对应的值添加进res
            }
        }
        return res;
    }
}
