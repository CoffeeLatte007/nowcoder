package string;

import java.util.Arrays;
import java.util.Comparator;

/**
 *

 对于一个给定的字符串数组，请找到一种拼接顺序，使所有小字符串拼接成的大字符串是所有可能的拼接中字典序最小的。

 给定一个字符串数组strs，同时给定它的大小，请返回拼接成的串。
 测试样例：

 ["abc","de"],2

 "abcde"


 * Created by lizhaoz on 2016/1/28.
 */

public class Prior {
    public String findSmallest(String[] strs, int n) {
        if (strs == null || n == 0) {
            return "";
        }
        // 根据新的比较方式排序
        Arrays.sort(strs, new MyComparator());
        String res = "";
        for (int i = 0; i < n; i++) {
            res += strs[i];
        }
        return res;
    }
    private class MyComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            return (a + b).compareTo(b + a);
        }
    }
    }


