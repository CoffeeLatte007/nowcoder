package company;

import java.util.Scanner;

/**
 * 已知某公司总人数为W，平均年龄为Y岁(每年3月末计算，同时每年3月初入职新人)，假设每年离职率为x，x>0&&x<1,
 * 每年保持所有员工总数不变进行招聘，新员工平均年龄21岁。
 从今年3月末开始，请实现一个算法，可以计算出第N年后公司员工的平均年龄。(结果向上取整)。
 * Created by lizhaoz on 2016/4/13.
 */

public class Avgage {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            int W=scanner.nextInt();
            int Y=scanner.nextInt();
            double x=scanner.nextDouble();
            int N=scanner.nextInt();
            int end=age(Y,x,N);
            System.out.println(end);
        }
    }

    private static int age(double y, double x, int n) {
        for(int i = 1;i<=n;i++){
            y = 21*x+(1-x)*(y+1);
        }
        return (int)Math.ceil(y);
    }
}
