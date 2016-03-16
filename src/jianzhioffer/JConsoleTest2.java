package jianzhioffer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lizhaoz on 2016/3/15.
 */

public class JConsoleTest2 {
    public static void createBusyThread(){
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                while (true);
            }
        },"testBusyThread");
        thread.start();
    }
    public static void createLockThread(final Object lock){
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    try {
                        lock.wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        },"testLockThread");
        thread.start();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        createBusyThread();
        bufferedReader.readLine();
        Object obj=new Object();
        createLockThread(obj);
    }
}
