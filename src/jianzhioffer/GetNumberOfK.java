package jianzhioffer;

/**
 * 统计一个数字在排序数组中出现的次数。
 * 思路找到他的第一个数字位置，找到他的最后一个数字的位置
 * Created by lizhaoz on 2016/3/10.
 */

public class GetNumberOfK {
    public int GetNumberOfk(int[] array,int k){
        if(array==null||array.length<=0){
            return 0;
        }
        int start=0,end=array.length-1;
        int first=getnumfirst(array,k,start,end);
        int last=getnumlast(array, k, start, end);
        if (last==first&&last==-1){
            return 0;
        }
        return last-first+1;
    }

    private int getnumlast(int[] array, int k, int start, int end) {
        if (start>=end){
            if (array[start]==k)
                return start;
            else
                return -1;
        }
        int mid=(end-start)/2+start;
        int result=-1;
        if (array[mid]<k){
            result=getnumfirst(array,k,mid+1,end);
        }else if (array[mid]>k){
            result=getnumfirst(array,k,start,mid-1);
        }else {
            if (array[mid+1]!=k)
            { System.out.println(mid);
                result=mid;
            }
            else result=getnumlast(array, k, mid + 1, end);
        }
        return result;
    }

    private int getnumfirst(int[] array, int k,int start,int end) {
        if (start>=end){
            if (array[end]==k)
            return end;
            else
                return -1;
        }
        int mid=(end-start)/2+start;
        int result=0;
        if (array[mid]<k){
            result=getnumfirst(array,k,mid+1,end);
        }else if (array[mid]>k){
            result=getnumfirst(array,k,start,mid-1);
        }else {
            if (mid==0||array[mid-1]!=k)
                result=mid;
            else result=getnumfirst(array,k,start,mid-1);
        }
        return result;
    }

    public static void main(String[] args) {
        GetNumberOfK gn=new GetNumberOfK();
        System.out.println(gn.GetNumberOfk(new int[]{3},3));
    }
}
