/**
 * Created by lizhaoz on 2016/4/5.
 */

public class company {
    public int countBitDiff(int m, int n) {

        int dif=m^n;//先将二者做异或运算，得到结果；
        int cnt=0;
        while(dif!=0){
            dif=dif&(dif-1);
            cnt++;
        }             //统计一个整数dif含有多少个1；
        return cnt;
    }
}
