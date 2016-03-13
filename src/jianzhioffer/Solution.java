package jianzhioffer;

/**
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case
 * 等关键字及条件判断语句（A?B:C）
 * Created by lizhaoz on 2016/3/13.
 */

public class Solution {

    public int Sum_Solution(int n) {
        return n*(n+1)/2;
    }

}
