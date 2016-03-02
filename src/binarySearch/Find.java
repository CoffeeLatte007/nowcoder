package binarySearch;

/**
 *

 有一个有序数组arr，其中不含有重复元素，请找到满足arr[i]==i条件的最左的位置。如果所有位置上的数都不满足条件，返回-1。

 给定有序数组arr及它的大小n，请返回所求值。
 测试样例：

 [-1,0,2,3],4

 返回：2


 * Created by lizhaoz on 2016/1/14.
 */

public class Find {
    public int findPos(int[] arr,int n){
        int res=-1;
        if (arr == null || arr.length == 0) {
            return res; // no exist
        }

        int left=0;
        int right=arr.length-1;
        if (arr[0]==0)return arr[0];
        if (arr[right]==right) return arr[right];
        int mid=0;
        while (left<=right){
            mid=left+(right-left)/2;
            if (arr[left]>left||arr[right]<right) break;
            if (arr[mid]<mid){
                left=mid+1;//只在右半区搜寻
            }else if (arr[mid]>mid){
                right=mid-1;//只在左半区搜寻
            }
            else {
                res=mid;
                right=mid-1;//找到后往左继续搜寻
            }
        }
        return res;
    }
}
