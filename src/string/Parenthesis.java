package string;

/**
 *

 对于一个字符串，请设计一个算法，判断其是否为一个合法的括号串。

 给定一个字符串A和它的长度n，请返回一个bool值代表它是否为一个合法的括号串。
 测试样例：

 "(()())",6

 返回：true

 测试样例：

 "()a()()",7

 返回：false

 测试样例：

 "()(()()",7

 返回：false


 * Created by lizhaoz on 2016/1/28.
 */

public class Parenthesis {
    public boolean chkParenthesis(String A, int n) {
        int le=0,ri=0;
        char[] cs=A.toCharArray();
        for (int i = 0; i <n; i++) {
            if (le<ri||(cs[i]!='('&&cs[i]!=')'))return false;
            else if (cs[i]=='(') le++;
            else ri++;
        }
        if (le==ri)return true;
        else return false;
    }
}
