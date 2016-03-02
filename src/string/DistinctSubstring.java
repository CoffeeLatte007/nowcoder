package string;

/**
 *

 对于一个字符串,请设计一个高效算法，找到字符串的最长无重复字符的子串长度。

 给定一个字符串A及它的长度n，请返回它的最长无重复字符子串长度。保证A中字符全部为小写英文字符，且长度小于等于500。
 测试样例：

 "aabcb",5

 返回：3


 * Created by lizhaoz on 2016/1/28.
 */

public class DistinctSubstring {
    public int longestSubstring(String A, int n) {
        int maxlength=0;
        char[] cs=A.toCharArray();
        int[] c=new int[256];
        for (int i = 0; i < 256; i++) {
            c[i]=-1;
        }
        int start=-1;
        for (int i=0;i<n;i++){
            if (c[cs[i]]>start){
                start=i;
                c[cs[i]]=i;
            }
            else {
                c[cs[i]]=i;
                maxlength=Math.max(maxlength,i-start+1);
            }
        }
        return maxlength;
    }
}
