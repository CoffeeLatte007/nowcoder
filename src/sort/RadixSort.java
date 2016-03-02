package sort;

import java.util.Scanner;

/**
 * Created by lizhaoz on 2016/1/10.
 */

public class RadixSort {
    public static void sort(int[] a){
        int N=a.length;
        //首先建立桶排序的桶,找到最小和最大值
        int max=a[0];
        for (int i = 0; i <N; i++) {
            max=Math.max(max,a[i]);
        }
        int[] radix=new int[10];
        for (int i = 0; i < max; i++) {
            
        }
    }



    private static void exch(int[] a,int i,int j){
        int t=a[i];
        a[i]=a[j];
        a[j]=t;
    }
    private static void show(int[] a){
        for (int i = 0; i <a.length ; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] numbers=new int[10];
        Scanner in=new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            numbers[i]=in.nextInt();
        }
        sort(numbers);
        show(numbers);
    }
}
