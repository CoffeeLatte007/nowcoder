package jianzhioffer;

import java.util.Arrays;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，
 * 则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * 两次排序搜索O（n^2）,使用归并排序O(nlogn) 空间复杂度为O（n）
 * Created by lizhaoz on 2016/3/9.
 */

public class InversePairs {
    public int InversePairs(int [] array) {
            if(array.length<=0)
                return 0;
            return mergesort(array,0,array.length-1);
        }
    public int  mergesort(int[] array,int l,int r){
        if(l>=r){
            return 0;
        }
        int mid=(l+r)/2;
        int lnums=mergesort(array,l,mid);
        int rnums=mergesort(array,mid+1,r);
        return  lnums+rnums+merge(array,l,mid,r);
    }
    public int merge(int[] array,int l,int mid,int r){
        int [] temp = new int[r-l+1];

        int count=0;
        int i=l,j=mid+1,t=0;
        while(i<=mid||j<=r){
            if(i>mid&&j<=r){
                temp[t++]=array[j];
                j++;
                continue;
            }else if(i<=mid&&j>r){
                temp[t++]=array[i];
                i++;
                continue;
            }
            if(array[i]>array[j]){
                temp[t++]=array[j];
                count+=mid-i+1;
                j++;

            }else {
                temp[t++]=array[i];
                i++;
            }
        }
        for(i=l;i<=r;i++){
            array[i]=temp[i-l];
        }
        return count;
    }
}
