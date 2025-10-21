import java.io.IOException;
import java.net.ServerSocket;

public class ServiceRPL extends Thread {

    InputRPL in;
    OutputRPL out;
    PileRPL pile;

    public ServiceRPL(ServerSocket socket) throws IOException{
        start();
        socket.close();
    }

    public ServiceRPL(String log){
        this.in = new InputRPL(true, log);
        this.out = new OutputRPL();
        this.pile = new PileRPL();
        runCalc();
    }

    public void runCalc(){
        while (!this.in.query.equals("exit")){
            out.print("RPL COMMAND> ");
            this.in.scan();
        }
        this.in.close();
    }
}