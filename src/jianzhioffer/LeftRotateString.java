package jianzhioffer;

/**
 * Created by lizhaoz on 2016/3/11.
 */

public class LeftRotateString {
    public String LeftRotateString(String str,int n) {
        if (str==null||str.length()<=0){
            return null;
        }
        char[] s=str.toCharArray();
        reverse(s,0,s.length-1);
        reverse(s,0,s.length-n-1);
        reverse(s,s.length-n,s.length-1);
        return String.valueOf(s);
    }

    private void reverse(char[] s,int begin,int end) {
        while (begin<end){
            char tmp=s[begin];
            s[begin]=s[end];
            s[end]=tmp;
            begin++;
            end--;
        }
    }
}
