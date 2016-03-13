package jianzhioffer;

/**
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
 * Created by lizhaoz on 2016/3/13.
 */

public class StrToInt {
    public int StrToInt(String str) {
       if (str.equals("") || str.length() == 0)
        return 0;
        char[] a = str.toCharArray();
        int flag = 0;
        if (a[0] == '-')
            flag = 1;
        int sum = 0;
        for (int i = flag; i < a.length; i++)
        {
            if (a[i] == '+')
                continue;
            if (a[i] < 48 || a[i] > 57)
                return 0;
            sum = sum * 10 + a[i] - 48;
        }
        return flag == 0 ? sum : sum * -1;
    }
}
