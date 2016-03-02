package string;

/**
 * Created by lizhaoz on 2016/1/28.
 */

public class Transform {
    public boolean chkTransform(String A, int lena, String B, int lenb) {
       int[] totala=ck(A,lena);
        int[] totalb=ck(B,lenb);
        return check(totala,totalb);
    }

    private boolean check(int[] a, int[] b) {
        for (int i = 0; i < 256; i++) {
            if (a[i]!=b[i])return false;
        }
        return true;
    }

    private int[] ck(String s, int lena) {
        int[] num=new int[256];
        for (int i = 0; i < lena; i++) {
            num[s.charAt(i)]++;
        }
        return num;
    }
}