package sort;

import java.util.Scanner;

/**
 * 计数排序
 * Created by lizhaoz on 2016/1/10.
 */

public class CountingSort {
    public static void sort(int[] a){
        int N=a.length;
        //首先建立桶排序的桶,找到最小和最大值
        int min=a[0],max=a[0];
        for (int i = 0; i <N; i++) {
            max=Math.max(max,a[i]);
            min=Math.min(min,a[i]);
        }
        int[] count=new int[max-min+1];
        for (int i = 0; i < N; i++) {
            count[a[i]-min]++;
        }
        int index=0;
        for (int i = 0; i < count.length; i++) {
            while (count[i]-->0){
                a[index++]=i+min;
            }
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
