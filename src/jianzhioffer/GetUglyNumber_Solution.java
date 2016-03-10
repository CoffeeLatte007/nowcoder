package jianzhioffer;

/**
 * 把只包含因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * Created by lizhaoz on 2016/3/9.
 */

public class GetUglyNumber_Solution {
    public int GetUglyNumber_Solution(int index) {
        if(index<0)return 0;
        int[] numbers=new int[index+1];
        numbers[0]=1;
        int idx=1,idx2=0,idx3=0,idx5=0;
        while (idx<index){
            //找出当前最小丑数
            int uglyNumber=Math.min(numbers[idx2]*2,numbers[idx3]*3);
            uglyNumber=Math.min(uglyNumber,numbers[idx5]*5);
            numbers[idx++]=uglyNumber;
            while (numbers[idx2]*2>=uglyNumber){
                idx2++;
            }
            while (numbers[idx3]*3>=uglyNumber){
                idx3++;
            }
            while (numbers[idx5]*5>=uglyNumber){
                idx5++;
            }
        }
        return numbers[index-1];//返回1499的
    }
}
