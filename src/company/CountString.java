package company;

import java.util.Scanner;

/**
 * Created by lizhaoz on 2016/4/12.
 */

public class CountString {
    /**
     * 采用排列组合调整
     * @param a
     * @param b
     * @param min
     * @return
     */
    public static long get(String a,String b,int min)
    {
        long suma=0;
        long sumb=0;
        char[] ar=a.toCharArray();
        char[] br=b.toCharArray();
        for(int i=0;i<ar.length;i++)
        {
            suma=suma+(ar[i]-'a')*(long)Math.pow(26,min-1-i);
        }
        if(ar.length!=0)
        {
            suma++;
        }
        for(int i=0;i<br.length;i++)
        {
            sumb=sumb+(br[i]-'a')*(long)Math.pow(26,min-1-i);
        }
        if(br.length!=0)
        {
            sumb++;
        }
        return sumb-suma;
    }
    public static void main(String[] args)
    {
        Scanner scan=new Scanner(System.in);
        while(scan.hasNext())
        {
            //获取输入的参数
            String s=scan.nextLine();
            String[] array=s.split(" ");
            //得到len1长度
            int min=Integer.parseInt(array[2]);
            //得到len2长度
            int max=Integer.parseInt(array[3]);
            long sum=0;
            //一次找从min长度到max长度
            for(int i=min;i<=max;i++)
            {
                char a=array[0].charAt(0);
                char b=array[1].charAt(0);
                //在当前长度之前26^(i-1)都会直接计算在之内
                sum=sum+(long)Math.pow(26,i-1)*(b-a);
                //找到1到i之间的
                String la=array[0].substring(1, i < array[0].length() ? i : array[0].length());
                //找到1到i之间的
                String lb=array[1].substring(1, i < array[1].length() ? i : array[1].length());

                sum=sum+get(la,lb,i-1);
            }
            long res=sum-1;
            System.out.println(res%1000007);
        }

    }
}
