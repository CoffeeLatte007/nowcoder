package socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lizhaoz on 2016/4/12.
 */

public class SocketServer {
    private ServerSocket serverSocket;
    private ExecutorService executorService;//利用线程池管理Socket
    private final int POOL_SIZE=10;//单个cpu线程池大小
    public SocketServer(){
        try {
            //创建一个端口号为2000的服务器端
            serverSocket =new ServerSocket(2000);
            System.out.println(Runtime.getRuntime().availableProcessors());
            //创建一个可用处理器*POOK_SIZE大小
            executorService= Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()*POOL_SIZE);
            System.out.println("监听服务器启动，端口号:2000");
        }catch(Exception e){
            System.out.println("失败");
        }
    }
    public void service(){
        try {
            while (true) {
                Socket clientSocket = null;
                //启动阻塞接受方法
                try {
                    clientSocket = serverSocket.accept();
                    //executorService.execute();
                } catch (Exception e) {
                    System.out.println(e);
                }

            }
        }catch (Exception e){

        }finally {
            if (serverSocket!=null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
