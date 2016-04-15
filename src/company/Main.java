package company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 度度熊有一张网格纸，但是纸上有一些点过的点，每个点都在网格点上，若把网格看成一个坐标轴平行于网格线的坐标系的话，
 * 每个点可以用一对整数x，y来表示。度度熊必须沿着网格线画一个正方形，使所有点在正方形的内部或者边界。
 * 然后把这个正方形剪下来。问剪掉正方形的最小面积是多少。
 *
 * 第一行一个数n(2≤n≤1000)表示点数，接下来每行一对整数xi,yi(－1e9<=xi,yi<=1e9)表示网格上的点
 * 输出描述:
 * 一行输出最小面积
 * 输入例子:
 * 2
 * 0 0
 * 0 3
 * 输出：
 * 8
 * Created by lizhaoz on 2016/4/14.
 */

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            int n = in.nextInt();
            ArrayList<Integer> x = new ArrayList<Integer>();
            ArrayList<Integer> y = new ArrayList<Integer>();

            for (int i = 0; i < n; i++) {
                x.add(in.nextInt());
                y.add(in.nextInt());
            }

            int xMin = Collections.min(x);
            int xMax = Collections.max(x);
            int yMin = Collections.min(y);
            int yMax = Collections.max(y);
            int a = Math.max(xMax - xMin, yMax - yMin);
            int area = (int) Math.pow(a, 2);

            System.out.println(area);
        }
    }
}
