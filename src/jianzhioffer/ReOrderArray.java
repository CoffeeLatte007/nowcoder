package jianzhioffer;

/**
 * Created by lizhaoz on 2016/3/2.
 */

public class ReOrderArray {
    public void reOrderArray(int [] array) {
        if (array==null||array.length==0){
            return;
        }
        //用快速排序实现
        for (int i=0;i<array.length;i++){
            if (array[i]%2==0) continue;
            int j=i;
            while (j>0){
                if (array[j-1]%2==0){
                    int t=array[j];
                    array[j]=array[j-1];
                    array[j-1]=t;
                    j--;
                }
                else break;
            }
        }
    }
}
