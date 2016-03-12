package jianzhioffer;

import java.lang.reflect.Field;
import java.sql.DriverManager;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.*;

/**
 * Created by lizhaoz on 2016/3/10.
 */

public class Test {
    private int a=5;
    public String b="string";
    static class T{
        public int c=6;
        private static int d=7;
    }
    public static void main(String[] args) {
//        Test test=new Test();
//        Class t=test.getClass();
//        Field[] field=t.getDeclaredFields();
//        for (int i = 0; i < field.length; i++) {
//            try {
//               field[i].setAccessible(false);
//                if (field[i].getName().equals("a")){
//                    field[i].set(test,8);
//                }
//                System.out.println(field[i].getName()+" "+field[i].get(test));
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            }
//        }
        System.out.println(T.d);
    }
}
