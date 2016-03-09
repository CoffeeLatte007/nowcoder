package jianzhioffer;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Created by lizhaoz on 2016/3/8.
 */

public class Permutation {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> arrayList=new ArrayList<String>();
        if (str==null||str.length()==0)
            return arrayList;
        char[] pchar=str.toCharArray();
        TreeSet<String> set=new TreeSet<String>();
        allper(set,pchar,0);
        arrayList.addAll(set);
        return arrayList;
    }

    private void allper(TreeSet<String> set, char[] pchar,int scanbegin) {
        if (scanbegin==pchar.length){
            set.add(String.valueOf(pchar));
        }
        else {
            for (int i = scanbegin; i <= pchar.length - 1; i++) {
                if (pchar[i]!=pchar[scanbegin]||i==scanbegin)
                {
                char tmp =pchar[i];
                pchar[i]=pchar[scanbegin];
                pchar[scanbegin]=tmp;
                allper(set,pchar,scanbegin+1);
                tmp =pchar[i];
                pchar[i]=pchar[scanbegin];
                pchar[scanbegin]=tmp;
                }
            }
        }
    }
}
