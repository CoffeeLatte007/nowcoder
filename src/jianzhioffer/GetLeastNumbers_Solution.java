package jianzhioffer;

import java.util.ArrayList;
import java.util.Random;

/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * Created by lizhaoz on 2016/3/8.
 */

public class GetLeastNumbers_Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> arr=new ArrayList<Integer>();
        if (input==null||input.length<=0)
            return arr;
        int partion=partionsort(input,0,input.length-1);
        while (partion!=k){
            if (partion>k){
                partion=partionsort(input,0,partion-1);
            }else {
                partion=partionsort(input, partion+1, input.length - 1);
            }
        }
        for (int i = 0; i <k ; i++) {
            arr.add(input[i]);
        }
        return arr;
    }

    private int partionsort(int[] input, int start,int end) {
       int i=start,j=end+1;
        int tmp=input[start];
        while (true){
            while (input[++i]<tmp)if (i==end)break;
            while (input[--j]>tmp)if (j==start)break;
            if (i>=j) break;
            swap(input,i,j);
        }
        swap(input,start,j);
        return j;
    }

    private void swap(int[] input, int ran, int end) {
        int tmp=input[ran];
        input[ran]=input[end];
        input[end]=tmp;
    }
}
