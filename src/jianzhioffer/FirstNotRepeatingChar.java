package jianzhioffer;

/**
 * Created by lizhaoz on 2016/3/9.
 */

public class FirstNotRepeatingChar {
    public int FirstNotRepeatingChar(String str) {
        if (str.length() == 0) {
            return  -1;
        }
        char c = 'A';
        if(str.charAt(0) >= 'a'){
            c = 'a';
        }
        int[] counts = new int[26];
        for (int i = 0; i < str.length(); i++) {
            counts[str.charAt(i) - c]++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (counts[str.charAt(i) - c] == 1){
                return i;
            }
        }
        return -1;
    }
}
