package company;

import java.util.Scanner;

/**
 * C市现在要转移一批罪犯到D市，C市有n名罪犯，按照入狱时间有顺序，另外每个罪犯有一个罪行值，
 * 值越大罪越重。现在为了方便管理，市长决定转移入狱时间连续的c名犯人，
 * 同时要求转移犯人的罪行值之和不超过t，问有多少种选择的方式？
 * 第一行数据三个整数:n，t，c(1≤n≤2e5,0≤t≤1e9,1≤c≤n)，第二行按入狱时间给出每个犯人的罪行值ai(0≤ai≤1e9)
 * 输入
 * 3 100 2
 * 1 2 3
 * 输出
 * 2
 * Created by lizhaoz on 2016/4/13.
 */

public class TransferCrime {
    public static void main(String args[]){
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();//n个人
            int t = in.nextInt();//
            int c = in.nextInt();//连续c名
            int[] a = new int[n];
            for(int i = 0;i<n;i++){
                a[i] = in.nextInt();
            }
            int count = 0;
            int tempt = 0;
            for(int i = 0;i<c;i++){
                tempt += a[i];
            }
            if(tempt<=t)
                count++;
            for(int i = c;i<a.length;i++){
                tempt = tempt+a[i]-a[i-c];
                if(tempt<=t)
                    count++;
            }
            System.out.println(count);
        }
    }

    private static void findRes(int n, int t, int c, int[] a) {

    }
}
