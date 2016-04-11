package company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilterInputStream;

/**
 * Created by lizhaoz on 2016/4/6.
 */
public class bb extends Thread implements Runnable {

    public void run(){
        System.out.println("this is run()");
    }
    public static void main(String[] args) throws FileNotFoundException {
        int j=8;
        j*=(j+3*6*j--);
    }
    public void amethod(){
        int oi= 012;
        System.out.println(oi);
    }

}
