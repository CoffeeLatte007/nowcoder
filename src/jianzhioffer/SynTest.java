package jianzhioffer;

/**
 * Created by lizhaoz on 2016/3/15.
 */
 class Widget {
    public synchronized void dosomething() {
        System.out.println("widget");
    }
}
public class SynTest extends  Widget{
    public synchronized void dosomething() {
        super.dosomething();
    }

    public static void main(String[] args) {
        SynTest synTest=new SynTest();
        synTest.dosomething();
    }
}
