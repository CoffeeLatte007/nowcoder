package socket;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by lizhaoz on 2016/4/12.
 */

public class SocketHandler implements Runnable {
    private Socket socket;
    public SocketHandler(Socket socket) {
        this.socket = socket;
    }
    private PrintWriter getWriter(Socket socket) throws Exception {
        OutputStream socketOut = socket.getOutputStream();
        return new PrintWriter(socketOut, true);
    }
    @Override
    public void run() {

    }
}
