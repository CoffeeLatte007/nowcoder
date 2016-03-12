package jianzhioffer;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * Created by lizhaoz on 2016/3/11.
 */

public class FindNumsAppearOnce {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array==null||array.length<2){
            return;
        }
        int re=0;
        for (int i = 0; i < array.length; i++) {
            re^=array[i];
        }
        int index=getfirst1(re);
        for (int i = 0; i < array.length; i++) {
            if (boolarray(array[i],index)){
                        num1[0]^=array[i];
            }else {
                num2[0]^=array[i];
            }
        }
    }

    private boolean boolarray(int i,int index) {
        i>>=index;
        if ((i&1)==0){
            return false;
        }
        else return true;
    }

    private int getfirst1(int re) {
        int inx=0;
        while ((re&1)==0&&(inx<8*32))
        {
            re>>=1;
            inx++;
        }
        return inx;
    }

    public static void main(String[] args) {
        FindNumsAppearOnce a=new FindNumsAppearOnce();
        a.FindNumsAppearOnce(
                new int[]{2, 4, 3, 6, 3, 2, 5, 5}, new int[]{0}, new int[]{0});
    }
}
