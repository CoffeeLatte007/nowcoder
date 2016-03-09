package jianzhioffer;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，
 * 超过数组长度的一半，因此输出2。如果不存在则输出0。
 * 给出两种解法
 * Created by lizhaoz on 2016/3/8.
 */

public class MoreThanHalfNum_Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array==null||array.length<=0)
            return 0;
        int result=0;
        int temp=0;
        for (int i = 0; i < array.length; i++) {
            if (temp<=0){
                result=array[i];
                temp++;
            }
            else {
                if (result!=array[i]){
                    temp--;
                }
                else temp++;
            }
        }
       if( !checkMoreThanHalf(result,array,array.length)){
           return 0;
       }
        return result;
    }

    private boolean checkMoreThanHalf(int result, int[] array, int length) {
        int len=0;
        for (int i = 0; i < array.length; i++) {
            if (array[i]==result)
                len++;
        }
        if (len>=array.length/2)
            return true;
        return false;
    }
}
