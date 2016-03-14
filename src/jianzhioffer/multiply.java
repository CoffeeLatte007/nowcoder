package jianzhioffer;

/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * Created by lizhaoz on 2016/3/14.
 */

public class multiply {
    public int[] multiply(int[] A) {
        int[] c=new int [A.length];
        int[] d=new int [A.length];
        c[0]=1;
        for (int i = 1; i <A.length ; i++) {
            c[i]=c[i-1]*A[i-1];
        }
        d[A.length-1]=1;
        for (int i = A.length-2; i >=0 ; i--) {
            d[i]=d[i+1]*A[i+1];
            c[i]=d[i]*c[i];
        }
        return c;
    }
}
