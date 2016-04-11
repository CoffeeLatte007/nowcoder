package bookzuo;

/**
 * 风口之下，猪都能飞。当今中国股市牛市，真可谓“错过等七年”。 给你一个回顾历史的机会，已知一支股票连续n天的价格走势，
 * 以长度为n的整数数组表示，数组中第i个元素（prices[i]）代表该股票第i天的股价。 假设你一开始没有股票，
 * 但有至多两次买入1股而后卖出1股的机会，并且买入前一定要先保证手上没有股票。若两次交易机会都放弃，收益为0。
 * 设计算法，计算你能获得的最大收益。 输入数值范围：2<=n<=100,0<=prices[i]<=100
 输入例子:
 3,8,5,1,7,8

 输出例子:
 12
 * Created by lizhaoz on 2016/4/5.
 */

public class calculateMax {
    /**
     * 利用两次dp
     * 一次从左往右遍历，一次从右往左遍历
     * @param prices
     * @return
     */
    public int calculateMax(int[] prices) {
        //记录[0..i]之间的最大收益
        int[] dpl=new int[prices.length];
        //记录[i...length-1]的最大收益
        int[] dpr=new int[prices.length];
        dpl[0]=0;//第一个肯定赋值为0
        int minI=0;
        //扫描一次左边
        for (int i = 1; i < dpl.length; i++) {
            //如果大于等于
            if (prices[i]>prices[i-1]){
                dpl[i]=Math.max(prices[i]-prices[minI],dpl[i-1]);
            }
            else {
                dpl[i] = dpl[i-1];
                if(prices[i]<prices[minI])
                    minI = i;
            }
        }
        //最后一个肯定赋值为0
        dpr[prices.length-1]=0;
        int maxI = prices.length-1;
        for(int i=prices.length-2; i>=0; i--){//从右到左扫描一遍填充dpr数组,和从左边扫描一样
            if(prices[i]<prices[i+1]){
                dpr[i] = Math.max(prices[maxI]-prices[i], dpr[i+1]);
            } else{
                dpr[i] = dpr[i+1];
                if(prices[i]>prices[maxI]){
                    maxI = i;
                }
            }
        }
        int res = 0;
        for(int i=0; i<prices.length-1; i++){ //比较得出最大值
            res = Math.max(dpl[i]+dpr[i], res);
        }
        return res;
    }

}
