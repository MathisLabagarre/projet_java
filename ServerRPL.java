import java.io.IOException;
import java.net.ServerSocket;

public class ServerRPL {

    public static void main(){
        boolean mode = true;        //définit le mode du serveur : 1 pour synchronisé 0 pour désynchronisé  
        if(mode == true){

        }
        else{
            
        }
    }

    public ServerRPL() {
        while (true) {
            try {
                ServerSocket socket = new ServerSocket(23456);
                socket.accept();
                new ServiceRPL(socket);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
