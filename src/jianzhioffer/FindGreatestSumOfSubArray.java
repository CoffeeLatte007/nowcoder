package jianzhioffer;

/**
 * [1,-2,3,10,-4,7,2,-5]
 * Created by lizhaoz on 2016/3/8.
 */

public class FindGreatestSumOfSubArray {
    public int FindGreatestSumOfSubArray(int[] array) {
        int result=Integer.MIN_VALUE;
        int tmp=Integer.MIN_VALUE;
        if (array==null||array.length<=0){
            return 0;
        }

        for (int i = 0; i <array.length; i++) {
            if(result<0){
                result=array[i];
                System.out.println(result);
            }else {
                result += array[i];
            }
            if (tmp<=result)
                tmp=result;
        }
        return tmp;
    }

    public static void main(String[] args) {
        FindGreatestSumOfSubArray findGreatestSumOfSubArray=new FindGreatestSumOfSubArray();
        int sum=findGreatestSumOfSubArray.FindGreatestSumOfSubArray(new int[]{1,-2,3,10,-4,7,2,-5});
        System.out.println(sum);
    }
}
