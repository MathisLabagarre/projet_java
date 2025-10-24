import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerRPL {

    boolean mode;
    public static void main(String[] args) {
        Boolean mode = true;        //définit le mode du serveur : 1 pour synchronisé 0 pour désynchronisé  
        new ServerRPL(mode);
    }

    public ServerRPL(boolean mode){
        this.mode = mode;
        PileRPL pile = new PileRPL();
        try(ServerSocket socket = new ServerSocket(23456)) {
            while (true) {
                Socket clientSocket = socket.accept();
                if(!mode){
                    pile = new PileRPL();
                }
                new ServiceRPL(clientSocket, pile);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
