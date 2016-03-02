package string;

/**
 *

 对于一个字符串，请设计一个算法，将字符串的长度为len的前缀平移到字符串的最后。

 给定一个字符串A和它的长度，同时给定len，请返回平移后的字符串。
 测试样例：

 "ABCDE",5,3

 返回："DEABC"


 * Created by lizhaoz on 2016/1/28.
 */

public class Translation {
    public String stringTranslation(String A, int n, int len) {
       char[] cs=A.toCharArray();
        reversestring(cs,0,len-1);
        reversestring(cs,len,n-1);
        reversestring(cs,0,n-1);
       return String.valueOf(cs);
    }
    private void reversestring(char[] cs, int lo, int hi) {

        while (hi>lo){
            char c=cs[lo];
            cs[lo]=cs[hi];
            cs[hi]=c;
            lo++;hi--;
        }
    }
}
