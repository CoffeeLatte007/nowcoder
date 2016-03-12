package jianzhioffer;

import java.util.ArrayList;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，
 * 使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * Created by lizhaoz on 2016/3/11.
 */

public class FindNumbersWithSum {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> arrayList=new ArrayList<Integer>();
        if (array==null||array.length<2){
            return arrayList;
        }
        int small=0,big=array.length-1;
        while (small<big){
            int hs=array[small]+array[big];
            if (hs==sum){
                arrayList.add(array[small]);
                arrayList.add(array[big]);
            }else if (hs<sum){
                small++;
            }else {
                big--;
            }
        }
        return arrayList;
    }
}
