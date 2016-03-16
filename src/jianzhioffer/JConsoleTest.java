package jianzhioffer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lizhaoz on 2016/3/15.
 */

public class JConsoleTest {
    static class OOMobject{
        public byte[] placeholder =new byte[64*1024];
    }
    public static void fillHeap(int num)throws  InterruptedException{
        List<OOMobject> list=new ArrayList<OOMobject>();
        for (int i = 0; i < num; i++) {
            Thread.sleep(50);
            list.add(new OOMobject());
        }
        System.gc();
    }

    public static void main(String[] args) throws InterruptedException {
        fillHeap(10000);
    }
}
