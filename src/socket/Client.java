package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by lizhaoz on 2016/2/23.
 */

public class Client {
    public static void main(String[] args) {
        BufferedReader br=null;
        PrintWriter pw=null;
        try{
            Socket socket=new Socket("localhost",2000);//创建一个端口号为2000的socket
            br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pw=new PrintWriter(socket.getOutputStream(),true);//自动刷新为true
            pw.print("Hello");
            String s=null;
            while (true){
                s=br.readLine();//一直循环读取知道读取有数据

                if (s!=null)
                    break;
            }
            System.out.println(s);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                br.close();
                pw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
