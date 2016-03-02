package jianzhioffer;

import java.io.*;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 一个文件中有10000个数，用Java实现一个多线程程序将这个10000个数输出到5个不用文件中
 * （不要求输出到每个文件中的数量相同）。要求启动10个线程，两两一组，分为5组。
 * 每组两个线程分别将文件中的奇数和偶数输出到该组对应的一个文件中，
 * 需要偶数线程每打印10个偶数以后，就将奇数线程打印10个奇数，如此交替进行。
 * 同时需要记录输出进度，每完成1000个数就在控制台中打印当前完成数量，并在所有线程结束后，在控制台打印”Done”.
 * Created by lizhaoz on 2016/3/2.
 */

public class PrintTreeNode {
    public static void main(String[] args) {
        try {
            FileWriter fileWriter= new FileWriter(new File("E://input.txt"),true);
            Random random=new Random();
            for (int i = 0; i < 10000; i++) {
                fileWriter.write(Math.abs(random.nextInt()%100)+" ");
            }
            fileWriter.flush();
            fileWriter.close();
            BufferedReader bf=new BufferedReader(new FileReader("E://input.txt"));
            String str=bf.readLine();
            String[] strs=str.split(" ");
            int j=0;
            for (int i = 0; i < 5; i++) {
                int records[]=new int[2000];
                //为每组分配好数据
                for (int k=0;k<2000;k++){
                    records[k]=Integer.parseInt(strs[j]);
                    j++;
                }
                PrintWriter writer=new PrintWriter(new File("output"+i+".txt"));//应该写在外面可以关闭
                ThreadGroup group=new ThreadGroup(records,writer);//为每个组都分配好数据
                new Thread(group).start();
                new Thread(group).start();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class ThreadGroup implements Runnable{
    private static int count=0;//初始化count为0
    private static Object lock=new Object();//记录coutn的锁,10个线程共同的锁
    private int status=0;//状态为0的时候就记录偶数
    private PrintWriter writer;
    private int[] records;
    private int oddpoint=0;//记录偶数所遍历的位置
    private int evenpoint=0;//记录基数所遍历的位置
    public ThreadGroup(int[] records, PrintWriter writer) {
        this.records=records;
        this.writer=writer;
    }

    @Override
    public void run() {
        while (printf());
    }

    private synchronized boolean printf() {
        for (int i = 0; i <10 ; ) {
            if (oddpoint>=records.length&&evenpoint>=records.length){//如果偶数线程遍历完了，并且基数线程也遍历完了
                notifyAll();
                return false;
            }
            if ((evenpoint>=records.length&&status==0)||(oddpoint>=records.length&&status==(~0))){//如果偶数线程遍历完了，奇数没遍历完这个时候可以break
                break;
            }
            if (status==0){
                if (records[evenpoint]%2==0){
                    i++;
                    writer.print(records[evenpoint]+" ");
                    writer.flush();
                    synchronized (lock){
                        count++;
                        if (count%10==0)
                            System.out.println("目前完成了"+count);
                        if (count%10000==0)
                            System.out.println("done");
                    }

                }
                evenpoint++;
            }else {
                if (records[oddpoint]%2==1){
                    i++;
                    writer.print(records[oddpoint]+" ");
                    writer.flush();
                    synchronized (lock){
                        count++;
                        if (count%10==0)
                            System.out.println("目前完成了"+count);
                        if (count%10000==0)
                            System.out.println("done");
                    }

                }
                oddpoint++;
            }
        }
        status=~status;
        notifyAll();//让出cpu给其他通知其他进行，并且进行wait
        try {
            wait();//释放锁给另外一个线程
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }
}