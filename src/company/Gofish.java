package company;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * ss请cc来家里钓鱼，鱼塘可划分为n＊m的格子，每个格子每分钟有不同的概率钓上鱼，cc一直在坐标(x,y)的格子钓鱼，
 * 而ss每分钟随机钓一个格子。问t分钟后他们谁至少钓到一条鱼的概率大？为多少？
 *
 * 第一行五个整数n,m,x,y,t(1≤n,m,t≤1000,1≤x≤n,1≤y≤m);
 接下来为一个n＊m的矩阵，每行m个一位小数，共n行，第i行第j个数代表坐标为(i,j)的格子钓到鱼的概率为p(0≤p≤1)

 输入例子:
 2 2 1 1 1
 0.2 0.1
 0.1 0.4
 * Created by lizhaoz on 2016/4/14.
 */

public class Gofish {


    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while (in.hasNext()){
            int n=in.nextInt();
            int m=in.nextInt();
            int x=in.nextInt();
            int y=in.nextInt();
            int t=in.nextInt();
            int[][] d=new int[n][m];
            double p1=0;
            double p2=0;
            for (int i = 0; i <n; i++) {
                for (int j = 0; j <m ; j++) {
                    double tmp=in.nextDouble();
                    p2+=tmp;
                    if (i==x-1&&j==y-1){
                        p1=tmp;
                    }
                }
            }
            p1=1-Math.pow(1-p1,t);
            p2=1-Math.pow(1-p2/(m*n),t);
            if (p1-p2>=0.01){
                System.out.println("cc");
                System.out.println(new DecimalFormat("0.00").format(p1));
            }else if (p2-p1<=-0.01){
                System.out.println("ss");
                System.out.println(new DecimalFormat("0.00").format(p2));
            }else {
                System.out.println("equals");
                System.out.println(new DecimalFormat("0.00").format(p1));
            }
        }
    }
}
