package binarySearch;

import java.math.BigInteger;

/**
 *

 如果更快的求一个整数k的n次方。如果两个整数相乘并得到结果的时间复杂度为O(1)，得到整数k的N次方的过程请实现时间复杂度为O(logN)的方法。

 给定k和n，请返回k的n次方，为了防止溢出，请返回结果Mod 1000000007的值。
 测试样例：
 2,3
 返回：8
 * Created by lizhaoz on 2016/1/14.
 */

public class QuickPower {
    public int getPower(int k, int N) {
        //这里为了防止溢出，选用BigInter
        BigInteger res=BigInteger.valueOf(1);//结果
        BigInteger tmp=BigInteger.valueOf(k);//基础数据
        for (; N !=0 ; N>>=1) {
            if ((N&1)!=0){//和1做位运算可以得到最低位二进制是否等于1
                res=res.multiply(tmp);//res和tmp相乘
            }
            tmp=tmp.multiply(tmp);//基础数据增加次方
            //防止溢出对1000000007取余数
            res=res.mod(BigInteger.valueOf(1000000007));
            tmp=tmp.mod(BigInteger.valueOf(1000000007));
        }
        return res.intValue();
    }
}
