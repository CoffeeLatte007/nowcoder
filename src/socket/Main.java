package socket;


import java.io.*;
import java.util.*;
public class Main
{
    public static int fun(String src)
    {
        char[] chars=src.toCharArray();
        int flag=0;
        int res=0;
        for (int i = 0; i<chars.length; i++) {
            if (chars[i]=='.'){
                flag++;
            }
            else if (flag>0&&chars[i]!='.'){
                res+=fx(flag);
                flag=0;
            }
        }
        if (flag>0){
            res+=fx(flag);
        }
        return res;
    }

    private static int fx(int flag) {
        int res=0;
        while (flag>1){
            res+=(flag/2);
            flag=(flag/2)+(flag%2);
        }
        return res;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner cin=new Scanner(new BufferedInputStream(System.in));
        while(cin.hasNextInt()) {
            int n, b, m;
            String ch;
            n = cin.nextInt();
            b = cin.nextInt();
            String s1 = cin.next();

            for (int i = 0; i < b; i++) {
                m = cin.nextInt();
                ch = cin.next();
                String sone=s1.substring(0,m);
                String stwo=s1.substring(m+1,s1.length());
                String re=sone+ch+stwo;
                System.out.println(re);
                System.out.println(fun(re));
                s1=re;
            }
        }
    }
}