package jianzhioffer;

import java.util.ArrayList;

/**
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 * Created by lizhaoz on 2016/3/11.
 */

public class FindContinuousSequence {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> b=new ArrayList<ArrayList<Integer>>();
        if (sum<=0)
            return b;
        int n=1,m=2;
        int curSum=n+m;
        int mid=(1+sum)/2;
        while (n<mid){
            if (curSum==sum){
                ArrayList<Integer> array=getList(n,m);
                b.add(array);
            }
            while (curSum>sum&&n<mid){
                curSum-=n;
                n++;
                if (curSum==sum){
                    ArrayList<Integer> array=getList(n,m);
                    b.add(array);
                }
            }
            m++;
            curSum+=m;
        }
        return b;
    }

    private ArrayList<Integer> getList(int n, int m) {
        ArrayList<Integer> re=new ArrayList<Integer>();
        for (int i = n; i <=m ; i++) {
            re.add(i);
        }
        return re;
    }

    private int getsum(int n, int m) {
        int re=0;
        for (int i = n; i<=m ; i++) {
            re+=i;
        }
        return re;
    }
}
