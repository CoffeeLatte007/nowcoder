package company;

/**
 * 对于一个字符串，请设计一个高效算法，找到第一次重复出现的字符。
 给定一个字符串(不一定全为字母)A及它的长度n。请返回第一个重复出现的字符。保证字符串中有重复字符，
 字符串的长度小于等于500。
 测试样例：
 "qywyer23tdd",11
 返回：y
 * Created by lizhaoz on 2016/4/7.
 */

public class findFirstRepeat {
    public char findFirstRepeat(String A, int n) {

        if (A==null||A.length()<=0) {
            return 0;
        }
        char[] array=A.toCharArray();
        return find(array);
    }

    public char find(char[] array) {
        int[] a=new int[255];
        for (int i = 0; i < array.length; i++) {
            if (a[array[i]]!=0){
                a[array[i]]++;
            }else return array[i];
        }
        return 0;
    }

}
