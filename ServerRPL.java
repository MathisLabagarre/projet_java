import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerRPL {

    public static void main(String[] args) {
        boolean mode = true;        //définit le mode du serveur : 1 pour synchronisé 0 pour désynchronisé  
        if(mode == true){
            new ServerRPL();
        }
        else{
            new ServerRPL();
        }
    }

    public ServerRPL() {
        while (true) {
            try {
                ServerSocket socket = new ServerSocket(23456);
                socket.accept();
                new ServiceRPL(socket);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
