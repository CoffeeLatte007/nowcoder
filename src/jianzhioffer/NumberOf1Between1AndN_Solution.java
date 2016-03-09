package jianzhioffer;

/**
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次
 * ,但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数。
 * Created by lizhaoz on 2016/3/9.
 */

public class NumberOf1Between1AndN_Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        int length=Integer.valueOf(n).toString().length();
        char[] number=Integer.valueOf(n).toString().toCharArray();
        int moreone=0;
        int moretwo=0;
        int basic=0;
        if (length>2){
            if (number[0]>1){
                moreone=moreresult(length-1);
            }else {
                moreone=n-moreresult(length-1);
            }
            moretwo=Integer.valueOf(String.valueOf(number[0]))*moreresult(length-2)*(length-1);
            n=n-moreresult(length-1)*number[0];
        }

        for (int i = 0; i <= n; i++) {
            basic+=basicresult(i);

        }
        return (moreone+moretwo+basic);

}

    private int moreresult(int i) {
        int r=0;
        for (int j = 0; j <i; j++) {
            r*=10;
        }
        return r;
    }

    private int basicresult(int n) {
        int r=0;
            while (n>0){
                if (n%10==1){
                    r++;
                }
                n/=10;
            }

        return r;
    }

    public static void main(String[] args) {
        NumberOf1Between1AndN_Solution numberOf1Between1AndN_solution=new NumberOf1Between1AndN_Solution();
        System.out.println(numberOf1Between1AndN_solution.NumberOf1Between1AndN_Solution(10000));
    }
}
