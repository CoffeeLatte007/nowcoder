package jianzhioffer;

/**
 * Created by lizhaoz on 2016/3/1.
 */

public class RectCover {
    public int RectCover(int target) {
        int one=1;int two=1;
        if (target<=0){
            return 1;
        }
        if (target==1){
            return one;
        }
        int result=0;
        for (int i = 2; i <=target ; i++) {
            result=one+two;
            one=two;
            two=result;
        }
        return result;
    }
}
