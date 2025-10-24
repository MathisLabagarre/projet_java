import java.net.Socket;
import java.io.PrintWriter;

public class OutputRPL {
    Boolean local;
    
    Socket socket;
    PrintWriter out;

    public OutputRPL(Socket socket){
        local = false;
        this.socket = socket;
        try{
            this.out = new PrintWriter(socket.getOutputStream());
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public OutputRPL(){
        this.out = new PrintWriter(System.out, true);
        this.local = true;
    }

    public void print(String message){
        System.out.print(message);
        this.out.print(message);
        this.out.flush();
    }

    public void close(){
        this.out.close();
    }
}
