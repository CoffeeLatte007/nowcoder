package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by lizhaoz on 2016/2/23.
 */

public class Server {
    public static void main(String[] args) {
        BufferedReader br=null;
        PrintWriter pw=null;

        try {
            ServerSocket server =new ServerSocket(2000);//创建一个端口号为2000的服务器端
            Socket socket=server.accept();
            //获取socket中获取输入流
            br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //从socket中获取输出流
            pw=new PrintWriter(socket.getOutputStream(),true);
            String s=br.readLine();//获取接受的数据
            pw.println(s);//发送相同的数据给客户端
        } catch (Exception e) {
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
