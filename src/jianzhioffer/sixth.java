package jianzhioffer;

/**
 * Created by lizhaoz on 2016/2/29.
 */

public class sixth {
    public static int minNumberInRotateArray(int [] array) {
        if (array==null||array.length==0){
            return 0;
        }
        int start=0;
        int end=array.length-1;
        int mid=start;
        while (array[start]>=array[end]){
            if (end-start==1){
                mid=end;
                break;
            }
            mid=(start+end)/2;
            if (array[start]==array[end]&&array[end]==array[mid]){
                return MinOrder(array,start,end);
            }
            if (array[mid]>=array[start]){
                start=mid;
            }
            if (array[mid]<=array[end]){
                end=mid;
            }
        }
        return array[mid];
    }

    private static int MinOrder(int[] array, int start, int end) {

        int result=array[start];
        for (int i=start+1;i<=end;i++){
            if (array[i]<result){
                result=array[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A=new int[]{3,4,5,1,2};
        minNumberInRotateArray(A);
    }
}
