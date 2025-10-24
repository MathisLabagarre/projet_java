import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;
import java.io.BufferedReader;

public class UserRPL {

    boolean local;
    String log;
    
    public static void main(String[] args){
        switch (args.length) {
            case 2:
                String[] user = args[0].split("=");
                if(!user[0].equals("-user")) break; //à changer pour expliquer le pb à l'utilisateur
                if (user[1].equals("local")) {
                    if(!args[1].startsWith("-log=")) break;
                    String[] logs = args[1].split("=");
                    new UserRPL(logs[1]);
                }
                else if (user[1].equals("remote")){
                    new UserRPL(false);
                }
                break;
            case 1:
                //parse entrée puis écoute en local
                break;
            case 0:
                new UserRPL();
                break;
            default:
                System.out.println("Trop d'arguments");
                break;
        }
        System.out.println("Fin du programme.");
    }

    public UserRPL(){
        this.local = true;
        this.log = "none";
        new ServiceRPL(this.log);
    }

    public UserRPL(String log){
        this.local = true;
        this.log = log;
        new ServiceRPL(log);
    }

    public UserRPL(boolean local){
        this.local = local;
        this.log = "none";
        try{
            Socket socket = new Socket("127.0.0.1", 23456);
            Scanner scanner = new Scanner(System.in);
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true) {
                System.out.print(br.readLine());
                String message = scanner.nextLine().toString();
                socket.getOutputStream().write((message + "\n").getBytes());
                String recu = "";
                while(!recu.equals("fin")){
                    if(!recu.equals("fin")) System.out.println(recu = br.readLine());
                }
                System.out.println("");
                if(message.equals("exit")){
                    break;
                }
            }
            scanner.close();
            socket.close();
        } catch (IOException e) {
            System.out.println("Arrêt du programme : " + e);
        }
    }
}
