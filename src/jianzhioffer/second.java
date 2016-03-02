package jianzhioffer;

/**
 *
 * Created by lizhaoz on 2016/2/29.
 */

public class second {
    public String replaceSpace(StringBuffer str){
        if (str==null||str.length()<0){
            return null;
        }
        for (int i = 0; i < str.length(); i++) {
            char c=str.charAt(i);
            if (c==' '){
                str.replace(i,i+1,"%20");
            }
        }
        return str.toString();
    }
}
