import java.net.Socket;

public class ServiceRPL extends Thread {

    InputRPL in;
    OutputRPL out;
    PileRPL pile;
    LogRPL logger;
    Socket socket;

    public ServiceRPL(Socket socket, PileRPL pile){
        this.socket = socket;
        this.in = new InputRPL(socket);
        this.out = new OutputRPL(socket);
        this.pile = pile;
        start();
    }

    public ServiceRPL(String log){
        this.in = new InputRPL(true, log);
        this.out = new OutputRPL();
        this.pile = new PileRPL();
        runCalc(log);
    }

    public void runCalc(String log){
        if (log.equals("rec")) this.logger = new LogRPL();
        while (!this.in.query.equals("exit")){
            out.print("RPL COMMAND> \r\n");
            this.in.scan();
            String[] something = this.in.query.trim().split(" ");
            int[] values = new int[3];
            try{
                for(int i = 0; i < something.length; i++){
                    values[i] = Integer.parseInt(something[i]);
                }
                ObjRPL obj;
                switch (something.length) {
                    case 0:
                        this.pile.print(this.out);
                        break;
                    case 1:
                        obj = new ObjRPL(values[0]);
                        this.pile.stack(obj);
                        if(log.equals("rec")) this.logger.writeLog(this.in.query);
                        break;
                    case 2:
                        obj = new ObjRPL(values[0], values[1]);
                        this.pile.stack(obj);
                        if(log.equals("rec")) this.logger.writeLog(this.in.query);
                        break;
                    case 3:
                        obj = new ObjRPL(values[0], values[1], values[2]);
                        this.pile.stack(obj);
                        if(log.equals("rec")) this.logger.writeLog(this.in.query);
                        break;
                    default:
                        this.out.print("Trop d'arguments.");
                        break;
                }
            }
            catch(NumberFormatException e){
                if(something.length > 1){
                    this.out.print("Veuillez respecter le format des commandes.");
                    continue;
                }
                String item = something[0];
                if(item.equals("+")){
                    try{
                        this.pile.add();
                        if(log.equals("rec")) this.logger.writeLog(this.in.query);
                    }
                    catch(Exception e1){
                        this.out.print("Problème lors de l'addition : " + e1.getMessage() + "\n");
                    }
                }
                else if(item.equals("-")){
                    try{
                        this.pile.subst();
                        if(log.equals("rec")) this.logger.writeLog(this.in.query);
                    }
                    catch(Exception e1){
                        this.out.print("Problème lors de la soustraction : " + e1.getMessage() + "\n");
                    }
                }
                else if(item.equals("*")){
                    try{
                        this.pile.mult();
                        if(log.equals("rec")) this.logger.writeLog(this.in.query);
                    }
                    catch(Exception e1){
                        this.out.print("Problème lors de la multiplication : " + e1.getMessage() + "\n");
                    }
                }
                else if(item.equals("/")){
                    try{
                        this.pile.div();
                        if(log.equals("rec")) this.logger.writeLog(this.in.query);
                    }
                    catch(Exception e1){
                        this.out.print("Problème lors de la division : " + e1.getMessage() + "\n");
                    }
                }
                else if(item.equals("s")){
                    try{
                        this.pile.swap();
                        if(log.equals("rec")) this.logger.writeLog(this.in.query);
                    }
                    catch(Exception e1){
                        this.out.print("Problème lors de l'échange : " + e1.getMessage() + "\n");
                    }
                }
                else{
                    this.out.print("Commande inconnue.");
                }
            }
            catch(Exception e){
                this.out.print(e + "\nAucun changement n'a été effectué, faites tout de même attention !\n");
            }
            this.pile.print(this.out);
            this.out.print("fin\n");
        }
        this.in.close();
    }

    public void run(){
        runCalc("none");
        try{
            this.socket.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}