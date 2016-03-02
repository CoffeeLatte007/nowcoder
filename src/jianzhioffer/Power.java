package jianzhioffer;

/**
 * Created by lizhaoz on 2016/3/2.
 */

public class Power {
    public double Power(double base, int exponent) {
        if (equals(base,0.0)&&exponent<0){
            return 0;//在这里进行抛出异常也可以，主要和面试官沟通
        }
        int absex=Math.abs(exponent);
        if (exponent>=0){
            return powexponent(base,absex);
        }
        else{
            return (double)1.0/powexponent(base,absex);
        }

    }

    private double powexponent(double base, int exponent) {

        if (exponent==0){
            return 1;
        }
        if (exponent==1){
            return base;
        }
        double preresult=powexponent(base,exponent>>1);
        double result=preresult*preresult;
        if ((exponent&0x1)==1){
            result*=base;//对三的计算
        }
        return result;
    }

    /**
     *
     * @param base
     * @param v
     * @return
     */
    private boolean equals(double base, double v) {
        if (base-v<0.0000001&&base-v>-0.0000001){
            return true;
        }
        return false;
    }
}
