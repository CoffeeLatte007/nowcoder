package jianzhioffer;

/**
 * Created by lizhaoz on 2016/3/1.
 */

public class NumberOf1 {
    public int NumberOf1(int n) {
        int count=0;
        while (n!=0){
            ++count;
            n=(n-1)&n;
        }
        return count;
    }
}
