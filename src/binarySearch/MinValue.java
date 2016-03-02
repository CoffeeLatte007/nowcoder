package binarySearch;

/**
 *

 对于一个有序循环数组arr，返回arr中的最小值。有序循环数组是指，有序数组左边任意长度的部分放到右边去，右边的部分拿到左边
 来。比如数组[1,2,3,3,4]，是有序循环数组，[4,1,2,3,3]也是。 2 3 3 4 1 0

 给定数组arr及它的大小n，请返回最小值。



 [4,1,2,3,3],5

 返回：1


 * Created by lizhaoz on 2016/1/14.
 */

public class MinValue {
    public int getMin(int[] arr, int n) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int left = 0;
        int right = n - 1;
        int mid = 0;
        while (left<right){
            //当数组只有两个值的时候
            if (left==right-1){
                break;
            }
            //左边小于右边，left到right范围内是有序的
            if (arr[left]<arr[right]){
                return arr[left];
            }
            mid=(left+right)/2;
            if (arr[left]>arr[mid]){ //证明最小值在Left和mid之间
                right=mid;
                continue;
            }
            if (arr[mid]>arr[right]){//证明最小值在mid和right之间
                left=mid;
                continue;
            }
            //当出现等值的情况,从左边开始推移，找到left小于mid的值
            while (left<right){
                if (arr[left]==arr[mid]){
                    left++;
                }else if (arr[left]<arr[mid]){
                    return arr[left];
                }else {
                    right=mid;
                    break;
                }

            }
        }
        return Math.min(arr[left],arr[right]);
    }
}
