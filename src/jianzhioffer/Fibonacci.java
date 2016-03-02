package jianzhioffer;

/**
 * Created by lizhaoz on 2016/3/1.
 */

public class Fibonacci {
    public int Fibonacci(int n) {
        int pre=0;int two=1;
        if(n<=0){
            return 0;
        }
        if (n==1){
            return two;
        }
        int result=0;
        for (int i = 2; i <=n ; i++) {
            result=pre+two;
            pre=two;
            two=result;
        }
        return result;
    }
}
