package jianzhioffer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * Created by lizhaoz on 2016/3/9.
 */

public class PrintMinNumber {
    public String PrintMinNumber(int [] numbers) {
        if (numbers==null||numbers.length<=0){
            return null;
        }
        Integer[] num=new Integer[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            num[i]=Integer.valueOf(numbers[i]);
        }
        Arrays.sort(num, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1=Integer.toString(o1)+Integer.toString(o2);
                String s2=Integer.toString(o2)+Integer.toString(o1);
                if (s1.compareTo(s2)>0){
                    return 1;
                }
                else return -1;
            }

            @Override
            public boolean equals(Object obj) {
                return false ;
            }
        });
        StringBuilder s=new StringBuilder("");
        for (int i = 0; i < numbers.length; i++) {
            s.append(Integer.toString(num[i]));
        }
        return s.toString();
    }

    public static void main(String[] args) {
        Integer a=1;
        Integer b=2;
        Integer c=3;
        Integer d=3;
        Integer e=321;
        Integer f=321;
        Long g =3L;
        System.out.println(c==d);
        System.out.println(e==f);//这就是很好的错误
        System.out.println(c==(a+b));//包装类的等等不遇到算数是不会拆箱的
        System.out.println(c.equals(a+b));
        System.out.println(g==(a+b));
        System.out.println(g.equals(a+b));
        LinkedBlockingDeque<Integer> linkedBlockingDeque=new LinkedBlockingDeque<Integer>();
    }
}
