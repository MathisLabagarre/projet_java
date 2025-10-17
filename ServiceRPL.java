import java.io.IOException;
import java.net.ServerSocket;

public class ServiceRPL extends Thread {
    public ServiceRPL(ServerSocket socket) throws IOException{
        start();
        socket.close();
    }
}